package javase.test.IO;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class serializaTest01 {
    public static void main(String[] args){
        Students s = new Students("zhangsan",1);
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("students"));
            oos.writeObject(s);
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if (oos != null){
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
