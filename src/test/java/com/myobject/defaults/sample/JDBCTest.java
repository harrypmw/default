package com.myobject.defaults.sample;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class JDBCTest {

	static {
		String driver = "com.mysql.cj.jdbc.Driver";
		try {
			Class.forName(driver);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testConnection() {
		try(Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/defaultobject?useSSL=false"
				, "root"
				, "rh1rn1ak1!")){
			log.info(conn);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

}
