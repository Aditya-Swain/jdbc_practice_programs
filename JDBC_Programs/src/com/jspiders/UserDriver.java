package com.jspiders;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UserDriver {
	UserDriver(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_first_jdbc","root","root");
			PreparedStatement pst = con.prepareStatement("INSERT INTO user(id,name,mail,pwd,mobile) VALUES (?,?,?,?,?)");
			Scanner os = new Scanner(System.in);
			boolean flag=true;
			while(flag) {
			System.out.println("enter the id,name,email,password,mobile number");
			int id = os.nextInt();
			String name = os.next();
			String mail = os.next();
			String pwd = os.next();
			double mob = os.nextDouble();
			pst.setInt(1, id);
			pst.setString(2, name);
			pst.setString(3, mail);
			pst.setString(4, pwd);
			pst.setDouble(5, mob);
			pst.executeUpdate();
			System.out.println("inserted successfully");
			System.out.println("press 1 to insert one more row\n or any number to exit");
			int choice = os.nextInt();
			if(choice!=1)
				flag=false;
			}
			System.out.println("_______thank you___________");
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
	}
	public void insert() {
		//con.prepareStatement("INSERT INTO ");
	}
		public static void main(String[] args) {
			UserDriver ud=new UserDriver();
		}
}
