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
		String path=request.getServletPath(); //获取用户请求的路径
		
		System.out.println("刷新网页时判断：");
		System.out.println("页面是否为login："+path.indexOf("login")); //【后台】判断页面是不是login.jsp
		System.out.println("页面是否为main："+path.indexOf("main")+"\n");
		
		if(object==null&&path.indexOf("login")<0){ //没登陆成功或超时，且界面路径不是login。
			System.out.println("没登陆成功或超时，且界面路径不是login:跳转至login.jsp！——此处不刷新！！！");
			request.getRequestDispatcher("login.jsp").forward(servletRequest, servletResponse);
			//请求——响应：跳转至login.jsp
		}else{
			System.out.println("若路径为login或登录成功时:继续往下执行!请填写用户名和密码，或显示正确登录结果！");
			filterChain.doFilter(servletRequest, servletResponse); //继续往下执行（是login的时候向下执行）
			System.out.println("输入正确用户和密码后——刷新页面！");
		}
		System.out.println();
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
