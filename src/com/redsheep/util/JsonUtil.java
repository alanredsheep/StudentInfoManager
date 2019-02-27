package com.redsheep.util;

import java.sql.ResultSet;
import java.util.Date;

import org.apache.commons.httpclient.util.DateUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class JsonUtil {

	/***
	 * 把ResultSet格式转化为Json格式
	 * 
	 * @param rs
	 * @return json数组
	 * @throws Exception
	 */
	public static JSONArray formatRsToJsonArray(ResultSet rs) throws Exception {
		java.sql.ResultSetMetaData md = rs.getMetaData();
		int num = md.getColumnCount();
		JSONArray array = new JSONArray();
		while (rs.next()) {
			JSONObject mapOfColValues = new JSONObject();
			for (int i = 1; i <= num; i++) {
				Object o = rs.getObject(i);
				if (o instanceof Date) {
					mapOfColValues.put(md.getColumnName(i), DateUtil.formatDate((Date) o, "yyyy-MM-dd"));
				} else {
					mapOfColValues.put(md.getColumnName(i), rs.getObject(i));
				}
			}
			array.add(mapOfColValues);
		}
		return array;
	}
}
