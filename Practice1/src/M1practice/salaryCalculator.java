package M1practice;

import java.util.Arrays;
import java.util.List;

class SalaryData{
    String name;
    int daysInMonth;
    double salary;

    public SalaryData(String name, int daysInMonth, double salary) {
        this.name = name;
        this.daysInMonth = daysInMonth;
        this.salary = salary;
    }
}

class svaildator{
    public String calidateSalaryData(SalaryData s)throws Exception{
        List<Integer> list= Arrays.asList(28,30,31);
        if(!list.contains(s.daysInMonth)){
            throw new InvaildDayException("Invalid Days");
        } else if (s.salary<0 || s.salary>1000000) {
            throw new InvaildSalaryException("Invalid Salary");
        }
         else{
            return "Valid Data";
        }


    }
    public double getTotalSalary(SalaryData s){
        try{
            calidateSalaryData(s);
            return s.daysInMonth*s.salary;
        }
        catch (Exception e){
            return 0.0;
        }

    }
}

class InvaildDayException extends Exception{
    public InvaildDayException(String str){
        super(str);
    }
}

class InvaildSalaryException extends Exception{
    public InvaildSalaryException(String str){
        super(str);
    }
}

public class salaryCalculator {
    static void main(String[] args) throws Exception {
        SalaryData s=new SalaryData("Steve",30,10000);
        svaildator v=new svaildator();
        System.out.println(v.calidateSalaryData(s));
        System.out.println(v.getTotalSalary(s));
    }


}
