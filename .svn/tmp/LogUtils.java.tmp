/**
 * @author MarsCheng
 * @email chengjie@sz.chinalife-p.com.cn
 * 2016年9月6日
 */
package com.chinalife.sz.carcalculate.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * 日志工具类
 * @author MarsCheng
 * @email chengjie@sz.chinalife-p.com.cn
 * 2016年9月6日
 */
public class LogUtils {
	

	public static ExecutorService executorService  = Executors.newSingleThreadExecutor();
	
	public static String writeObject2String(Object object){
		Object object2 = JSON.toJSON(object);
		JSONObject jsonObject = JSON.parseObject(object2.toString());
	    Set<String> keySet=jsonObject.keySet();
	    ArrayList<String> keys=new ArrayList<String>(keySet);
	    for(String key : keys){
	    	if(key.indexOf("Specified")!=-1){
//	    		System.out.println(key);
	    		jsonObject.remove(key);
	    	}else{
	    		Object value = jsonObject.get(key);
	    		try{
	    			JSONObject jsonObject2 = JSON.parseObject(value.toString());
	    			Object clearObject = clear(jsonObject2,"Specified");
	    			jsonObject.put(key, clearObject);
	    		}catch(Exception ex){
	    			
	    		}
	    		}
	    	}
	    		
		String result =jsonObject.toString();
		
//		System.out.println(result);
	
		return result;
	}
	
	//清楚json数组的多余参数
	public static Object clear(JSONObject jsonObject2,String param){
		Set<String> keySet=jsonObject2.keySet();
	    ArrayList<String> keys=new ArrayList<String>(keySet);
		Object clearObject=null;
			for(String key : keys){
		    	if(key.indexOf(param)!=-1){
//		    		System.out.println(key);
		    		jsonObject2.remove(key);
		    	}else{
		    		Object value1 = jsonObject2.get(key);
		    		try{
		    			JSONObject jsonObject3 = JSON.parseObject(value1.toString());
		    			clearObject=clear(jsonObject3, param);
		    			jsonObject2.put(key, clearObject);
		    		}catch(Exception ex){
		    			
		    		}
		    	}
			}
		    		
			clearObject = jsonObject2.clone();
			return clearObject;	
	}

}
