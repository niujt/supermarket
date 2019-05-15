package com.wxthxy.supermarket.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;
/**
 * 字符串转日期帮助类
 * @author Dell
 *
 */
public class StringtoDateConverter implements Converter<String,Date>{


	/**
	 * 要转换的日期格式
	 */
	private String datePattern;
	/**
	 * 字符串转换到日期
	 * @param datePattern 要转换的日期格式
	 */
	public StringtoDateConverter(String datePattern) {
		//System.out.println(datePattern);
		this.datePattern = datePattern;
	}


	/**
	 * 转换
	 */
	public Date convert(String s) {
		Date date = null;
		try {
			date = new SimpleDateFormat(datePattern).parse(s);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}


}
