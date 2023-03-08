package javase.test.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * �÷�����ƻ�ȡһ����ķ��������ҵ���
 */
public class MethodTest01 {
    public static void main(String[] args){
        try {
            Class Student = Class.forName("javase.test.reflect.Student");
            Object obj = Student.newInstance();

            Method loginMethod = Student.getDeclaredMethod("login",String.class,String.class);
            Object returnValue = loginMethod.invoke(obj,"admin","123");
            System.out.println(returnValue);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
