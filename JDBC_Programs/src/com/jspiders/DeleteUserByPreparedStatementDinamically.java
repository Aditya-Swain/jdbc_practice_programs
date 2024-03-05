package com.jspiders;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteUserByPreparedStatementDinamically {
	static Scanner os= new Scanner(System.in);
		public static void main(String[] args) throws InterruptedException {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_first_jdbc","root","root");
				PreparedStatement pst = con.prepareStatement("delete from user where id=?");
				boolean flag=true;
				while(flag) {
				System.out.println("enter the id which you want to delete");
				int id = os.nextInt();
				
				pst.setInt(1, id);
				pst.executeUpdate();
				System.out.println("successfully deleted");
				Thread.sleep(2000);
				System.out.println("will you want to delete one more row\n press 0 to delete \n or press any number");
				int choice = os.nextInt();
				if(choice!=0)
					flag=false;
				}
				System.out.println("_________________thank you_______________");
				con.close();
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}
