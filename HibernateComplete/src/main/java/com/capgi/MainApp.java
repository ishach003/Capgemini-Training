package com.capgi;

import com.capgi.dao.StudentDAOImpl;
import com.capgi.dao.StudentDMO;
import com.capgi.entity.Student;

import java.util.List;

public class MainApp {
    public static void main(String[] args) {

        // Create DAO object
        StudentDMO dao = new StudentDAOImpl();

        //  Save a student
        Student s1 = new Student("Isha", "CSE", 20, 95.5);
        dao.save(s1);

        Student s2 = new Student("Rahul", "ECE", 21, 88.0);
        dao.save(s2);

        //  Fetch all students
        List<Student> allStudents = dao.fetchAll();
        System.out.println("All Students: " + allStudents);

        // Fetch by ID
        Student fetched = dao.fetchById(1);
        System.out.println("Fetched Student with ID 1: " + fetched);

        //Update marks
        dao.updateMarks(2, 92.0);
        System.out.println("Updated marks for ID 2: " + dao.fetchById(2));

        // Delete a student
        dao.delete(1);
        System.out.println("After deletion, all students: " + dao.fetchAll());

        //  Sort by marks
        List<Student> sortedByMarks = dao.sortByMarks();
        System.out.println("Students sorted by marks: " + sortedByMarks);

        // Sort by age descending
        List<Student> sortedByAge = dao.sortByAgeDesc();
        System.out.println("Students sorted by age descending: " + sortedByAge);

        // Filter by department
        List<Student> cseStudents = dao.filterByDept("CSE");
        System.out.println("Students in CSE dept: " + cseStudents);

        // Native fetch
        List<String> names = dao.nativeFetch();
        System.out.println("All student names: " + names);

        //  Native update marks
        dao.nativeUpdateMarks(2, 99.5);
        System.out.println("After native update, student ID 2: " + dao.fetchById(2));
}}

