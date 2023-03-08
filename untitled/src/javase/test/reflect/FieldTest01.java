package javase.test.reflect;

import java.lang.reflect.Field;

/**
 * java.lang.reflect.Field����࣬����ͨ��������ƣ��������е�����
 */
public class FieldTest01 {
    public static void main(String[] args){
        try {
            Class c = Class.forName("javase.test.reflect.Student");
            Object obj = c.newInstance();
            //��ȡStudent�����id���ԣ�����ֵ���
            Field idField = c.getDeclaredField("id");
            idField.set(obj,1111);
            System.out.println(idField.get(obj));
            //��ȡStudent����private���ε�name����
            Field nameField = c.getDeclaredField("name");
            //����ע�⣬private���ε��������޷����з��ʵģ��������ǿ��Դ򿪷�װ����
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
