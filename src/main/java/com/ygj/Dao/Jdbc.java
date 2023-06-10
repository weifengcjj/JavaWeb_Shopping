package com.ygj.Dao;

import java.sql.*;

/**
 * @Author 微风
 * @Version 1.0.0
 * @StartTime Start
 * @EndTime End
 */
public class Jdbc {
    Connection conn=null;
    Statement stmt=null;
    ResultSet rs=null;
    Connection con;
    public static Connection getcon(){
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/weifeng7?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT&useSSL=false";
            connection = DriverManager.getConnection(url, "root", "20040309cjj");
        } catch (ClassNotFoundException | SQLException exception) {
            exception.printStackTrace();
        }
        return connection;
    }
    public static void closeAll(Connection connection,Statement statement,ResultSet resultSet)
    {
        try {
            if(resultSet!=null)
            {
                resultSet.close();
            }
            if(connection!=null)
            {
                connection.close();
            }
            if(statement!=null)
            {
                statement.close();
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
