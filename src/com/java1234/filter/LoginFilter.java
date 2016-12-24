package com.java1234.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter{ //继承Filter接口

	@Override
	//过滤方法：先配置web.xml
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
	//FilterChain：继续往下执行
			throws IOException, ServletException {
		
		HttpServletRequest request=(HttpServletRequest)servletRequest; //强转
		HttpSession session=request.getSession(); //获取session
		Object object=session.getAttribute("currentUser");
		if(object==null){ //没登陆或超时
			request.getRequestDispatcher("login.jsp").forward(servletRequest, servletResponse);
			//请求——响应：跳转值login.jsp
		}else{
			filterChain.doFilter(servletRequest, servletResponse); //继续往下执行
		}
	}

	@Override
	//销毁方法
	public void destroy() {
		Filter.super.destroy();
	}

	@Override
	//初始化方法
	public void init(FilterConfig filterConfig) throws ServletException {
		Filter.super.init(filterConfig);
	}
}
