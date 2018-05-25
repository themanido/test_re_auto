package UserUi;

import DBConn.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException ;
import java.sql.Statement;
//import java.sql.ResultSetMetaData ;

public class Manual_download {
	public Connection con ;
	public Connection con1 ;
	//public java.sql.Statement stmt ;
	public ResultSet rs ;
	public ResultSet rs1 ;
	public Statement stMysql ;
	public Statement stMysql1 ;
	
	//public Statement stOracle ;
	
	public Manual_download() {
		try{
			DBConnMysql dbmysql = new DBConnMysql() ;
			DBConnMysql dbmysql1 = new DBConnMysql() ;
			//DBConnOracle dboracle = new DBConnOracle() ;
			con = dbmysql.getCon();
			con1 = dbmysql.getCon();
			//con1 = dboracle.getCon();
			
			con.setAutoCommit(false); 
			con1.setAutoCommit(false); 
			
			
			stMysql = con.createStatement();
			stMysql1 = con.createStatement();
			System.out.println("stMysql :" + stMysql) ;
			System.out.println("stMysql1" + stMysql1) ;
			//stOracle = con1.createStatement();
			
			String sql = " select * from user_info " ;
			rs = stMysql.executeQuery(sql) ;
			//
			
			//ResultSetMetaData rsmd = rs.getMetaData();
			//int columnCount = rsmd.getColumnCount();
			//System.out.println("columnCount : " +columnCount) ;
			
			
			while(rs.next()){
				String user_id = rs.getString("user_id") ;
				String user_pw = rs.getString("user_pw") ;
				String user_name = rs.getString("user_name") ;
				String user_tel_hp = rs.getString("user_tel_hp") ;
				stMysql = con.createStatement();
				
				//System.out.println("아이디 : " + rs.getString("user_id") + " /  패스워드 : " + rs.getString("user_pw") ) ;
				
				//sql_insert = ("insert into user_info_new (user_id, user_pw, user_name, user_tel_hp, user_email, user_create, user_info_update, user_pw_update, user_delete) values ('" + rs.getString("user_id") + "', '" + rs.getString("user_pw") + "', '"  + rs.getString("user_name") + "', '" + rs.getString("user_tel_hp") + "', '" + rs.getString("user_email") + "', '" + rs.getString("user_create") + "', '" + rs.getString("user_info_update") + "', '" + rs.getString("user_pw_update") + "', '" + rs.getString("user_delete")+"'") ;
				//String sql_insert = "insert into user_info_new (user_id, user_pw, user_name, user_tel_hp) values ('" + rs.getString("user_id") + "', '" + rs.getString("user_pw") + "', '" + rs.getString("user_name") + "', '"  + rs.getString("user_tel_hp") + "')" ;
				String sql_insert = "insert into user_info_new (user_id, user_pw, user_name, user_tel_hp) values ('" +user_id + "', '" + user_pw + "', '" + user_name + "', '"  +user_tel_hp + "')" ;
				//System.out.println("sql_insert : " + sql_insert ) ;
				
				sql = " select * from user_info_new where  user_id = '" + user_id + "'" ;
				rs1 = stMysql.executeQuery(sql) ;
				if(rs1.next()){
					System.out.println("user_id : " + rs1.getString("user_id")  ) ;
					//System.out.println("555" ) ;
					//sql_update = ("update user_info_new set  user_id = '" + rs.getString("user_id") +"',  user_pw = '" + rs.getString("user_pw")+ "', user_name = '" + rs.getString("user_pw")+ "', user_tel_hp = '" + rs.getString("user_pw")+ "', user_email = '" + rs.getString("user_pw")+ "', user_create = '" + rs.getString("user_pw")+ "', user_info_update = '" + rs.getString("user_pw")+ "', user_pw_update = '" + rs.getString("user_pw")+ "', user_delete = '" + rs.getString("user_pw") + "' where user_id = '" + rs.getString("user_id")+ "'" ) ;
					String sql_update = "update user_info_new set user_pw = '" + user_pw+ "', user_name = '" + user_name + "', user_tel_hp = '" +user_tel_hp+ "' where user_id = '" + user_id+ "'" ;
					System.out.println("sql_update : "  + sql_update) ;
					stMysql.executeUpdate(sql_update) ;
					
				}else{ 
					stMysql.executeUpdate(sql_insert) ;
					System.out.println("sql_insert : "  + sql_insert ) ;	
					System.out.println("sql_insert1 : "  + sql_insert ) ;	
				}
			}
			
			con.commit();  
			con1.commit();  
			
			con.setAutoCommit(true);  
			con1.setAutoCommit(true); 
			
			if(rs != null) {try { rs.close(); } catch (SQLException e) {}} 
			if(rs1 != null) {try { rs1.close(); } catch (SQLException e) {}} 
			if(stMysql != null) {try { stMysql.close(); } catch (SQLException e) {}}
			if(stMysql1 != null) {try { stMysql1.close(); 	} catch (SQLException e) {}}
			if(con != null) {try { con.close(); } catch (SQLException e) {}}
			if(con1 != null) {try { con1.close(); } catch (SQLException e) {}}
			
			dbmysql.closeCon();
			dbmysql1.closeCon();
			
			/*
			String sql_insert = "" ;
			
			for(int i = 0 ; i < 10 ; i++) {
				sql_insert = ("insert into user_info (user_id, user_pw, user_name, user_tel_hp, user_email) values ('AutoInset_110" + i + "', 'AtPw_001" + i + "', 'at001" + i + "', '010" + i +"', 'at00" + i + "@email.com')") ;
				System.out.println("sql_insert : "  + sql_insert ) ;
				dbmysql.st.executeUpdate(sql_insert) ;
			}
			*/
			
		}
		catch(Exception e){
			if(con != null) try{ con.rollback(); }catch(SQLException sqle){} ;
			//if(con1 != null) try{ con1.rollback(); }catch(SQLException sqle){} ;
			System.out.println("222데이터베이스 연결 오류 : " + e.getMessage()) ;
		}
		
	}
	
}
