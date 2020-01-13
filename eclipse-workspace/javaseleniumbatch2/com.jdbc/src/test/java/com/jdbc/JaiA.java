package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JaiA {

	public static void main(String[] args) {
		String url="jdbc:mysql://localhost:3306/";
		String username="root";
		String password="root";
		String sql = "INSERT INTO acti.datas VALUES(2,'admin','manager')";
		
//		String sql="INSERT INTO acti.datas.VALUES(1,'admin','manager')";
//		//String sql = "INSERT INTO vikas.mobile VALUES(2,'Divya','re@123')";
//		
		try {
			//1) Load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//2) Establishing the connection
			Connection con = DriverManager.getConnection(url, username, password);
			
			//3) Establish the statement
			Statement stm = con.createStatement();
			
			//4)Execute the query
			stm.execute(sql);
//			stm.execute(sql2);//executeUpdate(sql)
//			stm.execute(sql3);
//			
			//5)Close the connection
			con.close();
			
			
			System.out.println("Data inserted");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
