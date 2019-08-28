package com.hecaigui.EAS.utils;

import java.sql.DriverManager;
import java.sql.SQLException;


import org.springframework.orm.hibernate4.LocalSessionFactoryBean;

public class XLocalSessionFactoryBean extends LocalSessionFactoryBean {
	String url="jdbc:mysql://localhost:3306/eas?useUnicode=true&amp;characterEncoding=utf-8";
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		  try {
			DriverManager.deregisterDriver(DriverManager.getDriver(url));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		super.destroy();
	}
}
