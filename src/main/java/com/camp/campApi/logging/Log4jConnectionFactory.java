package com.camp.campApi.logging;




import org.apache.commons.dbcp2.*;
import org.apache.commons.pool2.impl.GenericObjectPool;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.SQLException;
import java.util.Properties;


public class Log4jConnectionFactory {

    private static interface Singleton {
        final Log4jConnectionFactory Log4jConnectionFactoryINSTANCE  = new Log4jConnectionFactory();
    }

    private BasicDataSource dataSource;

    private Log4jConnectionFactory() {

        dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3307/camp");
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");
    }


    public static Connection getDatabaseConnection() throws SQLException {
        return Singleton.Log4jConnectionFactoryINSTANCE.dataSource.getConnection();
    }

}
