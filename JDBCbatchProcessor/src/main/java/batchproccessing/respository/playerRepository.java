package batchproccessing.respository;

import java.sql.Connection;
import java.sql.DriverManager;

public class playerRepository {
    public static Connection getConnection(){
        try{
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/player",
                    "root",
                    "isha2003@"
            );
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
