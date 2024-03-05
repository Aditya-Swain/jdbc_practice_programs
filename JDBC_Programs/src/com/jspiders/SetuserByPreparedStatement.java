package com.jspiders;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SetuserByPreparedStatement {
		public static void main(String[] args) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_first_jdbc","root","root");
				PreparedStatement pst = con.prepareStatement("insert into user(id,name,mail,pwd,mobile) values(?,?,?,?,?)");
				
				pst.setInt(1,1009);
				pst.setString(2,"satoru");
				pst.setString(3, "satoru@gmail.com");
				pst.setString(4,"satoru645");
				pst.setLong(5, 8978656667l);
				pst.executeUpdate();
				System.out.println("successfully inserted");
				con.close();
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
}
