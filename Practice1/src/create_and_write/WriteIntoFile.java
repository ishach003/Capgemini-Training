package create_and_write;

import java.io.FileWriter;
import java.io.IOException;

public class WriteIntoFile {

    public static void doWrite() throws IOException {
        FileWriter writer =new FileWriter("data/student.txt",true);

        writer.write("\nName:james");
        writer.write("\nCourse: Golang");
        writer.write("\nMarks:85");

        writer.close();
    }

    public static void main(String[] args) {
        try {
            doWrite();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
