package com.java1234.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * servlet���ã���ʵ�������̡߳���Ҫע�ⰲȫ��
 * @author Administrator
 *
 */
public class HelloWorldServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; //�����������С�
	//servlet������Ĵ�����
	//����������֣�
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("get����"); //�ں�̨console���
		this.doPost(request, response); //ת��doPost����
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("GBK");
		PrintWriter out = response.getWriter(); //��ҳ��д��
		out.println("<html>");
		out.println("<head><title>�ʺ��ү</title></head>");
		out.println("Servlet��ү��ã�");
		out.println("</html>");
		out.close();
	}
	
}
