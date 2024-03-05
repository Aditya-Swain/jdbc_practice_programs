package com.jspiders;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Scanner;

public class InsertingDataUsingBatch {

	public static void main(String[] args) {
		Scanner os= new Scanner(System.in);
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/india","root","root");
				PreparedStatement pst = con.prepareStatement("insert into emp(id,name,age,salary,mobile) values(?,?,?,?,?)");
				boolean flag= true;
				while(flag) {
				System.out.println("enter the id ,name,age,salary and mobile number of the employee");
				
				int id = os.nextInt();
				String name = os.next();
				int age = os.nextInt();
				int salary = os.nextInt();
				long mobile = os.nextLong();
				
				pst.setInt(1, id);
				pst.setString(2, name);
				pst.setInt(3, age);
				pst.setInt(4, salary);
				pst.setLong(5, mobile);
				pst.addBatch();
				System.out.println("inserted");
				System.out.println("will you want to insert one more row \n/press 0 to insert \n/press any number");
				int choice = os.nextInt();
				if(choice!=0)
					flag=false;
				}
				int[] arr = pst.executeBatch();
				System.out.println(Arrays.toString(arr));
				System.out.println("__________visit again__________");
				
				
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}

	}

}
