package com.timeSNSTest;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MySQLConnectionTest {

	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/timeSNS";
	private static final String USER ="root";
	private static final String PW = "s!1018810";
	
	@Test
	public void testConnection() throws Exception{
		Class.forName(DRIVER);
		try (Connection con = DriverManager.getConnection(URL, USER, PW))	{
			System.out.println("연결됐어염");
			System.out.println(con);
		}catch(Exception e){
			System.out.println("정신차리세염");
			System.err.println(e);
		}
	}
}

