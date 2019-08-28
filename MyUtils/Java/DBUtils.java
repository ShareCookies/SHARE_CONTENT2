/**
 * 
 */
package com.hecaigui.EAS.utils; 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author joeyang ong
 *
 */
public class DBUtils {
	
	//数据库所在的位置以及访问用户名和密码
	private static final String DB_CONN_STR = "jdbc:mysql://localhost:3306/eas?useUnicode=true&characterEncoding=utf8";
	private static final String USERNAME = "root";
	/*private static final String PWD = "";*/
	private static final String PWD = "a520131sjk";
	/**
	 * 获得链接
	 * @return
	 */
	public static Connection getConn(){
		
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_CONN_STR, USERNAME, PWD);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("驱动还没加载，请检查!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}
	
    /**
     * 释放资源
     * @param conn
     * @param pstmt
     * @param rset
     */
	public static void releaseRes(Connection conn, PreparedStatement pstmt, ResultSet rset){
		

			try {
				if(rset!=null) rset.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

}
