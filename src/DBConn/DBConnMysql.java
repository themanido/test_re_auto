package DBConn;

import java.sql.Connection ;
import java.sql.DriverManager ;
import java.sql.SQLException;

public  class  DBConnMysql {
	
	private Connection conn ;
	
	public Connection getCon() {
		try{
			Class.forName("com.mysql.jdbc.Driver") ;
			String url = "jdbc:mysql://localhost:3306/com?"; 
		    String id = "root"; 
		    String pass = ""; 
		    conn = DriverManager.getConnection(url,id,pass); 
			System.out.println("mysql DriverManager.getConnection " ) ;
		}
		catch(Exception e){
			System.out.println("111데이터베이스 연결 오류 : " + e.getMessage()) ;
		}
		return conn;
	}
	public void closeCon(){
		if(conn!=null) {try { conn.close(); } catch (SQLException e) {}}
		System.out.println("DBConnMysql conn close" ) ;
	}
}
