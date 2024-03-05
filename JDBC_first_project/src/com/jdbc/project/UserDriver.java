package com.jdbc.project;

import java.sql.SQLException;
import java.util.Scanner;

public class UserDriver extends  UserRepository {
		static Scanner os= new Scanner(System.in);
		
		static UserRepository ur=new UserRepository();
	public static void main(String[] args) {
		boolean flag=true;
		while(flag) {
		System.out.println("__________HOME PAGE__________");
		System.out.println("press 1 to insert ");
		System.out.println("press 2 to delete ");
		System.out.println("press 3 to display ");
		System.out.println("press 4 to update ");
		System.out.println("press 5 to exit ");
		int choice = os.nextInt();
		switch(choice) {
			
		case 1:
			ur.insert();
			break;
		case 2:
			//calling delete() method
			
				ur.delete();
			
			break;
		case 3:
			//calling display() method
			ur.display();
			break;
		case 4:
			//calling update() method
			
				ur.update();
			
			break;
		case 5:
			//exit
			System.out.println("are you sure to exit? \n press 1 to exit \n or press any number");
			int n = os.nextInt();
			if(n==1)
			flag=false;
			
			
			break;
			
		}
      }
		try {
			con.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		System.out.println("________THANK YOU________");
		System.out.println("________VISIT AGAIN________");
	}

}
