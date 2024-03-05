package com.jspiders;

import java.sql.DriverManager;
import java.sql.SQLException;

public class EstablishingConnection {
		public static void main(String[] args) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				
					DriverManager.getConnection("jdbc:mysql://localhost:3306/first_sql","root","root");
					System.out.println("Connection established");
				
				
			} catch (ClassNotFoundException | SQLException e  ) {
				
				e.printStackTrace();
			}
		
		}
			}

