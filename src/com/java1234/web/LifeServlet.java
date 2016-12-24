package com.java1234.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LifeServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; //报错，增加序列。
	//servlet是请求的处理者
	//请求处理分两种：
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet的service服务");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost的service服务");
	}

	@Override
	public void destroy() {
		System.out.println("servlet销毁"); //一段时间不使用就回销毁，在后台console显示。
	}

	@Override
	public void init() throws ServletException {
		System.out.println("servlet初始化");
		//实例化调用。请求时只执行一次，在此请求不再执行。长时间不使用销毁之后，再次请求时才会执行。
	}
	
}
