package com.yccz.dao;

import java.sql.SQLException;
import java.util.List;

import com.yccz.entity.LoginInfo;
import com.yccz.entity.SignUp;

public interface Dao {

	public List<LoginInfo> daoLogin() throws ClassNotFoundException, SQLException;
	public List<SignUp> daoSignUp() throws ClassNotFoundException, SQLException;
    public boolean infosginup(String name, String pass, String email) throws ClassNotFoundException, SQLException;
}
