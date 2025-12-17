package com.pinkitec.aps.utils;

import com.pinkitec.remote.log.Log;
import com.pinkitec.remote.log.LogFactoryUtil;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class JDBCUtils { 
    private static final Log _log = LogFactoryUtil.getLog(JDBCUtils.class);

    /**
     * 获取数据库连接
     *
     * @return
     * @throws Exception
     */
    public static Connection getConnection() throws Exception {

        InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
        Properties jdbc = new Properties();
        jdbc.load(is);
        String driverName = jdbc.getProperty("jdbc.driver");
        String url = jdbc.getProperty("jdbc.url");
        String username = jdbc.getProperty("jdbc.username");
        String password = jdbc.getProperty("jdbc.password");
        Class.forName(driverName);
        Connection connection = DriverManager.getConnection(url, username, password);
        return connection;
    }

    /**
     * 获取查询数据
     *
     */
    public static List<Object[]> queryData(String sql, Object... args) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Object[]> datas = new ArrayList<Object[]>();
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                Object object = args[i];
                if (object instanceof Character) {
                    object = "" + object;
                }
                preparedStatement.setObject(i + 1, object);
            }
            resultSet = preparedStatement.executeQuery();

            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            int columnCount = resultSetMetaData.getColumnCount();
            while (resultSet.next()) {

                Object[] str = new Object[columnCount];
                for (int i = 0; i < columnCount; i++) {
                    str[i] = resultSet.getObject(i+1);
                }
                datas.add(str);
            }

        } catch (Exception e) {
            _log.error("查询数据库信息出现异常", e);
            return datas;

        } finally {
            release(connection, preparedStatement, resultSet);
        }
        return datas;
    }

    /**
     * 释放资源的方法
     *
     * @param connection
     * @param statement
     * @param resultSet
     */
    public static void release(Connection connection, Statement statement, ResultSet resultSet) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
