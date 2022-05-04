package com.shk.jdbc;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author Lin
 * 2022/5/3  18:20
 */
public class ConnectionTest {
    @Test
    public void testConnention1() throws SQLException {
        // 获取Driver实现类对象
        Driver driver = new com.mysql.jdbc.Driver();
        String url = "jdbc:mysql://117.50.6.230:3307/test";
        // 将用户名和密码封装在Properties中
        Properties info = new Properties();
        info.setProperty("user", "root");
        info.setProperty("password", "root@1298");
        Connection conn = driver.connect(url, info);
        System.out.println(conn);

        /**
         * 输出：
         * com.mysql.jdbc.JDBC4Connection@67f89fa3
         */


    }
    @Test
    /**
     *  方式二：对方式一的迭代:在如下的程序中不出现第三方的api,使得程序具有更好的可移植性
     */
    public void testConnection2() throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {
        Class clazz = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver) clazz.newInstance();

        //2.提供要连接的数据库
        String url = "jdbc:mysql://117.50.6.230:3307/test";
        //3.连接数据库需要的用户名和密码
        Properties info = new Properties();
        info.setProperty("user", "root");
        info.setProperty("password", "root@1298");
        //4.获取连接
        Connection conn = driver.connect(url, info);
        System.out.println(conn);

    }
    @Test
    // 方式三：使用DriverManager替换Driver
    public void testConnnection3() throws Exception{
        Class clazz = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver) clazz.newInstance();

        //2.提供连接数据库必要的三个信息
        String url = "jdbc:mysql://117.50.6.230:3307/test";
        String user = "root";
        String password = "root@1298";

        DriverManager.registerDriver(driver);
        Connection conn = DriverManager.getConnection(url, user, password);
        System.out.println(conn);
    }
    @Test
    // 方式四：可以只是加载驱动，不用显示的注册驱动过了。
    public void testConnection4() throws Exception{
        //1.提供连接数据库必要的三个信息
        String url = "jdbc:mysql://117.50.6.230:3307/test";
        String user = "root";
        String password = "root@1298";

        //2.加载Driver
        Class.forName("com.mysql.jdbc.Driver");

        //3.获取连接
        Connection conn = DriverManager.getConnection(url, user, password);
        System.out.println(conn);

    }
    @Test
    //方式五(final版)：将数据库连接需要的4个基本信息声明在配置文件中，通过读取配置文件的方式，获取连接
    /*
     * 此种方式的好处？
     * 1.实现了数据与代码的分离。实现了解耦
     * 2.如果需要修改配置文件信息，可以避免程序重新打包。
     */
    public void testConnnection5() throws Exception {
        InputStream is = ConnectionTest.class.getClassLoader().getResourceAsStream("jdbc.properties");
        Properties props = new Properties();
        props.load(is);

        String user = props.getProperty("user");
        String password = props.getProperty("password");
        String url = props.getProperty("url");
        String driverClass = props.getProperty("driverClass");

        Class.forName(driverClass);
        Connection conn = DriverManager.getConnection(url, user, password);
        System.out.println(conn);
    }

}
