package javase.test.reflect;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 读取配置文件中的类名，用反射机制创建对象
 */
public class IoPropertiesTest {
    public static void main(String[] args){
        //获取文件的绝对路径
        /*String path = Thread.currentThread().getContextClassLoader()
                .getResource("javase.test.reflect.Student").getPath();
        */
        //也可以获取这个对象的路径以留的形式返回
        InputStream reader = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("javase/test/reflect/db.properties");
        Properties pro = new Properties();
        try {
            pro.load(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (reader != null) {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        String classname = pro.getProperty("classname");
        System.out.println(classname);
    }
}
