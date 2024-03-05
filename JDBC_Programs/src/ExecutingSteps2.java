//import java.util.Scanner;
import java.sql.Driver;
public class ExecutingSteps2 {
		public static void main(String[] args) {
			//Scanner os = new Scanner(System.in);
			
			try {
//				System.out.println("Enter the driver");
//			String s= os.next();
				Class.forName("com.mysql.jc.jdbc.Driver");
				System.out.println("registraion completed successfully");
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			}
		}
}
