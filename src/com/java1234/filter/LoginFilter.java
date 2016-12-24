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

public class LoginFilter implements Filter{ //�̳�Filter�ӿ�

	@Override
	//���˷�����������web.xml
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
	//FilterChain����������ִ��
			throws IOException, ServletException {
		
		HttpServletRequest request=(HttpServletRequest)servletRequest; //ǿת
		HttpSession session=request.getSession(); //��ȡsession
		Object object=session.getAttribute("currentUser");
		if(object==null){ //û��½��ʱ
			request.getRequestDispatcher("login.jsp").forward(servletRequest, servletResponse);
			//���󡪡���Ӧ����תֵlogin.jsp
		}else{
			filterChain.doFilter(servletRequest, servletResponse); //��������ִ��
		}
	}

	@Override
	//���ٷ���
	public void destroy() {
		Filter.super.destroy();
	}

	@Override
	//��ʼ������
	public void init(FilterConfig filterConfig) throws ServletException {
		Filter.super.init(filterConfig);
	}
}
