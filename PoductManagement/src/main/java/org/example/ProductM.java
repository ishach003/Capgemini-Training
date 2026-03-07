package org.example;

import com.mysql.cj.jdbc.Driver;
import java.sql.*;

public class ProductM {
    private static final String URL = "jdbc:mysql://localhost:3306/productmanagement?useSSL=false&serverTimezone=UTC";;
    private static final String USER = "root";
    private static final String PASSWORD = "isha2003@";

    public static Connection getConnection() {

        System.out.println("INSIDE getConnection");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded");

            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connection Created");

            return conn;

        } catch (Exception e) {
            System.out.println("CONNECTION ERROR:");
            e.printStackTrace();
            return null;
        }
    }

}
