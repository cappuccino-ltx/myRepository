package javase.test.Class;
/**
 * װ������壺
 *      ��������һ��������������
 *      ��һ��������Ҫ�Ĳ�����һ�������������͵�ʱ��
 *      ���ʱ����Խ������������ͽ���װ�������Ȼ�󴫸�������
 *      �˸���װ��
 *      Byte
 *      Short
 *      Integer
 *      Long
 *      Float
 *      Double
 *      Boolean
 *      Character
 */
public class ClassTest03 {
    public static void main(String[] args) {
        // Integer a = new Integer(3);
        //����д����java9�󲻽���ʹ�ã�

        //����Զ�װ�䣬
        Integer a = 3;
        //��һ�������������ͷ�װ�ɶ������ʽ������װ�䡱


        //System.out.println(a);
        print(a);

        //���䣺
        //����װ�õĶ���ת���ɻ����������͵���ʽ���������䣻
        int num = a.intValue();//��a�е�ֵ��int���ͽ���ת��
        System.out.println(num);
        double num1 = a.doubleValue();//��a��double���ͽ���ת��
        System.out.println(num1);

        //Ҳ�����Զ�����
        int x = a;
        System.out.println(x);
    }

    public static void print(Object obj){
        System.out.println(obj);
    }
}
