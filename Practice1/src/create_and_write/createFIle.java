package create_and_write;

import java.io.File;

public class createFIle {
    public static void main(String[] args){
        File file=new File("data/student.txt");

        try{
            if(file.createNewFile()){
                System.out.println("file Created Successfully");
            }
            else{
                System.out.println("File already Exists");
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
