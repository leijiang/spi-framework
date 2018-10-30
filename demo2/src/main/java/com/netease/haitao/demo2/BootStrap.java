package com.netease.haitao.demo2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @Auther: leijiang
 * @Date: 2018/10/29 19:05
 * @Description:
 */
public class BootStrap {

    private static final Logger logger = LoggerFactory.getLogger(BootStrap.class);

    public static void main(String[] args) {
        try {
            Class.forName("com.netease.haitao.demo2.KaolaDriver");
            Class.forName("com.netease.haitao.demo2.YouPinDriver");
            Connection connection = DriverManager.getConnection("kaola:mysql://10.173.32.9:3306/dist-test");
            connection.commit();
            connection.rollback();
            connection.close();
        } catch (Exception e) {
            logger.error("failed to connect . the error {}", e);
        }
    }
}
