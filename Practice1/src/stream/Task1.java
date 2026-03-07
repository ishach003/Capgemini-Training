package stream;

import java.util.*;
import java.util.stream.Collectors;

    record Employee(int id, String name, String jobTitle, int experience, double salary, int rating) {}

    public class Task1 {

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            List<Employee> employees = Arrays.asList(
                    new Employee(1, "Alice", "Manager", 2, 120000, 5),
                    new Employee(2, "Bob", "Developer", 5, 80000, 3),
                    new Employee(3, "Charlie", "Manager", 10, 150000, 2)
            );

            List<String> result = processEmployees(employees);


            if (result.isEmpty()) {
                System.out.println("No employees matched the criteria.");
            } else {
                result.forEach(System.out::println);
            }

            List<Integer> result2 = processTask2(employees);

            System.out.println("Task 2 Output:");
            result2.forEach(System.out::println);

            sc.close();
        }

        //task 1
        public static List<String> processEmployees(List<Employee> list) {
            return list.stream()
                    // 1. Filter: Remove managers with salary > 100k AND < 3 years exp
                    .filter(e -> !(e.jobTitle().equalsIgnoreCase("Manager")
                            && e.salary() > 100000
                            && e.experience() < 3))

                    // 2. Sort: Experience DESC, then Rating ASC
                    .sorted(Comparator.comparing(Employee::experience).reversed()
                            .thenComparing(Employee::rating))

                    // 3. Map: Reverse Name and Uppercase
                    .map(e -> new StringBuilder(e.name())
                            .reverse()
                            .toString()
                            .toUpperCase())

                    // 4. Finalize
                    .collect(Collectors.toList());
        }

        //task 2
        public static List<Integer> processTask2(List<Employee> list) {
            return list.stream()

                    // 1. Filter
                    .filter(e -> !(e.experience() < 5
                            && e.rating() < 8
                            && e.salary() >= 60000
                            && e.salary() <= 120000))

                    // 2. Sort: Salary ASC, Experience DESC
                    .sorted(Comparator.comparing(Employee::salary)
                            .thenComparing(Comparator.comparing(Employee::experience).reversed()))

                    // 3. Multiply ID by 10
                    .map(e -> e.id() * 10)

                    // 4. Collect
                    .collect(Collectors.toList());
        }
    }

