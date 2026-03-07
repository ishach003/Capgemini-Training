package objectivewrite_read;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class ObjectWrite {


    public static void main(String[] args) {

        Student s=new Student(1,"Ion");
        Student s1= new Student(2,"Raj");
        Student s2 =new Student(3,"Sam");

        try(ObjectOutputStream out= new ObjectOutputStream
                (new FileOutputStream("data/studentObj.txt"))){

            out.writeObject(s);
            out.writeObject(s1);
            out.writeObject(s2);

            System.out.println("Objects Saved Successfully");
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
