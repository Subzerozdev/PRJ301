/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author TNO
 */
public class DBUtils {

    private static final String DB_NAME = "ManageStudent";
    private static final String DB_USER_NAME = "sa";
    private static final String DB_PASSWORD = "123456";

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url = "jdbc:sqlserver://localhost:1433;databaseName=" + DB_NAME;
        conn = DriverManager.getConnection(url, DB_USER_NAME, DB_PASSWORD);
        return conn;
    }

    public static void main(String[] args) {
        try {
            Connection conn = DBUtils.getConnection();
            if (conn != null) {
                System.out.println("Kết nối thành công đến cơ sở dữ liệu.");
                conn.close();
            } else {
                System.out.println("Không thể kết nối đến cơ sở dữ liệu.");
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Lỗi khi thử kết nối đến cơ sở dữ liệu: " + e.getMessage());
        }
    }
}
