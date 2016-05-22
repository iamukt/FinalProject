package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ResourceBundle;

public class ConnectionUtil
{
	private static ConnectionUtil cu = new ConnectionUtil();
	private Connection conn;
	
	private ConnectionUtil() 
	{
		try
		{
		ResourceBundle rb = ResourceBundle
				.getBundle("resource");
		
		// Locate and load the driver
		Class.forName(rb.getString("driver"));
		// Connection created
		conn = DriverManager.getConnection(rb.getString("url"), rb.getString("username"), rb.getString("password"));
		
		}catch(Exception e)
		{
			
		}
	}
	/**
	 * @return the conn
	 */
	public static Connection getConn()
	{
		return cu.conn;
	}
	
}
