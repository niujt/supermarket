package com.wxthxy.market.util;
/**
 * 常量类
 * @author Dell
 *
 */
public class Constants {

public static final	String SESSION = "userSession";
/**
 * 页面容量
 */
public static final int pageSize = 10; 

/**
 * error
 */
public static String error;

public static String getError() {
	return error;
}

public static void setError(String error) {
	Constants.error = error;
}

}
