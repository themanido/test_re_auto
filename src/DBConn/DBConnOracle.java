
package DBConn;

import java.sql.Connection ;
import java.sql.DriverManager ;
import java.sql.SQLException ;


public class DBConnOracle {
	private Connection conn ;
	
	public Connection getCon() {
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver") ;
			String url = "jdbc:oracle:thin:@192.168.1.18:1521:orcl"; 
		    String id = "TEST_SPACE"; 
		    String pass = "TEST_SPACE"; 
		    conn = DriverManager.getConnection(url,id,pass); 
			System.out.println("oracle DriverManager.getConnection " ) ;
		}
		catch(Exception e){
			System.out.println("catch(Exception e)" ) ;
			System.out.println("111데이터베이스 연결 오류 : " + e.getMessage()) ;
		}
		return conn;
	}
	
	public void closeCon(){
		if(conn!=null) {try { conn.close(); } catch (SQLException e) {}}
		System.out.println("DBConnOracle conn close" ) ;
	}

}
