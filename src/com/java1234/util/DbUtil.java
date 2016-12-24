package com.java1234.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbUtil {

	private String dbUrl="jdbc:mysql://localhost:3306/db_jsp?useSSL=false";
	private String dbUserName="root";
	private String dbPassword="123456";
	private String jdbcName="com.mysql.jdbc.Driver";
	
	public Connection getCon() throws Exception{
		Class.forName(jdbcName); //第15步：驱动JDBC
		Connection con=DriverManager.getConnection(dbUrl, dbUserName, dbPassword); //第16步：建立数据库连接
		return con;
	}
	
	public void closeCon(Connection con)throws Exception{
		if(con!=null){
			con.close();
		}
	}
	
	public static void main(String[] args) {
		DbUtil dbUtil=new DbUtil();
		try {
			dbUtil.getCon();
			System.out.println("连接成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}