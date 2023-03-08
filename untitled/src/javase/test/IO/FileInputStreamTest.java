package javase.test.IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamTest {
    public static void main(String[] args){
        FileInputStream file = null;
        try {
            file = new FileInputStream("D:\\IDEA\\untitled\\src\\javase\\test\\IO\\HelloWorld");
            int readCount = 0;
            byte[] bytes = new byte[4];
            while((readCount = file.read(bytes)) != -1){
                System.out.print(new String(bytes, 0, readCount));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            if (file != null) {
                try {
                    file.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
