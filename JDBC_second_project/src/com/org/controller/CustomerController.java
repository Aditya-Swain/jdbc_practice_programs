package com.org.controller;

import java.util.Scanner;

import com.org.dao.CustomerDao;
import com.org.dto.Customer;

public class CustomerController {
		public static void main(String[] args) {
			Scanner os = new Scanner(System.in);
			CustomerDao dao= new CustomerDao();
			boolean flag=true;
			do {
				System.out.println("_________HOME PAGE__________");
				System.out.println("1.insert data\n2.delete data\n3.fetching data\n4.updating data\n5.delete\n6.exit");
				System.out.println("choose your choice");
				int choice =os.nextInt();
				switch(choice) {
				case 1:{
					System.out.println("Enter your name,age,mobile");
					String name=os.next();
					int age = os.nextInt();
					long mobile = os.nextLong();
					
					Customer customer = new Customer();
					customer.setName(name);
					customer.setAge(age);
					customer.setMobile(mobile); 
					
					System.out.println(dao.insertData(customer));
					break;
				}
				case 3:
				{
					dao.fetchData();
					break;
				}
				case 6 :
				{
					System.out.println("are you sure to exit \n 1.to exit \n or press any number");
					int choice1 = os.nextInt();
					if(choice1==1)
						flag=false;
					break;
				}
				default:
					System.out.println("invalid input");
				
			}
				}
			while(flag);
			System.out.println("_________VISIT AGAIN________");
		

		}
	}
