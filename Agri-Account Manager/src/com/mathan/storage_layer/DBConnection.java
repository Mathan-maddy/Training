package com.mathan.storage_layer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnection {
	
	private Connection con;
	private final static String user = "mathan";
	private final static String password = "elathur";
	private final static String db_url="jdbc:derby:E:/Derby Database/Agriculture Database/AgriDB_test;create=true";
		
	public Connection establishConnection() throws SQLException 
	{
		try {
		Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		con = DriverManager.getConnection(db_url, user, password);
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		
		return con;
	}

}
