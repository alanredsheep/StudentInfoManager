package com.redsheep.util;

/**
 * String ¹¤¾ßÀà
 * 
 * @author Redsheep
 *
 */
public class StringUtil {

	/**
	 * ÅÐ¶Ï×Ö·û´®ÊÇ·ñÎª¿Õ
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		if (str == null || "".equals(str.trim())) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * ÅÐ¶Ï×Ö·û´®ÊÇ·ñ²»Îª¿Õ
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNotEmpty(String str) {
		return !isEmpty(str);
	}
}
