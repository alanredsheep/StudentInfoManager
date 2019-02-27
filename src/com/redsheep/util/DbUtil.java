package com.redsheep.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbUtil {

	private static String jdbcName = "com.mysql.cj.jdbc.Driver";

	private static String dbUrl = "jdbc:mysql://localhost:3306/db_studentinfo?serverTimezone=UTC";

	private static String dbUserName = "root";

	private static String dbPassword = "1234";

	/**
	 * Open MySQL Connection
	 * 
	 * @return
	 * @throws Exception
	 */
	public Connection getCon() throws Exception {
		Class.forName(jdbcName);
		Connection Con = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
		return Con;
	}

	/**
	 * Close MySQL Connection
	 * 
	 * @param con
	 * @throws Exception
	 */
	public static void closeCon(Connection con) throws Exception {
		if (con != null) {
			con.close();
		}
	}

	public static void main(String[] args) {
		DbUtil dbUtil = new DbUtil();
		try {
			dbUtil.getCon();
			System.out.println("MySQL connected");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
