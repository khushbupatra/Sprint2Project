package com.nisum;

import java.sql.Connection;
import java.sql.DriverManager;

// Test class - create in src/test/java/com/nisum/
public class DatabaseTest {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/project", "root", "root");
            System.out.println("Database connected successfully!");
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}