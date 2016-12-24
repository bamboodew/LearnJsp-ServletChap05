package com.java1234.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * servlet设置：单实例，多线程。需要注意安全。
 * @author Administrator
 *
 */
public class HelloWorldServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; //报错，增加序列。
	//servlet是请求的处理者
	//请求处理分两种：
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("get请求"); //在后台console输出
		this.doPost(request, response); //转给doPost处理
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("GBK");
		PrintWriter out = response.getWriter(); //向页面写入
		out.println("<html>");
		out.println("<head><title>问候大爷</title></head>");
		out.println("Servlet大爷你好！");
		out.println("</html>");
		out.close();
	}
	
}
