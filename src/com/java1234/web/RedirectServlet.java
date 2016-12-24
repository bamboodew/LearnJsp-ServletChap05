package com.java1234.web;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * servlet跳转。
 * @author Administrator
 *
 */
public class RedirectServlet extends HttpServlet{

	/**
	 * servlet跳转：客户端跳转
	 */
	private static final long serialVersionUID = 1L; //报错，增加序列。
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("get请求"); //在后台console输出
		this.doPost(request, response); //转给doPost处理
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("requestKey", "requestValue"); //键值对；request无法取值（为空）
		
		//获取session和application
		HttpSession session=request.getSession(); //通过request接口获取
		session.setAttribute("sessionKey", "sessionValue"); //设置值
		ServletContext application=this.getServletContext(); //获取application			
		application.setAttribute("applicationKey", "applicationValue"); //设置值
		
		response.sendRedirect("target.jsp"); //跳转或重定向至客户端
	}
	
}
