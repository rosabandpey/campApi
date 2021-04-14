package com.camp.campApi.logging;

import java.sql.Connection;
import java.sql.SQLException;
import org.apache.commons.dbcp2.*;


public class ConnectionFactory {
    private static BasicDataSource dataSource;

    private ConnectionFactory() {
    }

    public static Connection getConnection() throws SQLException {
        if (dataSource == null) {
            dataSource = new BasicDataSource();
            dataSource.setUrl("jdbc:mysql://localhost:3307/camp");
            dataSource.setDriverClassName("com.mysql.jdbc.Driver");
            dataSource.setUsername("root");
            dataSource.setPassword("123456");
        }
        return dataSource.getConnection();
    }
}