package javase.test.reflect;

import java.util.ResourceBundle;

/**
 *
 * 在java.util包下，有一个ResourceBundle的类，
 *      用于资源绑定：但是有一个限制，就是只能绑定.properties后缀名的文件
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
