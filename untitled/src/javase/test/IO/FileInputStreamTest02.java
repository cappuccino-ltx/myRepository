package javase.test.IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamTest02 {
    public static void main (String[] args){
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("D:\\IDEA\\untitled\\src\\javase\\test\\IO\\HelloWorld");
            int readCount = 0;
            byte[] bytes = new byte[4];
            while ((readCount = fis.read(bytes)) != -1){
                System.out.print(new String(bytes,0,readCount));
            }
            //int c = fis.read();
            //System.out.println(c);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
