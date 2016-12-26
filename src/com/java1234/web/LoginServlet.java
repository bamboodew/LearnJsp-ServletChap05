package com.java1234.web;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java1234.dao.UserDao;
import com.java1234.model.User;
import com.java1234.util.DbUtil;

//����㣺servlet
public class LoginServlet extends HttpServlet{
	private static final long serialVersionUID = 1L; //�����������С�
	DbUtil dbUtil=new DbUtil();
	UserDao userDao=new UserDao();
	
	//servlet������Ĵ�����
	//����������֣�
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("get����"); //��9��������post����

		String userName=request.getParameter("userName"); //��10����������request��ȡuserName
		String password=request.getParameter("password"); //��11����������request��ȡpassword
		
		Connection con=null; //��12����������������
		try {
			User user=new User(userName, password); //��13�������ù��췽����װuser
			con=dbUtil.getCon(); //��14���������������󡣵�17������ȡ���ӡ�
			
			User currentUser=userDao.login(con, user); //��18�������е�¼UserDao���װ��login��������¼��ȡ��ʱ��ʵ��user��
			
			if(currentUser==null){ //��19���������ʱuser�Ƿ�Ϊ�գ�
				System.out.println("No����¼ʧ�ܣ�����");
				
				request.setAttribute("error", "�û��������������"); //��20����Ϊ�ա��������request��ֵ���Ϊerror���ţ���ת��jsp��ɡ�
				request.setAttribute("userName", userName);
				request.setAttribute("password", password);
				request.getRequestDispatcher("login.jsp").forward(request, response); //��21������Ӧ�����
				
				System.out.println("��Ӧ������û�������������󣡡������������");
			}else{ 
				System.out.println("Yes����¼�ɹ�������");
				HttpSession session=request.getSession(); //��20����request���󣬻�ȡsession�Ự��ͨѶ�����
				session.setAttribute("currentUser", currentUser); //���Ự��ֵ
				response.sendRedirect("main.jsp"); //��21������Ӧ���ض���
				System.out.println("��Ӧ���ض�����main.jsp������ˢ��ҳ�棡");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("����");
		}
	}
	
}
