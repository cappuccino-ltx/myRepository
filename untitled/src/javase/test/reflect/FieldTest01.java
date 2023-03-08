package javase.test.reflect;

import java.lang.reflect.Field;

/**
 * java.lang.reflect.Field这个类，可以通过反射机制，访问类中的属性
 */
public class FieldTest01 {
    public static void main(String[] args){
        try {
            Class c = Class.forName("javase.test.reflect.Student");
            Object obj = c.newInstance();
            //获取Student对象的id属性，并赋值输出
            Field idField = c.getDeclaredField("id");
            idField.set(obj,1111);
            System.out.println(idField.get(obj));
            //获取Student对象private修饰的name属性
            Field nameField = c.getDeclaredField("name");
            //这里注意，private修饰的属性是无法进行访问的，但是我们可以打开封装锁：
            nameField.setAccessible(true);
            nameField.set(obj,"zhangsan");
            System.out.println(nameField.get(obj));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
