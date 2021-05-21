package rongrong.java;

import java.sql.*;

/**
 * @description��
 * @auther lurongrong
 * @create 2021-05-08 22:19
 */

/*
 * �о�PreparedStatement����η�ֹsqlע��ģ��ҷ�����һ�£�ԭ����mysql���ݿ���̣���ʵ
 * ��PreparedStatement�ӿڵ�ʵ�����е�setString(int parameterIndex, String x)��
 * ��������һЩ�����ѵ���������ת��(ֻҪ�û�������ַ������е����ţ���mysql���ݿ���̵�setString()�����
 * �����ͻ�ѵ�������ת��)
 */
public class TestConnMySQL {

    public static void main(String[] args) {

        String connStr = "jdbc:mysql://localhost:3306/girls?useSSL=false&characterEncoding=utf-8";
//		String sql = "select * from admin";
        String sql = "SELECT * FROM admin WHERE username = ? AND password = ?";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(connStr, "root", "root");
            System.out.println("���ݿ�����=" + connection);
            //Statement�޷���ֹsqlע��
//			Statement stmt = connection.createStatement();
            //PreparedStatement������Ч��ֹsqlע�룬��������������һ��Ҫʹ��PreparedStatement��������ʹ��Statement
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setString(1, "ΤС��");
            //ģ���û�����������ֵ
//			prepareStatement.setString(2, "222");
            //����sqlע��(ģ���û�����Ƿ���ֵ)
            prepareStatement.setString(2, "222' OR '8'='8");
            /*
             *�������ֵ�sqlע�뻹�������ˣ���Щ���ɶ���û�����������ķ�
             *����ֵ��delete from tableName��truncate table tableName ����ʮ��Σ�յ�,
             * �������ߴ���drop table tableName;��Щ���ݿ��ǲ�������ɹ���,��Ҳ�кܶ���
             * �ݿ�Ϳ���ʹ��Щ���ִ�У���������������һ��Ҫʹ��PreparedStatement��������ʹ��Statement
             */
            //����sqlע��(ģ���û�����Ƿ���ֵ)��mysql��#���ű�ʾ����ע��(����mysql�еĻ���֪ʶ���ҾͲ�׸����)
//			prepareStatement.setString(2, "'; DROP TABLE tableName;#");
            //����sqlע��(ģ���û�����Ƿ���ֵ)
//			prepareStatement.setString(2, "'; delete from tableName;#");
            //����sqlע��(ģ���û�����Ƿ���ֵ)
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

