package com.jdbc.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class UserRepository {
		static Scanner os =new Scanner(System.in);
	static	Connection con;
		UserRepository(){
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_first_jdbc","root","root");
			} catch (ClassNotFoundException | SQLException e) {
				
				e.printStackTrace();
			}
			
		}   
		
		//insert
	public void insert() {
		try {
		
			PreparedStatement pst = con.prepareStatement("INSERT INTO user VALUES(?,?,?,?,?)");
			boolean flag =true;
			while(flag) {
			System.out.println("enter the id,name,email,password and mobile number");
			int id = os.nextInt();
			String name = os.next();
			String mail = os.next();
			String pwd = os.next();
			Double mob = os.nextDouble();
			
						
			pst.setInt(1, id);
			pst.setString(2, name);
			pst.setString(3, mail);
			pst.setString(4,pwd);
			pst.setDouble(5, mob);
			
			pst.addBatch();
			System.out.println("data inserted");
		
			System.out.println("will you want to insert one more row \n press 1 to insert \n  or press any number");
			int choice = os.nextInt();
			if(choice!=1)
				flag=false;
			}
			pst.executeBatch();
			
			
			
		} catch ( SQLException e) {
			
			e.printStackTrace();
		}	}
	
	
	//delete
	
	public void delete()   {
		try {

			PreparedStatement pst = con.prepareStatement("DELETE FROM user WHERE id=?");
			boolean flag= true;
			while(flag) {
			System.out.println("enter which id you want to delete");
			int id = os.nextInt();
			pst.setInt(1, id);
			//pst.executeUpdate();
			pst.addBatch();
			System.out.println("successfully deleted");
			
			System.out.println("will you want to delete one more row \n press 1 to delete \n or press any number");
			int choice = os.nextInt();
			if(choice!=1)
				flag=false;
			}
			pst.executeBatch();
			
			
		} catch ( SQLException e) {
			
			e.printStackTrace();
		}
		
			
		
	}
	//Display
	public void display() {
		try {
			PreparedStatement pst = con.prepareStatement("SELECT * FROM user");
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
			System.out.println(rs.getInt("id"));
			System.out.println(rs.getString("name"));
			System.out.println(rs.getString("mail"));
			System.out.println(rs.getString("pwd"));
			System.out.println(rs.getDouble("mobile"));
			System.out.println("------------------------");
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	
	//Update
	
	public void update()  {
		PreparedStatement pst;
		try {
			pst = con.prepareStatement("UPDATE user SET name=?,mail=?,pwd=?,mobile=? WHERE id=?");
			boolean flag=true;
			while(flag) {
			System.out.println("enter id and new name,email,password,mobile ");
			int id = os.nextInt();
			String name = os.next();  
			String mail = os.next();
			String pwd = os.next();
			 double mobile = os.nextDouble();
			 
			
			 pst.setString(1, name);
			 pst.setString(2, mail);
			 pst.setString(3, pwd);
			 pst.setDouble(4, mobile);
			 pst.setInt(5, id);
//			 pst.executeUpdate();
			 pst.addBatch();
			 System.out.println("successfully updated");
			 
			 System.out.println("will you want to update one more row \n press 1 to update \n  or press any number");
			 int choice = os.nextInt();
			 if(choice!=1)
				 flag=false;
			}
			pst.executeBatch();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	 }
	
	

}
