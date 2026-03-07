package stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static stream.Task1.processEmployees;

record Employee1 (
    int id,
     String name,
     String department,
     String jobTitle,
     int age,
     int yearsOfExperience,
     double salary,
     int performanceRating
){}


public class Practice {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

            List<Employee1> employees = Arrays.asList(
                    new Employee1(1, "Alice", "HR", "Manager", 30, 8, 80000, 5),
                    new Employee1(2, "Bob", "IT", "Developer", 28, 4, 70000, 7),
                    new Employee1(3, "Charlie", "HR", "Executive", 35, 10, 60000, 4),
                    new Employee1(4, "David", "Sales", "Manager", 40, 12, 150000, 9),
                    new Employee1(5, "Emma", "HR", "Lead", 29, 3, 90000, 8)
            );

            List<String> result = task3(employees);
            //List<Integer> result=task3(employees);
            result.forEach(System.out::println);
        }

    //Task 1
    public static List<String> task1(List<Employee1> list) {

        return list.stream()

                .filter(e->!(e.jobTitle().equalsIgnoreCase("Developer")
                        && e.salary()>90000 && e.yearsOfExperience()<4))
                .sorted(Comparator.comparing(Employee1::age).thenComparing(Employee1::performanceRating).reversed())
                .map(e-> e.name().toUpperCase()+"_DEV").
                collect(Collectors.toList());
    }

    //Task 2
    public static List<String > task2(List<Employee1> list){
        return list.stream()
                .filter(e->!(e.department().equalsIgnoreCase("HR")
                && e.performanceRating()<6 && e.yearsOfExperience()>6
                && e.salary()>=50000 && e.salary()<=120000))
                .sorted(Comparator.comparing(Employee1::salary).reversed()
                        .thenComparing(Employee1::yearsOfExperience))
                .map(e->  new StringBuilder(e.name()).reverse().toString())
                .collect(Collectors.toList());
    }

    //Task 3

    public static List<String> task3(List<Employee1> list){
        return list.stream()
                .filter(e->!(e.department().length()>5
                && e.age()>=28 && e.age()<=45  &&e.salary()<75000))
                .sorted(Comparator.comparing(Employee1::performanceRating).reversed()
                        .thenComparing(Employee1::name))
                .map(e->e.name()+"--"+ e.id()*5)
                .collect(Collectors.toList());

    }
    }


