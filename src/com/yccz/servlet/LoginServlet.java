package com.yccz.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yccz.BizImpl.BizImpl;
import com.yccz.biz.Biz;

public class LoginServlet extends HttpServlet {


	private static final long serialVersionUID = 446454007721309618L;

@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	String admin=req.getParameter("username");
	String password=req.getParameter("password");
	Biz biz=new BizImpl();
	try {
		boolean flag=biz.Servletlogin(admin, password);
		if(flag==true) {
			resp.sendRedirect("menu.html");	
		}
		else {
			resp.sendRedirect("index.html");
		}
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
}	
}
