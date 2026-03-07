package M1practice;
import java.util.*;
class Salary{
    HashMap<String,Integer> empList=new HashMap<>();

    public int totalSalary(){
        int totSalary=0;
//        for(HashMap.Entry<String,Integer> h:empList.entrySet()){
//            totSalary=totSalary+h.getValue();
//        }

        for(Integer i:empList.values()){
            totSalary+=i;
        }

        return totSalary;
    }

    public String getSalary(String designation){
//        for(HashMap.Entry<String,Integer> h:empList.entrySet()){
//            if(h.getKey()==designation) {
//                return "Salary is " + h.getValue();
//            }
//        }


        if(empList.containsKey(designation)){
            return "Salary is "+empList.get(designation);
        }
        return "No designation Match";
    }

    public void  updateSalary(String designation ,int newSalary){
//        for(HashMap.Entry<String,Integer> h:empList.entrySet()){
//            if(h.getKey()==designation){
//                h.setValue(newSalary);
//            }
//        }

      empList.put(designation,newSalary);
    }
}

public class EmployeeSalary {
    static void main(String[] args) {
        Salary obj=new Salary();
        obj.empList.put("CEO",20000);
        obj.empList.put("Developer",5000);

        System.out.println(obj.totalSalary());
        obj.updateSalary("Developer",6000);
        System.out.println(obj.getSalary("Developer"));;
     }
}
