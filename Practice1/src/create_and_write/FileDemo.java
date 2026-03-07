package create_and_write;

import java.io.File;

public class FileDemo {
    public static void main(String[] args){

        //create folder reference
        File folder =new File("data");

        //check id folder exists
        if(!folder.exists()){
            boolean created= folder.mkdir();

            if(created){
                System.out.println("Folder created successfully");
            }
            else {
                System.out.println("Folder Creation Failed");
            }
        }
        else{
            System.out.println("Folder already Exists");
        }
    }

}
