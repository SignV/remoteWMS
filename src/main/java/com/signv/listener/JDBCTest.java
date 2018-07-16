package com.signv.listener;

import java.sql.*;

public class JDBCTest {
    /**
     * 使用JDBC连接并操作mysql数据库
     */
    public static Connection useMySQL() {
        // 数据库驱动类名的字符串
        String driver = "com.mysql.jdbc.Driver";
        // 数据库连接串
        String url = "jdbc:mysql://127.0.0.1:3306/remotewms";
        // 用户名
        String username = "root";
        // 密码
        String password = "asd8650162";
        Connection conn = null;;
        try {
            // 1、加载数据库驱动（ 成功加载后，会将Driver类的实例注册到DriverManager类中）
            Class.forName(driver );
            // 2、获取数据库连接
            conn = DriverManager.getConnection(url, username, password);
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * 操作EPC码出入库
     */
    public static Boolean epcSocket(Connection conn ,String epcCode) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql1 = "SELECT * FROM  epc WHERE epc_code = ?";
            ps = conn.prepareStatement(sql1);
            ps.setString(1,epcCode);
            rs = ps.executeQuery();
            if(!rs.next()){
                return false;
            }else {
                int goodsId = rs.getInt(3);
                int num = rs.getInt(4);
                boolean outInStatus = rs.getBoolean(5);
                String sql2 = "SELECT * FROM goods where goods_id = ?";
                ps = conn.prepareStatement(sql2);
                ps.setString(1,String.valueOf(goodsId));
                rs = ps.executeQuery();
                while (rs.next()){
                    System.out.println(rs.getString(2));
                }
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 7、关闭对象，回收数据库资源
            if (rs != null) { //关闭结果集对象
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (ps != null) { // 关闭数据库操作对象
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) { // 关闭数据库连接对象
                try {
                    if (!conn.isClosed()) {
                        conn.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
    /**
     * 使用JDBC连接并操作mysql数据库
     */
    public static void useSQL(String data) {
        // 数据库驱动类名的字符串
        String driver = "com.mysql.jdbc.Driver";
        // 数据库连接串
        String url = "jdbc:mysql://127.0.0.1:3306/remotewms";
        // 用户名
        String username = "root";
        // 密码
        String password = "asd8650162";
        Connection conn = null;
        Statement stmt = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            // 1、加载数据库驱动（ 成功加载后，会将Driver类的实例注册到DriverManager类中）
            Class.forName(driver );
            // 2、获取数据库连接
            conn = DriverManager.getConnection(url, username, password);

            // 4、定义操作的SQL语句
            String sql = "insert into out_in_statistics(out_in_goods_name) values(?)";
            // 5、执行数据库操作
            // 3、获取数据库操作对象
            ps = conn.prepareStatement(sql);
            ps.setString(1,data);
            ps.executeUpdate();
//            rs = stmt.executeQuery(sql);
            // 6、获取并操作结果集
//            while (rs.next()) {
//                System.out.println(rs.getInt("id"));
//                System.out.println(rs.getString("name"));
//            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 7、关闭对象，回收数据库资源
            if (rs != null) { //关闭结果集对象
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (ps != null) { // 关闭数据库操作对象
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) { // 关闭数据库连接对象
                try {
                    if (!conn.isClosed()) {
                        conn.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
