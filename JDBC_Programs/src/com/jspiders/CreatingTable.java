package com.jspiders;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreatingTable {
	public static void main(String[] args) {
		
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/first_sql","root","root");
		PreparedStatement pst = con.prepareStatement("create table emp("
				+ "roll int primary key,"
				+ "name varchar(20) not null,"
				+ "age int not null,"
				+ "mobile bigint(10) unique)");
		pst.execute();
		System.out.println("table created");
		con.close();
		
	} catch (ClassNotFoundException | SQLException e) {
		
		e.printStackTrace();
	}
		
}
}
