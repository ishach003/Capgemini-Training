package stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

record Student(
      int id,
      String name,
      String course,
      int age,
      double marks,
      int yearOfStudy,
      String city
){}

public class PStudent {
    public static void main(String[] args) {
        List<Student> students= Arrays.asList(
                new Student(1, "Aman", "DataScience", 19, 80, 1, "Mumbai"),
                new Student(2, "Riya", "ComputerScience", 21, 72, 3, "Delhi"),
                new Student(3, "Karan", "DataScience", 20, 85, 2, "Mysore"),
                new Student(4, "Sneha", "Mechanical", 22, 65, 4, "Jaipur"),
                new Student(5, "Arjun", "Civil", 23, 58, 4, "Mumbai"),
                new Student(6, "Priya", "DataScience", 24, 90, 3, "Chennai"),
                new Student(7, "Neha", "Electrical", 20, 88, 2, "Mumbai"),
                new Student(8, "Rahul", "ComputerScience", 22, 60, 4, "Kolkata"),
                new Student(9, "Simran", "DataScience", 21, 78, 3, "Madurai"),
                new Student(10, "Vikram", "Civil", 25, 62, 4, "Pune")
        );
        List<String> result=task6(students);
        System.out.println(result);
    }

    //Task 4
    public static List<String> task4(List<Student> list){
        return list.stream()
                .filter(e-> !(e.course().equalsIgnoreCase("DataScience")
                && e.marks()>75 && e.yearOfStudy()<=2))
                .sorted(Comparator.comparing(Student::marks).reversed()
                        .thenComparing(Student::age))
                .map(e->e.name().toLowerCase())
                .collect(Collectors.toList());
    }

    //Task 5
    public static List<String > task5(List<Student> list){
        return list.stream()
                .filter(e->!(e.city().startsWith("M")
                        && e.marks()>=60 && e.marks()<=90
                && e.age()>20))
                .sorted(Comparator.comparing(Student::yearOfStudy)
                        .thenComparing(Comparator.comparing(Student::marks).reversed()))
                .map(e->String.valueOf(e.id()))
                .collect(Collectors.toList());
    }

    //Task 6
    public static List<String> task6(List<Student> list){
        return list.stream()
                .filter(e->!(e.course().length()>4
                && e.marks()<65 && e.yearOfStudy()==4))
                .sorted(Comparator.comparing(Student::age).reversed()
                        .thenComparing(Student::city))
                .map(e->new StringBuilder(e.name()).reverse().toString())
                .collect(Collectors.toList());
    }
}
