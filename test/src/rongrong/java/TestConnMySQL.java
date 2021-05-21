package rongrong.java;

import java.sql.*;

/**
 * @description：
 * @auther lurongrong
 * @create 2021-05-08 22:19
 */

/*
 * 研究PreparedStatement是如何防止sql注入的，我分析了一下，原来是mysql数据库产商，在实
 * 现PreparedStatement接口的实现类中的setString(int parameterIndex, String x)函
 * 数中做了一些处理，把单引号做了转义(只要用户输入的字符串中有单引号，那mysql数据库产商的setString()这个函
 * 数，就会把单引号做转义)
 */
public class TestConnMySQL {

    public static void main(String[] args) {

        String connStr = "jdbc:mysql://localhost:3306/girls?useSSL=false&characterEncoding=utf-8";
//		String sql = "select * from admin";
        String sql = "SELECT * FROM admin WHERE username = ? AND password = ?";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(connStr, "root", "root");
            System.out.println("数据库连接=" + connection);
            //Statement无法防止sql注入
//			Statement stmt = connection.createStatement();
            //PreparedStatement可以有效防止sql注入，所以生产环境上一定要使用PreparedStatement，而不能使用Statement
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setString(1, "韦小宝");
            //模拟用户输入正常的值
//			prepareStatement.setString(2, "222");
            //测试sql注入(模拟用户输入非法的值)
            prepareStatement.setString(2, "222' OR '8'='8");
            /*
             *上面那种的sql注入还算温柔了，有些更可恶的用户，他们输入的非
             *法的值是delete from tableName或truncate table tableName 这是十分危险的,
             * 更有甚者传入drop table tableName;有些数据库是不会让你成功的,但也有很多数
             * 据库就可以使这些语句执行，所以生产环境上一定要使用PreparedStatement，而不能使用Statement
             */
            //测试sql注入(模拟用户输入非法的值)在mysql中#井号表示单行注释(这是mysql中的基础知识，我就不赘述了)
//			prepareStatement.setString(2, "'; DROP TABLE tableName;#");
            //测试sql注入(模拟用户输入非法的值)
//			prepareStatement.setString(2, "'; delete from tableName;#");
            //测试sql注入(模拟用户输入非法的值)
//			prepareStatement.setString(2, "'; truncate table tableName;#");

            ResultSet rs = prepareStatement.executeQuery();
            System.out.println("sql=" + prepareStatement.toString());
            int col = rs.getMetaData().getColumnCount();
            System.out.println("============================");
            while (rs.next()) {
                for (int i = 1; i <= col; i++) {
                    System.out.print(rs.getString(i) + "\t");
                    if ((i == 2) && (rs.getString(i).length() < 8)) {
                        System.out.print("\t");
                    }
                }
                System.out.println("");
            }
            System.out.println("============================");
            rs.close();
            prepareStatement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }

}

