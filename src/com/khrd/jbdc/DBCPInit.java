package com.khrd.jbdc;

import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.commons.dbcp2.ConnectionFactory;
import org.apache.commons.dbcp2.DriverManagerConnectionFactory;
import org.apache.commons.dbcp2.PoolableConnection;
import org.apache.commons.dbcp2.PoolableConnectionFactory;
import org.apache.commons.dbcp2.PoolingDriver;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;





public class DBCPInit extends HttpServlet {
	
		
	@Override
	public void init() throws ServletException {
	
		loadJDBCDriver();
		initConnectionPool();
	}
			
		public void loadJDBCDriver() {
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
				
			}catch(Exception e){
				
				e.printStackTrace();
			}
		}
		
		private void initConnectionPool() {
			
		try {
			String url = "jdbc:mysql://localhost:3306/board";
			
			String userid = "root";
			
			String userpw = "rootroot";
			
			ConnectionFactory connFactory = new DriverManagerConnectionFactory(url, userid, userpw);
			
			PoolableConnectionFactory poolableConnFactory = new PoolableConnectionFactory(connFactory, null);
			
			// 커넥션을 검사할때 사용할 쿼리 설정
			// bad 커넥션을 dbcp의 connection pool 에선 여전히 가지고 있는 상태일때,
			// DB 관련 프로그램이 호출되면 커넥션 관련 에러가 발생하게 된다.
			// java 에서 DB 를 사용하기 전에 해당 connection 이 정상적인지 검사를 하도록 하는것
			// 이것이 아래의 옵션이다.
			// 우리가 따로 커리를 연결 할 수 있지만, select  1 은 SQL Server 에서 권장하는 방법이다. 
		
			poolableConnFactory.setValidationQuery("select 1");
			
			GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
			
			poolConfig.setTimeBetweenEvictionRunsMillis(1000L*60L*5);

			poolConfig.setTestWhileIdle(true);
			
			poolConfig.setMinIdle(4);
			
			poolConfig.setMaxTotal(50);
			
			GenericObjectPool<PoolableConnection> connectionPool = new GenericObjectPool<>(poolableConnFactory, poolConfig);
			poolableConnFactory.setPool(connectionPool);
			
			Class.forName("org.apache.commons.dbcp2.PoolingDriver");
			
			PoolingDriver driver = (PoolingDriver) DriverManager.getDriver("jdbc:apache:commons:dbcp:");
			
			driver.registerPool("board", connectionPool);
	
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		
	}
	

}
