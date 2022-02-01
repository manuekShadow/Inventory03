package com.t3b.msinventory.utils;

import java.sql.SQLException;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4J2PropertiesConf {
	private static Logger logger = LogManager.getLogger();
	private static SQLException e;
    public void performSomeTask(){
        logger.debug("This is a debug message");
        logger.info("This is an info message");
        logger.warn("This is a warn message");
        logger.error("This is an error message");
        logger.fatal("This is a fatal message");
        logger.log(Level.ERROR,"ERROR_END_CONECT","This is a log message");
        e.printStackTrace();
    }
}
