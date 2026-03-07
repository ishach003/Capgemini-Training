package Student_laptop;

import Student_laptop.dao.StudentDao;
import Student_laptop.dao.StudentDaoImpl;

public class Main {

    public static void main(String[] args) {

        StudentDao dao = new StudentDaoImpl();

        // Save Data
        //dao.saveData();

       // Fetch Laptop from Student
      // dao.fetchLaptopFromStudent(1);

       //Fetch Student from Laptop
       //dao.fetchStudentFromLaptop(1);

       //  Update Laptop Brand
      //dao.updateLaptopBrand(1, "HP");

        // Update Student Course
      //  dao.updateStudentCourse(1, "Spring Boot");

       // Change Laptop for Student
        //dao.changeLaptopForStudent(1, 10);

        //Remove Laptop from Student
       // dao.removeLaptopFromStudent(1);

        // Delete Student and Laptop
        dao.deleteStudentAndLaptop(1);

        System.out.println("All operations executed successfully");
    }
}
