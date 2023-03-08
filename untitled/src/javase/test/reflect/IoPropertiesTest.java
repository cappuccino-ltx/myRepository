package javase.test.reflect;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * ��ȡ�����ļ��е��������÷�����ƴ�������
 */
public class IoPropertiesTest {
    public static void main(String[] args){
        //��ȡ�ļ��ľ���·��
        /*String path = Thread.currentThread().getContextClassLoader()
                .getResource("javase.test.reflect.Student").getPath();
        */
        //Ҳ���Ի�ȡ��������·����������ʽ����
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
