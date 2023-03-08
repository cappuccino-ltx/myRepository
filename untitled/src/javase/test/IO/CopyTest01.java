package javase.test.IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyTest01 {
    public static void main(String[] args){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream("D:\\IDEA\\untitled\\src\\javase\\test\\IO\\HelloWorld");
            fos = new FileOutputStream("D:\\IDEA\\untitled\\src\\javase\\test\\IO\\HelloWorld01");
            int readCount = 0;
            byte[] bytes = new byte[4];
            while((readCount = fis.read(bytes)) != -1){
                fos.write(bytes,0,readCount);
            }
            fos.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
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
