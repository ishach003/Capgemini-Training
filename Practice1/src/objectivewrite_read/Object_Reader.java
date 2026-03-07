package objectivewrite_read;

import javax.xml.namespace.QName;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Object_Reader {
    public static void main(String[] args) throws IOException,ClassNotFoundException {
        ObjectInputStream in=new ObjectInputStream(
                new FileInputStream("data/studentObj.txt"));

        Student s=(Student) in.readObject();

        System.out.print(s.id+" ");
        System.out.println(s.name);

        Student s1=(Student) in.readObject();

        System.out.print(s1.id+" ");
        System.out.println(s1.name);

        Student s2=(Student) in.readObject();

        System.out.print(s2.id+" ");
        System.out.println(s2.name);

    }
}
