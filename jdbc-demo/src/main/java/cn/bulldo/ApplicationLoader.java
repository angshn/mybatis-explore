package cn.bulldo;

import java.sql.*;

public class ApplicationLoader {

    public static void main(String[] args) throws SQLException {
        // 数据库连接配置
        final String username = "root";
        final String password = "123456";
        final String jdbcUrl = "jdbc:mysql://localhost:3306/mydb?useSSL=false&characterEncoding=utf8";

        // 打开数据库连接
        Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
        // 获取Statement实例
//        Statement statement = connection.createStatement();
        final String sql = "SELECT name FROM user WHERE id = ? ";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, "1'");
        // 通过statement执行sql
        ResultSet resultSet = statement.executeQuery();

        // 解析结果集
        while (resultSet.next()) {
            String userName = resultSet.getString("name");
            System.out.println("Queried user name = " + userName);
        }

        // 关闭资源
        resultSet.close();
        statement.close();
        connection.close();
    }
}
