package com.yccz.biz;

import java.sql.SQLException;
import java.util.List;

import com.yccz.entity.LoginInfo;
import com.yccz.entity.SignUp;

public interface Biz {

	public boolean Servletlogin(String name,String pass) throws ClassNotFoundException, SQLException;
	public List<LoginInfo> DaoLogin() throws ClassNotFoundException, SQLException;
	public int Servletsignup(String name, String pass,String email) throws ClassNotFoundException, SQLException; 
	public List<SignUp> Daosign() throws ClassNotFoundException, SQLException;
	public boolean infosgin(String name, String pass, String email) throws ClassNotFoundException, SQLException;
}
