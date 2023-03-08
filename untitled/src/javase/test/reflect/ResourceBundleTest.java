package javase.test.reflect;

import java.util.ResourceBundle;

/**
 *
 * ��java.util���£���һ��ResourceBundle���࣬
 *      ������Դ�󶨣�������һ�����ƣ�����ֻ�ܰ�.properties��׺�����ļ�
 */
public class ResourceBundleTest {
    public static void main(String[] args){
        ResourceBundle bundle = ResourceBundle.getBundle("javase/test/reflect/db");
        String classname = bundle.getString("classname");
        System.out.println(classname);
        Class c = null;
        try {
            c = Class.forName(classname);
            Object obj = c.newInstance();
            System.out.println(obj);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


    }
}
