package com.java1234.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.java1234.model.User;

//登录工具
public class UserDao {
	
	public User login(Connection con,User user) throws Exception{
		User resultUser=null;
		String sql="select * from t_user where userName=? and password=?";
		PreparedStatement pstmt=con.prepareStatement(sql); //预编译
		pstmt.setString(1, user.getUserName()); //user是参数，源于文本框的输入
		pstmt.setString(2, user.getPassword());
		ResultSet rs=pstmt.executeQuery(); //返回集合set
		if(rs.next()){
			resultUser=new User();
			resultUser.setUserName(rs.getString("userName")); //从数据库获取
			resultUser.setPassword(rs.getString("password"));
		}
		return resultUser;
	}
}
