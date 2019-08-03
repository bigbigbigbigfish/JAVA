package com.cao.jdbc;

import java.sql.*;
import java.time.LocalDateTime;

public class JDBCCase1 {
    //JDBC 开发流程
    public static void main(String[] args) {
        try {
            //1.
            Class.forName("com.mysql.jdbc.Driver");
            //2. JDBC规范对url 定义
            // jdbc:<databaseProductName>
            //MySql - > mysql
            //H2 - >h2
            //Oracle - >oracle

            // example
            String url = "jdbc:mysql://127.0.0.1:3306/memo?user=root&password=mysql&useSSL=false";
            Connection connection = DriverManager.getConnection(url);
            //3. 准备sql 语句
            String  sql = "select id,name,created_time,modify_time from memo_group";

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            //6 处理结果

            while (resultSet.next()) {
                //每次执行next  如果返回true  定位到数据库记录的下一条
                // getXxx(int)  通过查询结果记录的列的下标记录, 不建议采用这种方式
                //通过get(String )  通过列名
                int id =resultSet.getInt("id");
                String name = resultSet.getString("name");
                LocalDateTime createdTime = resultSet.getTimestamp("created_time").toLocalDateTime();
                LocalDateTime modifyTime =resultSet.getTimestamp("modify_time").toLocalDateTime();
                System.out.println(id+" " + name + " " + createdTime + " "+ modifyTime);
                resultSet.close();
                statement.close();
                connection.close();
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

}
