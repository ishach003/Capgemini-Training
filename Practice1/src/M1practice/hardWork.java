package M1practice;

import java.util.ArrayList;
import java.util.List;

class Employee{
    String name;
    String projectName;
    int workingHrs;
    int bonous;

    public Employee(String name,String projectName,int workingHrs){
        this.name=name;
        this.projectName=projectName;
        this.workingHrs=workingHrs;
        this.bonous=0;

    }
    public String setBonous(){
        ArrayList<String> list=new ArrayList<>();
        list.add("web");
        list.add("tech");
        list.add("hack");
        list.add("SD");
        list.add("PD");
        if (list.contains(projectName) && workingHrs>=30){
            bonous=workingHrs/10;
            return "Congrats";
        }
        else {
            return "Work hard";
        }
    }

    public String checkName(){
        if(name=="doselect"){
          String str=projectName+workingHrs;
          return str;
        }
        else{
            String str=projectName+bonous;
            return str;
        }
    }

}

public class hardWork {
    static void main(String[] args) {
        Employee employee=new Employee("doselecti","hack",45);
        System.out.println(employee.setBonous());
        System.out.println(employee.checkName());
    }
}
