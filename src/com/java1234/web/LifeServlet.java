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
	private static final long serialVersionUID = 1L; //�����������С�
	//servlet������Ĵ�����
	//����������֣�
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet��service����");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost��service����");
	}

	@Override
	public void destroy() {
		System.out.println("servlet����"); //һ��ʱ�䲻ʹ�þͻ����٣��ں�̨console��ʾ��
	}

	@Override
	public void init() throws ServletException {
		System.out.println("servlet��ʼ��");
		//ʵ�������á�����ʱִֻ��һ�Σ��ڴ�������ִ�С���ʱ�䲻ʹ������֮���ٴ�����ʱ�Ż�ִ�С�
	}
	
}
