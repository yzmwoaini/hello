package com.yccz.BizImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yccz.biz.Biz;
import com.yccz.dao.Dao;
import com.yccz.daoImpl.DaoImpl;
import com.yccz.entity.LoginInfo;
import com.yccz.entity.SignUp;

public class BizImpl implements Biz {

	private String JDadmin;
	private String JDpass;
	Dao dao=new DaoImpl();
	@Override//�˺���֤��ȡ���ݲ�ֵ
	public List<LoginInfo> DaoLogin() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
	
		List<LoginInfo> list=dao.daoLogin();
		return list;
	}

	
	@Override//�˺���֤�����Ƿ���֤�ɹ�
	public boolean Servletlogin(String name, String pass) throws ClassNotFoundException, SQLException {
		boolean flag=false;
		List<LoginInfo> li=DaoLogin();
		for (int i = 0; i < li.size(); i++) {
			LoginInfo ko=li.get(i);
			if(ko.getUsername().equals(name)&&ko.getPassword().equals(pass)) {
				flag=true;
				break;
			}
			
			
		}
		return flag;
	}


	@Override//��֤ע���Ƿ�ɹ�
	public int Servletsignup(String name, String pass, String email) throws ClassNotFoundException, SQLException {
	
	
	int value =0;
	List<SignUp> li=Daosign();
	for (int i = 0; i < li.size(); i++) {
		SignUp ko=li.get(i);
		if(ko.getUsername().equals(name)){
			value=1;
			break;
		}
		else if(ko.getEmail().equals(email)) {
			value=2;
			break;
		}
		
		
	}
	return value;
	}


	@Override
	public List<SignUp> Daosign() throws ClassNotFoundException, SQLException {
		List<SignUp> list=dao.daoSignUp();
		return list;
	}


	@Override
	public boolean infosgin(String name, String pass, String email) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		boolean flag=dao.infosginup(name, pass, email);
		
		return flag;
	}

	

}
