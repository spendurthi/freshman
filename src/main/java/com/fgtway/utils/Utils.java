package com.fgtway.utils;

public class Utils {
	public static boolean isEmpty(Object object){
		boolean result = false;
		if (object == null){
			result = true;
		}if (object instanceof String){
			result = object.toString().trim().equals("");
		}
		return result;		
	}
	public static boolean isNull(Object object){
		boolean result = false;
		if (object == null){
			result = true;
		}
		return result;		
	}
}
