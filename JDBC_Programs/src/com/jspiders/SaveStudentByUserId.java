package com.jspiders;

import java.sql.*;
import java.util.Scanner;

public class SaveStudentByUserId {
		public static void main(String[] args)  {
			Scanner os = new Scanner(System.in);
			System.out.println("Enter the student id,name,age,mobile");
			int id= os.nextInt();
			String name=os.next();
			int age = os.nextInt();
			long mobile = os.nextLong();
			
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/my_first_jdbc","root","root");
				Statement stmt= con.createStatement();
				String sql= "insert into student values("+id+",'"+name+"',"+age+","+mobile+")";
				stmt.execute(sql);
				con.close();
				System.out.println("inserted");
			} catch (ClassNotFoundException | SQLException e) {
				
				e.printStackTrace();
			}
			
		}
}
