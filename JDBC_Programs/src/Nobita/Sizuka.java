package Nobita;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Sizuka {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_first_jdbc","root","root");
		Statement stmt = con.createStatement();
		Scanner os= new Scanner(System.in);
		System.out.println("enter your email id : ");
		String email=os.next();
		System.out.println("enter your password : ");
		String password=os.next();
		
		String sql="select * from user where mail='"+email+"'";
		ResultSet rst = stmt.executeQuery(sql);
		
		
		if(rst.next()) {
			if(password.equals(rst.getString("pwd")))
				System.out.println("welcome to home page ");
			else
			{
				System.out.println("Invlid password ");
			}
		}
		else
		{
			System.out.println("Invalid email ");
		}
		con.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
