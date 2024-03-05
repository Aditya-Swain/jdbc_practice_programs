package Nobita;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class Demo {
		public static void main(String[] args) {
			Connection con=null;
			PreparedStatement pst = null;
			ResultSet rs=null;
			try {
				FileInputStream fis=new FileInputStream("C:\\Users\\adity\\eclipse-workspace\\Doraemon\\lib\\jdbcExample.properties");
				Properties pop=new Properties();
				pop.load(fis);
				Class.forName(pop.getProperty("driver"));
				 con = DriverManager.getConnection(pop.getProperty("url"),pop.getProperty("un"),pop.getProperty("pw"));
		          pst = con.prepareStatement(pop.getProperty("sql"));
				
				rs = pst.executeQuery();
				while(rs.next()) {
					System.out.println(rs.getInt("modelNo"));
					System.out.println(rs.getString("brand"));
					System.out.println(rs.getString("modelName"));
					System.out.println(rs.getInt("price"));
					System.out.println(rs.getString("specs"));
					System.out.println("------------------------");
				}
			} catch (ClassNotFoundException | SQLException | IOException e) {
				
				e.printStackTrace();
			}
			finally {
				try{
					if(rs!=null)
					
						rs.close();
						if(pst!=null)
							pst.close();
						if(con!=null)
							con.close();
						System.out.println("finally block executed");
					} catch (SQLException e) {
						e.printStackTrace();
					}
					
			}
		}
}
