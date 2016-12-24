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
 * servlet��ת��
 * 
 * @author Administrator
 *
 */
public class ForwardServlet extends HttpServlet {

	/**
	 * servlet��ת����������ת
	 */
	private static final long serialVersionUID = 1L; // �����������С�

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("get����"); // �ں�̨console���
		this.doPost(request, response); // ת��doPost����
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("requestKey", "requestValue");// ��ֵ�ԣ�request����ȡֵ����ͻ��˵�����

		// ��ȡsession��application
		HttpSession session = request.getSession(); // ͨ��request�ӿڻ�ȡ
		session.setAttribute("sessionKey", "sessionValue"); // ����ֵ
		ServletContext application = this.getServletContext(); // ��ȡapplication
		application.setAttribute("applicationKey", "applicationValue"); // ����ֵ

		RequestDispatcher rd = request.getRequestDispatcher("target.jsp"); // �ӿ�
		rd.forward(request, response); // ��������ת/ת��
	}

}