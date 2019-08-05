package com.cao.jdbc;

import java.sql.*;

public abstract class AbstractJdbcTemplate {

    //定义模板的执行流程
    public final void execute() throws SQLException, ClassNotFoundException {
        this.loadDriver();
        this.creatConnection();
        this.createStatement();

        //sql 通过方法传入
        String sql = this.getSql();
        //r  resultset
        //cud integer

        //select  update delete insert

        if(sql.trim().toUpperCase().startsWith("SELECT")) {
            //R
            this.callQuery(sql);
            this.handlerResult(this.resultSet);
        } else {
            Integer effect = this.callUpdate(sql);
            this.handlerResult(effect);
        }
        this.close();

    }
    private Connection connection;

    private Statement statement;

    private ResultSet resultSet;


    //加载驱动
    private void loadDriver() throws ClassNotFoundException {

        Class.forName("com.mysql.jdbc.Driver");
    }

    //创建连接
    private void creatConnection() throws SQLException {
        String url = "jdbc:mysql://127.0.0.1:3306/memo?useSSL=false";
        String username = "root";
        String password = "mysql";
            this.connection = DriverManager.getConnection(url,username,password);
    }
    // 准备sql
    public abstract String getSql();


    // 创建命令
    private void createStatement() throws SQLException {
        this.statement = this.connection.createStatement();
    }


    // 执行命令crud   r            cud
        //
    public abstract void callStatement();

    private void callQuery(String sql) throws SQLException {
        this.resultSet = this.statement.executeQuery(sql);
    }

    private Integer callUpdate(String sql) throws SQLException {
        return this.statement.executeUpdate(sql);
    }


    //处理结果   ResultSet      Integer


    public abstract void handlerResult(ResultSet resultSet);


    public abstract void handlerResult(Integer value);


    // 7.8.9 关闭资源

    private void close() {
        if(resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }





}












class JDBCtemp extends AbstractJdbcTemplate  {

    @Override
    public String getSql() {
        return null;
    }

    @Override
    public void callStatement() {

    }

    @Override
    public void handlerResult(ResultSet resultSet) {

    }

    @Override
    public void handlerResult(Integer value) {

    }
}