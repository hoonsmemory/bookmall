package kr.co.itcen.bookmall.dao;
import java.sql.Connection;
import java.sql.DriverManager;

//JDBC 연결관리
public class ConnectionPool {

	static Connection conn = null;
	
	private String driver = "org.mariadb.jdbc.Driver";
	private String jdbc_url="jdbc:mysql://192.168.1.63:3306/bookmall?characterEncoding=utf8";
	private String db_id="bookmall";
	private String db_pwd="bookmall";
	
	private ConnectionPool() throws Exception {
		Class.forName(driver);
		conn = DriverManager.getConnection(jdbc_url, db_id, db_pwd);
	}
	
	public static Connection getInstance() throws Exception
	{
		if(conn ==null)
		{
			ConnectionPool col = new ConnectionPool();
		}
		
		return conn;
	}
}