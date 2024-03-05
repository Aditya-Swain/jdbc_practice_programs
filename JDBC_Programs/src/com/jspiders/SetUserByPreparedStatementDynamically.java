package com.jspiders;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class SetUserByPreparedStatementDynamically {
	 static Scanner os= new Scanner(System.in);
		public static void main(String[] args) throws InterruptedException {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_first_jdbc","root","root");
				PreparedStatement pst = con.prepareStatement("insert into user(id,name,mail,pwd,mobile) values(?,?,?,?,?)");
				boolean flag=true;
				while(flag) {
				System.out.println("enter your id,name,email,password,mobile");
				int id= os.nextInt();
				String name = os.next();
				String email = os.next();
				String password = os.next();
				Long mobile = os.nextLong();
				
				pst.setInt(1, id);
				pst.setString(2, name);
				pst.setString(3, email);
				pst.setString(4, password);
				pst.setLong(5, mobile);
				
				pst.executeUpdate();
				System.out.println("successfully inserted");
				Thread.sleep(2000);
				System.out.println("Will you want to insert one more row\npress 1 to insert \n or press any number ");
				int n= os.nextInt();
				
				if(n!=1) 
					flag=false;
			
				}
				System.out.println("____________________________THANK YOU________________________");
				
				con.close();
				
				
				
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}
