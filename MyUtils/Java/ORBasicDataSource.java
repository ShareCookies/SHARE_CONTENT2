/**
 * 
 */
package com.hecaigui.EAS.utils;

import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

/**
 * @author Administrator
 *
 */
public class ORBasicDataSource extends BasicDataSource{
	 @Override
	 public synchronized void close() throws SQLException{
	//  System.out.println("......输出数据源Driver的url："+DriverManager.getDriver(url));
	  DriverManager.deregisterDriver(DriverManager.getDriver(getUrl()));
	  super.close();
	 }
}
