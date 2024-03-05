package com.jspiders;

import java.sql.DriverManager;

import java.sql.SQLException;

public class ExecutingSteps {
		public static void main(String[] args) {
			try {
				com.mysql.cj.jdbc.Driver d = new com.mysql.cj.jdbc.Driver();
				DriverManager.registerDriver(d);
				System.out.println("registration done");
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
		}
}
