package com.chinalife.sz.carcalculate.utils;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by tianwei on 2016/7/21.
 */
public class WebConfigUtils {



	public static String addOneYear(String year){
		if(year==null){
			return null;
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


}
