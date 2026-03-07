package Capp;


import java.util.*;


// Custom Checked Exception - Credits
class InvalidCreditException extends Exception {
    public InvalidCreditException(String message) {
        super(message);
    }
}


// Custom Checked Exception - CGPA
class InvalidCGPAException extends Exception {
    public InvalidCGPAException(String message) {
        super(message);
    }
}



// Student Class
class Student implements Comparable<Student> {

    private int studentId;
    private String name;
    private String course;
    private int credits;
    private double cgpa;

    public Student(int studentId, String name, String course,
                   int credits, double cgpa)
            throws InvalidCreditException, InvalidCGPAException {
        // validation logic here
        if(credits<1 || credits>5){
            throw new InvalidCreditException("InvalidCresitException");
        }
        if (cgpa<0 || cgpa>10){
            throw new InvalidCGPAException("InvalidCGPAException");
        }
        this.studentId=studentId;
        this.name=name;
        this.course=course;
        this.credits=credits;
        this.cgpa=cgpa;

    }

    public int getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public String getCourse() {
        return course;
    }

    public int getCredits() {
        return credits;
    }

    public double getCgpa() {
        return cgpa;
    }

    // Natural ordering (optional use)
    @Override
    public int compareTo(Student other) {
        // comparison logic
        return Double.compare(other.cgpa, this.cgpa);
    }
}



// Comparator for Course Ranking
class CourseRankingComparator implements Comparator<Student> {

    @Override
    public int compare(Student s1, Student s2) {
        // Higher CGPA
        // Higher credits
        // Name ascending

        if(s1.getCgpa()!=s2.getCgpa())
            return Double.compare(s1.getCgpa(),s2.getCgpa());
        if(s1.getCredits()!=s2.getCredits())
            return Double.compare(s1.getCredits(),s2.getCredits());
        return s2.getName().compareTo(s1.getName());
    }
}



// Registration System Class
class RegistrationSystem {

    private Map<String, PriorityQueue<Student>> courseMap;

    public RegistrationSystem() {
        // initialize map
        courseMap=new HashMap<>();
    }

    public void registerStudent(Student student) {
        // group by course
        // maintain top 2 using PriorityQueue
        courseMap.putIfAbsent(student.getCourse(), new PriorityQueue<>(new CourseRankingComparator()));
        PriorityQueue<Student> pq=courseMap.get(student.getCourse());
        pq.offer(student);

        if (pq.size()>2) pq.poll();
    }

    public List<Student> getSelectedStudents() {
        // collect top students from all courses
        // sort globally by CGPA descending
        List<Student> list=new ArrayList<>();
        for (PriorityQueue<Student> pq:courseMap.values())
            list.addAll(pq);

        Collections.sort(list);

        return list;

    }
}



// Main Class
public class University {

    public static void main(String[] args) {
        RegistrationSystem system = new RegistrationSystem();

        try {
            Student s1 = new Student(1, "John", "CS", 4, 8.5);
            system.registerStudent(s1);
        } catch (Exception e) {
            System.out.println("Exception: " + e.getClass().getSimpleName());
        }

        try {
            Student s2 = new Student(2, "Alice", "CS", 3, 9.1);
            system.registerStudent(s2);
        } catch (Exception e) {
            System.out.println("Exception: " + e.getClass().getSimpleName());
        }

        try {
            Student s3 = new Student(3, "Bob", "IT", 6, 7.5); // invalid
            system.registerStudent(s3);
        } catch (Exception e) {
            System.out.println("Exception: " + e.getClass().getSimpleName());
        }

        try {
            Student s4 = new Student(4, "Carol", "IT", 4, 9.0);
            system.registerStudent(s4);
        } catch (Exception e) {
            System.out.println("Exception: " + e.getClass().getSimpleName());
        }

        try {
            Student s5 = new Student(5, "Dave", "CS", 5, 9.1);
            system.registerStudent(s5);
        } catch (Exception e) {
            System.out.println("Exception: " + e.getClass().getSimpleName());
        }

        List<Student> result = system.getSelectedStudents();

        for (Student s : result) {
            System.out.println(s.getName() + " " + s.getCourse() + " " + s.getCgpa());
        }
    }

}
