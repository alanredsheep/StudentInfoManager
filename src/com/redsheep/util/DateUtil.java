package com.redsheep.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	/***
	 * ����ת�ַ�����ʽ
	 * 
	 * @param date
	 * @param format
	 * @return ���ڵ��ַ�����ʾ
	 */
	public static String formatDate(Date date, String format) {
		String result = "";
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		if (date != null) {
			result = sdf.format(date);
		}
		return result;
	}

	/***
	 * �ַ���ת���ڸ�ʽ
	 * 
	 * @param str
	 * @param format
	 * @return ����
	 * @throws Exception
	 */
	public static Date formatString(String str, String format) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.parse(str);
	}
}
