package com.yccz.daoImpl;


import java.sql.SQLException;
import java.util.List;

import com.yccz.BizImpl.BizImpl;
import com.yccz.biz.Biz;
import com.yccz.dao.Basedao;
import com.yccz.dao.Dao;
import com.yccz.entity.LoginInfo;
import com.yccz.entity.SignUp;

public class DaoImpl implements Dao {
	Basedao BaseDao=new Basedao();
	@Override
	public List<LoginInfo> daoLogin() throws ClassNotFoundException, SQLException {
	
		Basedao daseDao=new Basedao();
		List<LoginInfo> list=daseDao.database();
		return list;
		
		
	}

	@Override
	public List<SignUp> daoSignUp() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		List<SignUp> list=BaseDao.signdatabase();
		
		return list;
	}

	@Override
	public boolean infosginup(String name, String pass, String email) throws ClassNotFoundException, SQLException {
		
		boolean flag=BaseDao.infosgin(name,pass,email);
		return flag;
		
		
	}

}
