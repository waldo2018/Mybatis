package com.java.test.mybatis;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.datasource.DataSourceFactory;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class EmDataSourceFactory implements DataSourceFactory {

	@Override
	public DataSource getDataSource() {
		
		DataSource dataSource  = new ComboPooledDataSource("c3p0-config.xml");
		
		return dataSource;
	}

	@Override
	public void setProperties(Properties arg0) {
		// TODO Auto-generated method stub

	}

}
