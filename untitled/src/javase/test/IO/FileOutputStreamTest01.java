package javase.test.IO;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamTest01 {
    public static void main(String[] args){
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("D:\\IDEA\\untitled\\src\\javase\\test\\IO\\HelloWorld");
            byte[] bytes ={97,98,99,100};
            fos.write(bytes);
            fos.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
