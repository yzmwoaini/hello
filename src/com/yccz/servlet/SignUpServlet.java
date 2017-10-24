package com.yccz.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yccz.BizImpl.BizImpl;
import com.yccz.biz.Biz;

public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = -7396469309001977606L;
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	String name=req.getParameter("name");
	String email=req.getParameter("email");
	String pass=req.getParameter("password");
	resp.setContentType("text/html;charset=UTF-8");
	Biz biz=new BizImpl();
	try {
		int ho=biz.Servletsignup(name, pass, email);
		switch (ho) {
		case 0:
			boolean flag=biz.infosgin(name, pass, email);
			if(flag==true) {
				System.out.println("注册成功");
				resp.sendRedirect("menu.html");
			}
			else {
				System.out.println("注册失败");
				resp.sendRedirect("index.jsp");
			}
			break;
        case 1:
	        String re="账户已经被注册";
			resp.sendRedirect("index.jsp");
			resp.getWriter().write(re);
			
			break;
        case 2:
        	resp.sendRedirect("index.jsp");
	        break;
		default:
			break;
		}
		
		
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}

}
