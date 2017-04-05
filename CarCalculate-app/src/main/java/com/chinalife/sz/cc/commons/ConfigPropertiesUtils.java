package com.chinalife.sz.cc.commons;

import java.io.IOException;
import java.util.Properties;

import com.prs.framework.core.common.util.io.PropertiesUtils;

public class ConfigPropertiesUtils {
	
	private static final String PROPERTIES_FILE_NAME = "biz/config-app.properties";
	private static Properties _PRO = null;
	
	static {
		try {
			_PRO = PropertiesUtils.loadProperties(PROPERTIES_FILE_NAME);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String getPropertie(String key, String defaultValue) {
		return _PRO.getProperty(key, defaultValue);
	}
	
	public static String getPropertie(String key) {
		return _PRO.getProperty(key);
	}
	
	
	private ConfigPropertiesUtils() {}
	
	
	public static void main(String[] args) {
		String smsUid = ConfigPropertiesUtils.getPropertie("cargo.fee.express");
		System.out.println(smsUid);		
	}
	
}
