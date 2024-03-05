package com.jspiders;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateUserByPreparedStatementDinamically {
	static Scanner os= new Scanner(System.in);
		public static void main(String[] args) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_first_jdbc","root","root");
				PreparedStatement pst = con.prepareStatement("update  user set name=? ,mail=? ,pwd=?, mobile=? where id=?");
				System.out.println("enter id and new name,email,password,mobile to update");
				int id= os.nextInt();
				String name = os.next();
				String email = os.next();
				String pass = os.next();
				Long mobile = os.nextLong();
				
				pst.setInt(1, id);
				pst.setString(2, name);
				pst.setString(3, email);
				pst.setString(4, pass);
				pst.setLong(5,mobile);
				
				
				pst.executeUpdate();
				System.out.println("successfully updated");
				con.close();
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
}
