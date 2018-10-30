package com.netease.haitao.demo2;

import java.sql.*;
import java.util.Properties;
import java.util.logging.Logger;

/**
 * @Auther: leijiang
 * @Date: 2018/10/29 18:59
 * @Description:
 */
public class KaolaDriver implements Driver {

    static {
        try {
            DriverManager.registerDriver(new KaolaDriver());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection connect(String url, Properties info) throws SQLException {
        return new KaolaConnection();
    }

    public boolean acceptsURL(String url) throws SQLException {
        return false;
    }

    public DriverPropertyInfo[] getPropertyInfo(String url, Properties info) throws SQLException {
        return new DriverPropertyInfo[0];
    }

    public int getMajorVersion() {
        return 0;
    }

    public int getMinorVersion() {
        return 0;
    }

    public boolean jdbcCompliant() {
        return false;
    }

    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }
}
