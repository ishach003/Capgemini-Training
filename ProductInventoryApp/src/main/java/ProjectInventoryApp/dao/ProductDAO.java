package ProjectInventoryApp.dao;
import ProjectInventoryApp.model.Product;
import ProjectInventoryApp.util.DBConnection;

import java.sql.*;
import java.util.*;
public class ProductDAO {
    public void addProduct(Product p) {

        String sql = "INSERT INTO products VALUES (?,?,?,?,?,?,NOW())";

        try(Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)){

            ps.setInt(1, p.getProductId());
            ps.setString(2, p.getProductName());
            ps.setString(3, p.getCategory());
            ps.setDouble(4, p.getPrice());
            ps.setInt(5, p.getQuantity());
            ps.setDouble(6, p.getRating());

            ps.executeUpdate();

            System.out.println("Product added successfully!");

        }catch(SQLException e){
            System.out.println("Error: Product ID already exists.");
        }
    }

    public void viewAllProducts() {

        String sql = "SELECT * FROM products";

        try(Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql)){

            while(rs.next()) {

                System.out.println(
                        rs.getInt("product_id")+" "+
                                rs.getString("product_name")+" "+
                                rs.getString("category")+" "+
                                rs.getDouble("price")+" "+
                                rs.getInt("quantity")+" "+
                                rs.getDouble("rating"));
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void viewProductById(int id) {

        String sql = "SELECT * FROM products WHERE product_id=?";

        try(Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)){

            ps.setInt(1,id);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                System.out.println(rs.getString("product_name"));
            }
            else{
                System.out.println("Product not found");
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void updatePrice(int id,double price){

        String sql="UPDATE products SET price=? WHERE product_id=?";

        try(Connection con=DBConnection.getConnection();
            PreparedStatement ps=con.prepareStatement(sql)){

            ps.setDouble(1,price);
            ps.setInt(2,id);

            int rows=ps.executeUpdate();

            if(rows>0)
                System.out.println("Price updated successfully.");
            else
                System.out.println("Product not found.");

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void updateQuantity(int id,int qty){

        String sql="UPDATE products SET quantity=? WHERE product_id=?";

        try(Connection con=DBConnection.getConnection();
            PreparedStatement ps=con.prepareStatement(sql)){

            ps.setInt(1,qty);
            ps.setInt(2,id);

            ps.executeUpdate();

            System.out.println("Quantity updated");

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void deleteProduct(int id){

        String sql="DELETE FROM products WHERE product_id=?";

        try(Connection con=DBConnection.getConnection();
            PreparedStatement ps=con.prepareStatement(sql)){

            ps.setInt(1,id);

            int rows=ps.executeUpdate();

            if(rows>0)
                System.out.println("Product deleted");
            else
                System.out.println("Product does not exist.");

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void searchProduct(String keyword){

        String sql="SELECT * FROM products WHERE product_name LIKE ?";

        try(Connection con=DBConnection.getConnection();
            PreparedStatement ps=con.prepareStatement(sql)){

            ps.setString(1,"%"+keyword+"%");

            ResultSet rs=ps.executeQuery();

            while(rs.next()){
                System.out.println(rs.getString("product_name"));
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void lowStockProducts(){

        String sql="SELECT * FROM products WHERE quantity < 5";

        try(Connection con=DBConnection.getConnection();
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(sql)){

            while(rs.next()){
                System.out.println(rs.getInt("product_id")+" "+
                        rs.getString("product_name")+" "+
                        rs.getInt("quantity"));
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
