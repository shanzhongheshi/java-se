package com.ljx.jdbc;

import sun.applet.Main;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author Lin
 * 2022/5/4  21:04
 */
public class ConnectionTest {
    public static void main(String[] args) throws SQLException {
        Driver driver = new com.mysql.jdbc.Driver();
        String url = "jdbc:mysql://117.50.6.230:3307/test";
        // 将用户名和密码封装在Properties中
        Properties info = new Properties();
        info.setProperty("user", "root");
        info.setProperty("password", "root@1298");
        Connection conn = driver.connect(url, info);
        System.out.println(conn);
    }
}
