package Image;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ImageStore {
    public static void main(String[] args) {
        String sourcePath="Image/image.png";
        String destination="Image/copied.png";

        try{
            FileInputStream fis=new FileInputStream(sourcePath);
            FileOutputStream fos=new FileOutputStream(destination);

            byte[] buffer =new byte[1024];
            int bytesRead;

            while((bytesRead=fis.read(buffer))!= -1){
                fos.write(buffer,0,bytesRead);
            }
            fis.close();
            fos.close();

            System.out.println("kkk");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
