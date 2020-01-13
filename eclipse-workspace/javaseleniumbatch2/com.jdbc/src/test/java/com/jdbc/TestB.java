package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestB {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./software/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String url = "jdbc:mysql://localhost:3306/acti";
		String userName = "root";
		String password = "root";

		//String sql = "SELECT * FROM mobile WHERE name='swathi' AND password='re@123'";
		String sql="SELECT * FROM datas";
		try {
			// 1) Load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// 2) Establishing the connection
			Connection con = DriverManager.getConnection(url, userName, password);

			// 3) Establish the statement
			Statement stm = con.createStatement();

			// 4)Execute the query
			ResultSet rs = stm.executeQuery(sql);
			driver.get("https://demo.actitime.com/login.do");
			while (rs.next()) {
				driver.findElement(By.id("username")).sendKeys(rs.getString(2));
				//System.out.println("ID   " + rs.getInt(1));
				driver.findElement(By.name("pwd")).sendKeys(rs.getString(3));
				//System.out.println("Name  " + rs.getString(2));
				System.out.println("Password " + rs.getString(3));
				System.out.println("--------------------------------------");
				driver.findElement(By.xpath("//div[.='Login ']")).click();
			}

			// 5)Close the connection
			con.close();

			System.out.println("Data inserted");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
