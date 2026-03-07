package callable;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class EmployeeService {

    public void insertEmployee(String name, double salary){
        String sql="{CALL InsertEmployee(?,?)}";
        try(Connection conn=databaseutil.getConnection();
            CallableStatement stmt=conn.prepareCall(sql)){
            stmt.setString(1,name);
            stmt.setDouble(2,salary);
            stmt.execute();
            System.out.println("Employee inserted successfully");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

//    public List<Employee> getAllEmployee(){
//        List<Employee> employees=new ArrayList<>();
//    }
}
