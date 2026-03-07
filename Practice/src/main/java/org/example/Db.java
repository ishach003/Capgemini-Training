package org.example;


import com.mysql.cj.jdbc.Driver;
import java.sql.*;

public class Db {
    public static void main(String[] args) throws SQLException {
        Driver driver = new Driver();
        DriverManager.registerDriver(driver);

        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/java_cap",
                "root",
                "isha2003@"
        );

        Statement statement = connection.createStatement();

        int rowInserted = statement.executeUpdate(
                "INSERT INTO emp VALUES ('2 ','Chaits','Team Lead','7902','1980-08-24','8000.00',500,'20')"
        );

        if (rowInserted > 0) {
            System.out.println(rowInserted + "row Inserted");
        } else {
            System.out.println("Insert failed");
        }
//
        ResultSet rs = statement.executeQuery(
                "SELECT * FROM emp"
        );

        // Print
        while (rs.next()) {
            Double id = rs.getDouble("empno");
            String name = rs.getString("ename");
            String job= rs.getString("job");

            System.out.println(id + " | " + name + " | " + job);
        }

//        // UPDATE
//        int rowsUpdated=statement.executeUpdate(
//                "UPDATE emp SET job='CEO' where empno=6789"
//        );
//
//        if(rowsUpdated>0){
//            System.out.println(rowsUpdated+"row updated");
//        }else{
//            System.out.println("Update failed");
//        }

        //DELETE
//        int rowDeleted=statement.executeUpdate(
//                "DELETE FROM emp WHERE empno=6789"
//        );
//        if(rowDeleted>0){
//            System.out.println(rowDeleted+"rows deleted");
//        }
//        else{
//            System.out.println("Delete failed");
//        }
    }
}
