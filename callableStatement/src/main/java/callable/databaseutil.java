package callable;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class databaseutil {
    private static Properties properties=new Properties();

    static {
        try (FileInputStream fis=new FileInputStream("C:\\Users\\hp\\IdeaProjects\\callableStatement\\Anything.properties")){
            properties.load(fis);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws Exception{
        return DriverManager.getConnection(
                properties.getProperty("Anything.url"),
                properties.getProperty("Anything.user"),
                properties.getProperty("Anything.password")
        );
    }
}
