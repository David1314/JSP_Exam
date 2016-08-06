package com.yuxiaoli.jdbcUtils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
	
		private static String driver;
		private static String url;
		private static String username;
		private static String password;
		private static final ConnectionFactory factory=new ConnectionFactory();
		
		private Connection conn;
		
		static {
			Properties pop=new Properties();
			try {
				InputStream in=ConnectionFactory.class.getClassLoader()
						.getResourceAsStream("jdbc.properties");
				pop.load(in);
				
			} catch (IOException e) {
				System.out.println("------------≈‰÷√Œƒº˛∂¡»°¥ÌŒÛ-----------");
			}
			
			driver=pop.getProperty("driver");
			url=pop.getProperty("url");
			username=pop.getProperty("username");
			password=pop.getProperty("password");
			
		}
		public ConnectionFactory() {
		}
		
		public static ConnectionFactory getInstance(){
			return factory;
		}
		
		public Connection getConnection(){
			try {
				Class.forName(driver);
				conn=DriverManager.getConnection(url, username, password);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return conn;
		}

}
