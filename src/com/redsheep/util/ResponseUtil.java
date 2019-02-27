package com.redsheep.util;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

public class ResponseUtil {

	/***
	 * 向响应写入信息
	 * 
	 * @param resp
	 * @param o
	 * @throws Exception
	 */
	public static void write(HttpServletResponse resp, Object o) throws Exception {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.println(o.toString());
		out.flush();
		out.close();
	}
}
