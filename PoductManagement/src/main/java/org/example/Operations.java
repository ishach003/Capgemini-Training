package org.example;

import java.sql.*;
import java.sql.Connection;

public class Operations {

    public static void addProduct(Integer product_id,String product_name,String category,Double price,Integer quantity,Float rating,String manufacturer)  {
        String sql = "INSERT INTO products " +
                "(product_id, product_name, category, price, quantity, rating, manufacturer) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = ProductM.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, product_id);
            ps.setString(2, product_name);
            ps.setString(3, category);
            ps.setDouble(4, price);
            ps.setInt(5, quantity);
            ps.setFloat(6, rating);
            ps.setString(7, manufacturer);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("✅ Product Inserted Successfully");
            } else {
                System.out.println("❌ Insert Failed");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void display()  {
        try {
            System.out.println("STEP 1");

            Connection conn = ProductM.getConnection();
            System.out.println("Current DB: " + conn.getCatalog());

            System.out.println("STEP 2");

            if (conn == null) {
                System.out.println("Connection is NULL ❌");
                return;
            }

            System.out.println("STEP 3");

            String sql = "SELECT * FROM products";
            PreparedStatement ps = conn.prepareStatement(sql);

            System.out.println("STEP 4");

            ResultSet rs = ps.executeQuery();

            System.out.println("STEP 5");

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("product_id"));
            }

            System.out.println("STEP 6");

            conn.close();

        } catch (Exception e) {
            System.out.println("ERROR OCCURRED:");
            e.printStackTrace();
        }
        System.out.println("Press Enter to continue...");
        new java.util.Scanner(System.in).nextLine();

    }

    public static void updateProduct(int id, String field, String newValue) {
        String sql = "UPDATE products SET " + field + " = ? WHERE product_id = ?";

        try (Connection conn = ProductM.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            // Set value based on column type
            switch (field) {
                case "product_name":
                case "category":
                case "manufacturer":
                    ps.setString(1, newValue);
                    break;

                case "price":
                    ps.setDouble(1, Double.parseDouble(newValue));
                    break;

                case "quantity":
                    ps.setInt(1, Integer.parseInt(newValue));
                    break;

                case "rating":
                    ps.setFloat(1, Float.parseFloat(newValue));
                    break;
            }

            ps.setInt(2, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("✅ Product Updated Successfully");
            } else {
                System.out.println("❌ Product Not Found");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteProduct(int id)  {

        String sql = "DELETE FROM products WHERE product_id = ?";

        try (Connection conn = ProductM.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("✅ Product Deleted Successfully");
            } else {
                System.out.println("❌ Product Not Found");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
