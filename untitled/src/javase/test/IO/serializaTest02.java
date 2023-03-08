package javase.test.IO;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class serializaTest02 {
    public static void main(String[] args){
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("students"));
            Object o = ois.readObject();
            System.out.println(o);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally{
            if (ois != null){
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
