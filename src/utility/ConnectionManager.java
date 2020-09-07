package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.omg.CORBA.portable.InputStream;

public class ConnectionManager {
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		//step 1 Register the driver class
				Class.forName("oracle.jdbc.OracleDriver");
				
				//step 2 Create the connection object to establish connection
				Connection con=null;
				con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","chryal_008");
				
				if(con!=null)
					System.out.println("Established");
				return con;
	}
	 public static Properties loadPropertiesFile() throws Exception {
		 Properties prop = new Properties();
		 InputStream in = (InputStream) ConnectionManager.class.getClassLoader().getResourceAsStream("jdbc.properties");
		 prop.load(in);
		 in.close();
		 return prop; 
		 } 
	
}
