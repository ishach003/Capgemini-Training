package PreparedStatement;

import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreparedSt {
    public static void main(String[] args) throws SQLException {
        Driver driver=new Driver();
        DriverManager.registerDriver(driver);

        Connection connection=DriverManager.getConnection(
          "jdbc:mysql://localhost:3306/java_cap" ,
          "root",
          "isha2003@"
        );

        String sql="INSERT INTO emp VALUES(?,?,?,?,?,?,?)";

        PreparedStatement conn=connection.prepareStatement(sql);
        conn.setInt(1,3);
        conn.setString(2,"ic");
        conn.setString(3,"boss");
        conn.setDouble(4,1);
        conn.setInt(5,1000);
        conn.setInt(6,0);
        conn.setInt(7,1);

        int rowInserted=conn.executeUpdate();

        if (rowInserted > 0) {
            System.out.println(rowInserted + "row Inserted");
        } else {
            System.out.println("Insert failed");
        }


        //UPdate

//        String updateQuery="UPDATE emp SET ename=? WHERE empno=?";
//
//        PreparedStatement updateconn=connection.prepareStatement(updateQuery);
//
//        updateconn.setString(1,"icu");
//        updateconn.setInt(2,3);
//
//        int rowUpdated=updateconn.executeUpdate();
//
//        if (rowUpdated > 0) {
//            System.out.println(rowUpdated + "row Update");
//        } else {
//            System.out.println("Update failed");
//        }


        //delete

//        String deletequery="DELETE FROM emp WHERE empno=?";
//
//        PreparedStatement deleteconn=connection.prepareStatement(deletequery);
//
//        deleteconn.setInt(1,3);
//
//        int rowDeleted=deleteconn.executeUpdate();
//        if (rowDeleted > 0) {
//            System.out.println(rowDeleted + "row Deleted");
//        } else {
//            System.out.println("Delete failed");
//        }


    }
}
