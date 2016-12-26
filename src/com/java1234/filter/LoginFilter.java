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
		String path=request.getServletPath(); //��ȡ�û������·��
		
		System.out.println("ˢ����ҳʱ�жϣ�");
		System.out.println("ҳ���Ƿ�Ϊlogin��"+path.indexOf("login")); //����̨���ж�ҳ���ǲ���login.jsp
		System.out.println("ҳ���Ƿ�Ϊmain��"+path.indexOf("main")+"\n");
		
		if(object==null&&path.indexOf("login")<0){ //û��½�ɹ���ʱ���ҽ���·������login��
			System.out.println("û��½�ɹ���ʱ���ҽ���·������login:��ת��login.jsp�������˴���ˢ�£�����");
			request.getRequestDispatcher("login.jsp").forward(servletRequest, servletResponse);
			//���󡪡���Ӧ����ת��login.jsp
		}else{
			System.out.println("��·��Ϊlogin���¼�ɹ�ʱ:��������ִ��!����д�û��������룬����ʾ��ȷ��¼�����");
			filterChain.doFilter(servletRequest, servletResponse); //��������ִ�У���login��ʱ������ִ�У�
			System.out.println("������ȷ�û�������󡪡�ˢ��ҳ�棡");
		}
		System.out.println();
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
