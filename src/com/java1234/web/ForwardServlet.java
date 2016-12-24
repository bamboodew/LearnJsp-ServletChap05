package com.java1234.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * servlet跳转。
 * 
 * @author Administrator
 *
 */
public class ForwardServlet extends HttpServlet {

	/**
	 * servlet跳转：服务器跳转
	 */
	private static final long serialVersionUID = 1L; // 报错，增加序列。

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("get请求"); // 在后台console输出
		this.doPost(request, response); // 转给doPost处理
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("requestKey", "requestValue");// 键值对；request可以取值（与客户端的区别）

		// 获取session和application
		HttpSession session = request.getSession(); // 通过request接口获取
		session.setAttribute("sessionKey", "sessionValue"); // 设置值
		ServletContext application = this.getServletContext(); // 获取application
		application.setAttribute("applicationKey", "applicationValue"); // 设置值

		RequestDispatcher rd = request.getRequestDispatcher("target.jsp"); // 接口
		rd.forward(request, response); // 服务器跳转/转发
	}

}