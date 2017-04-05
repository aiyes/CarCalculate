package com.chinalife.sz.carcalculate.utils;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.axiom.om.OMElement;
import org.apache.axis2.AxisFault;
import org.apache.axis2.databinding.utils.BeanUtil;
import org.apache.axis2.engine.DefaultObjectSupplier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import javax.xml.namespace.QName;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.rmi.RemoteException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by tianwei on 2016/7/21.
 */
public class ConfigUtils {
	private static Logger logger= LoggerFactory.getLogger(ConfigUtils.class);
	public static Properties pop;
	static {
		Resource resource = new ClassPathResource("web/requestConfig.properties");
		Resource interfaceServiceResource = new ClassPathResource("web/InterfaceService.properties");
		Resource riskcodeResource = new ClassPathResource("web/riskcode.properties");
		Resource basicConfigResource= new ClassPathResource("web/basicConfig.properties");
		//InputStream inputStream = null;
	     pop = new Properties();
		try {
			InputStream	inputStream = resource.getInputStream();
			InputStream	interfaceServicInputStream =interfaceServiceResource.getInputStream();
			InputStream	riskcodeInputStream =riskcodeResource.getInputStream();
			InputStream	basicConfigInputStream =basicConfigResource.getInputStream();
			pop.load(inputStream);
			pop.load(interfaceServicInputStream);
			pop.load(riskcodeInputStream);
			pop.load(basicConfigInputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

public static <T> T setProperties(T object){
	PropertyDescriptor[] pds = BeanUtils.getPropertyDescriptors(object.getClass());
	for(PropertyDescriptor pd:pds){
       if(pop.getProperty(pd.getName())!=null&&pd.getWriteMethod()!=null){
		   try {
			   pd.getWriteMethod().invoke(object,pop.getProperty(pd.getName()));
		   } catch (IllegalAccessException e) {
			   e.printStackTrace();
		   } catch (InvocationTargetException e) {
			   e.printStackTrace();
		   }
	   }
	}

	return object;
}
	public static final <T1, T2> T2 simpleBeanConvert(T1 t1, Class<T2> c2) {
		Object srcobj = t1;
		if (null == t1)
			return null;
		try{

			if (java.util.Collection.class.isAssignableFrom(t1.getClass())
					|| java.util.Collection.class.isAssignableFrom(c2)) {
				throw new AxisFault("DON'T SUPPORT Collection");

			}
			OMElement element = null;
			//将对象序列化转为xml(OMElement)
			if (srcobj.getClass().isArray()) {
				//数组对象区分处理
				String className = srcobj.getClass().getComponentType().getSimpleName();
				element = BeanUtil.getOMElement(new QName("root"), (Object[]) srcobj, new QName(className), false, null);
			} else {//一般对象
				element = BeanUtil.getOMElement(new QName("root"), new Object[] {srcobj}, new QName(srcobj.getClass().getSimpleName()), false, null).getFirstElement();
			}
			//调用 processObject方法将xml对象(OMElement)反序列化转为指定类的对象
			return (T2) BeanUtil.processObject(element, c2, null, srcobj.getClass().isArray(), new DefaultObjectSupplier(),
					null);
		}
        catch (AxisFault axisFault){
			return null;
		}

		//return null;
	}

  public static <T> T   setSingleProperties(T source,Object target) throws InvocationTargetException, IllegalAccessException {

//	  System.out.println(target.getClass().getSimpleName());
	  PropertyDescriptor pd = BeanUtils.getPropertyDescriptor(source.getClass(), target.getClass().getSimpleName());

	  if(pd!=null&&BeanUtils.getWriteMethodParameter(pd).getParameterType().getSimpleName().equals(target.getClass().getSimpleName())){
		  pd.getWriteMethod().invoke(source,target);
		  //return source;
	  }
	  return source;
  }
	public static Class findClassByName(Class clazz,String className){
		Class[] classes = clazz.getDeclaredClasses();
		for(Class clzz:classes){
			//System.out.println(clzz.getSimpleName()+"      "+className);
			if(clzz.getSimpleName().equals(className)){
				return clzz;
			}
		}
		return null;
	}

	public static  int getAge(String identityNumber)   {
		String s =identityNumber.substring(6,14);
		DateFormat df = new SimpleDateFormat("yyyyMMdd");
		Date date = null;
		try {
			date = df.parse(s);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Calendar calendar=Calendar.getInstance();
		int nowYear = calendar.get(Calendar.YEAR);
		int nowMonth = calendar.get(Calendar.MONTH)+1;
		int nowday = calendar.get(Calendar.DAY_OF_MONTH);
		calendar.setTime(date);
//		System.out.println(calendar.getTime());
		int birthYear = calendar.get(Calendar.YEAR);
		int birthMonth = calendar.get(Calendar.MONTH)+1;
		int birthday = calendar.get(Calendar.DAY_OF_MONTH);

		int year=nowYear-birthYear;
		if(year<0){
			year=-1;
		}
		else{
			if(nowMonth<birthMonth){
				year--;
			}
			if(nowMonth==birthMonth){
				if(nowday<birthday){
					year--;
				}
			}
		}

		return year;
	}
	public static String addOneYear(String year){
		if(year==null){
			throw null;
		}
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date date=null;
		try {
			 date = df.parse(year);

		}
		catch (ParseException e) {
			e.printStackTrace();
		}
		Calendar calendar =Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.YEAR, 1);
		 date = calendar.getTime();
		 year = df.format(date);
		return year;
	}
	public static void  setRequest(Object stub,Object request,String... type)  {
		Class<?> stubClass = stub.getClass();
		if(type.length==0){
			try{
				Class txInsuranceRequestExtensionEhm = ConfigUtils.findClassByName(stubClass, "TXInsuranceRequestExtensionEhm");
				Object extensionEhm = txInsuranceRequestExtensionEhm.newInstance();
				ConfigUtils.setMainInfo(extensionEhm, "tXInsuranceRequestExtension");

				Class txInsuranceRequestEhm = ConfigUtils.findClassByName(stubClass, "TXInsuranceRequestEhm");
				Object ehm = txInsuranceRequestEhm.newInstance();
				ConfigUtils.setMainInfo(ehm, "tXInsuranceRequest");

				Class iInsuranceExtensionEhm = ConfigUtils.findClassByName(stubClass, "IInsuranceExtensionEhm");
				Object Iehm = iInsuranceExtensionEhm.newInstance();
				ConfigUtils.setMainInfo(Iehm, "iInsuranceExtension");
				ConfigUtils.setSingleProperties(request, extensionEhm);
				ConfigUtils.setSingleProperties(ehm,Iehm);
				ConfigUtils.setSingleProperties(request, ehm);
			}
			catch (InstantiationException e){
				e.printStackTrace();
				logger.error(e.getLocalizedMessage());
			}
			catch (IllegalAccessException e){
				e.printStackTrace();
				logger.error(e.getLocalizedMessage());
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		}
        if(type.length==1){
			if("noEhm".equals(type[0])){
				try{
					Class txInsuranceRequestExtension = ConfigUtils.findClassByName(stubClass, "TXInsuranceRequestExtension");
					Object extension = txInsuranceRequestExtension.newInstance();
					ConfigUtils.setMainInfo(extension, "tXInsuranceRequestExtension");

					Class txInsuranceRequest = ConfigUtils.findClassByName(stubClass, "TXInsuranceRequest");
					Object ehm = txInsuranceRequest.newInstance();
					ConfigUtils.setMainInfo(ehm, "tXInsuranceRequest");

					Class iInsuranceExtension = ConfigUtils.findClassByName(stubClass, "IInsuranceExtension");
					Object Iehm = iInsuranceExtension.newInstance();
					ConfigUtils.setMainInfo(Iehm, "iInsuranceExtension");
					ConfigUtils.setSingleProperties(request, extension);
					ConfigUtils.setSingleProperties(ehm,Iehm);
					ConfigUtils.setSingleProperties(request, ehm);
				}
				catch (InstantiationException e){
					e.printStackTrace();
					logger.error(e.getLocalizedMessage());
				}
				catch (IllegalAccessException e){
					e.printStackTrace();
					logger.error(e.getLocalizedMessage());
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}

			}
		}


	}



	public static Object formatJson(Object obj) {
		Object json = JSON.toJSON(obj);
		if (json instanceof JSONObject) {
			JSONObject jsonObject = (JSONObject) json;
			Set<Map.Entry<String, Object>> entries = jsonObject.entrySet();
			Iterator it = entries.iterator();
			while (it.hasNext()) {
				Map.Entry<String, Object> map = (Map.Entry) it.next();
				if (map.getKey().endsWith("Specified")) {
					it.remove();
					continue;
				} else {
					Object value = map.getValue();
					if (!(value instanceof String) && !(value instanceof Integer) && !(value instanceof Double)) {
						formatJson(value);
					}
				}
			}
		}
		if (json instanceof JSONArray) {
			JSONArray jsonArray = (JSONArray) json;
			Iterator<Object> iterator = jsonArray.iterator();
			while (iterator.hasNext()) {
				JSONObject next = (JSONObject) iterator.next();
				formatJson(next);
			}
		}
		return json;

	}
//从参数读取值
	public static void setMainInfo(Object obj, String type) {
		PropertyDescriptor[] pds = BeanUtils.getPropertyDescriptors(obj.getClass());
		for (PropertyDescriptor pd : pds) {
			if (pd.getWriteMethod() != null && pop.getProperty( type + "." + pd.getName()) != null) {

				String propertyValue = pop.getProperty( type + "." + pd.getName());
				if (propertyValue.startsWith("$") && propertyValue.endsWith("$")) {
					Date date = new Date();
					DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String formatDate = df.format(date);

					Calendar calendar = Calendar.getInstance();
					calendar.setTime(date);
					calendar.add(Calendar.DAY_OF_MONTH, 1);
					Date nextDate = calendar.getTime();
					String formatNextDate = df.format(nextDate);

					calendar.setTime(date);
					calendar.add(Calendar.YEAR, 1);
					Date nextYear = calendar.getTime();
					String formatNextYear = df.format(nextYear);

					if ("$sysdate$".equals(propertyValue)) {
						propertyValue = formatDate.substring(0, 10);
					}
					if ("$systime$".equals(propertyValue)) {
						propertyValue = formatDate.substring(11, formatDate.length());
					}
					if ("$nextdate$".equals(propertyValue)) {
						propertyValue = formatNextDate.substring(0, 10);
					}
					if ("$nextyear$".equals(propertyValue)) {
						propertyValue = formatNextYear.substring(0, 10);
					}
				}
				try {
					pd.getWriteMethod().invoke(obj, propertyValue);
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) throws ClassNotFoundException, RemoteException, IllegalAccessException, InvocationTargetException, InstantiationException {
		String value = getValue("001");

		System.out.println(value);
	}

	public static  String getValue(String key){
		return pop.getProperty(key);
	}


}
