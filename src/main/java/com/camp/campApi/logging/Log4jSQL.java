package com.camp.campApi.logging;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.sql.SQLException;

public class Log4jSQL {


    private static final Logger logger = LogManager.getLogger(Log4jSQL.class);

    public static void main(String[] args)throws IOException, SQLException {
        logger.debug("Hello this is a debug message");
        logger.info("Hello this is an info message");
    }

}
