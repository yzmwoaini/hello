package com.yccz.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sun.xml.internal.ws.message.EmptyMessageImpl;
import com.yccz.entity.LoginInfo;
import com.yccz.entity.SignUp;

public class Basedao {

	private static String url = "jdbc:mysql://localhost:3306/food"; 
	private  static String username = "root"; 
	private  static String password = "root"; 
	private Connection connection=null;
	private Statement statement=null;
	
	public List<LoginInfo> database() throws ClassNotFoundException, SQLException {
		List<LoginInfo> lo=new ArrayList();
		Class.forName("com.mysql.jdbc.Driver");
		connection=DriverManager.getConnection(url, username, password);
		statement=connection.createStatement();
		ResultSet resultSet=statement.executeQuery("select *from admin");
		while(resultSet.next()) {
			String name=resultSet.getString("username");
			String pass=resultSet.getString("password");
			LoginInfo info=new LoginInfo(name, pass);
			lo.add(info);
		}
		return lo;
	}
	
	public List<SignUp> signdatabase() throws ClassNotFoundException, SQLException {
		List<SignUp> lo=new ArrayList();
		Class.forName("com.mysql.jdbc.Driver");
		connection=DriverManager.getConnection(url, username, password);
		statement=connection.createStatement();
		ResultSet resultSet=statement.executeQuery("select *from signup");
	    while(resultSet.next()) {
	    	String name=resultSet.getString("username");
	    	String pass=resultSet.getString("password");
	    	String email=resultSet.getString("email");
	    	SignUp ko=new SignUp(name, pass, email);
	    	lo.add(ko);
	    }
		
		return lo;
	}
	
	
	public boolean infosgin(String name, String pass, String email) throws ClassNotFoundException, SQLException {
		boolean flag=false;
		PreparedStatement  prep=null,Aprep=null;
		Class.forName("com.mysql.jdbc.Driver");
		connection=DriverManager.getConnection(url, username, password);
		statement=connection.createStatement();
		String sql="insert into signup(username,password,email) values(?,?,?)";
		prep=connection.prepareStatement(sql);
		String Asql="insert into admin(username,password)values(?,?)";
		Aprep=connection.prepareStatement(Asql);
		Aprep.setString(1, name);
		Aprep.setString(2, pass);
		
		prep.setString(1, name);
		prep.setString(2, pass);
		prep.setString(3, email);
		int ko=prep.executeUpdate();
		int lo=Aprep.executeUpdate();
		if(ko>0&&lo>0) {
			flag=true;
		}
		return flag;
		
	}
	
}
