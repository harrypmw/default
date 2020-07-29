package com.myobject.defaults.sample;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.myobject.defaults.config.RootConfig;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {RootConfig.class})
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
	@Setter(onMethod_ = @Autowired)
	private DataSource dataSource;

	@Test
	public void testConnection() {
		/*
		try(Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/defaults?useSSL=false&serverTimezone=UTC"
				, "root"
				, "1111")){
			log.info(conn);
		} catch (Exception e) {
			fail(e.getMessage());
		}
		 */
		try(Connection conn = dataSource.getConnection()){
			log.info(conn);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
}
