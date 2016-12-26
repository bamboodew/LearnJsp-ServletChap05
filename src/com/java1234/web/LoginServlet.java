package com.java1234.web;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java1234.dao.UserDao;
import com.java1234.model.User;
import com.java1234.util.DbUtil;

//处理层：servlet
public class LoginServlet extends HttpServlet{
	private static final long serialVersionUID = 1L; //报错，增加序列。
	DbUtil dbUtil=new DbUtil();
	UserDao userDao=new UserDao();
	
	//servlet是请求的处理者
	//请求处理分两种：
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("get请求"); //第9步：加载post方法

		String userName=request.getParameter("userName"); //第10步：从请求request获取userName
		String password=request.getParameter("password"); //第11步：从请求request获取password
		
		Connection con=null; //第12步：建立处理连接
		try {
			User user=new User(userName, password); //第13步：采用构造方法封装user
			con=dbUtil.getCon(); //第14步：发送连接请求。第17步：获取连接。
			
			User currentUser=userDao.login(con, user); //第18步：运行登录UserDao类封装的login方法，登录获取临时“实例user”
			
			if(currentUser==null){ //第19步：检查临时user是否为空？
				System.out.println("No：登录失败！！！");
				
				request.setAttribute("error", "用户名或者密码错误！"); //第20步：为空——请求变request的值变成为error代号，跳转至jsp完成。
				request.setAttribute("userName", userName);
				request.setAttribute("password", password);
				request.getRequestDispatcher("login.jsp").forward(request, response); //第21步：响应结果。
				
				System.out.println("响应结果：用户名或者密码错误！——程序结束！");
			}else{ 
				System.out.println("Yes：登录成功！！！");
				HttpSession session=request.getSession(); //第20步：request请求，获取session会话的通讯结果。
				session.setAttribute("currentUser", currentUser); //给会话赋值
				response.sendRedirect("main.jsp"); //第21步：响应：重定向
				System.out.println("响应：重定向至main.jsp——并刷新页面！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("出错！");
		}
	}
	
}
