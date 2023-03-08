package javase.test.Class;

public class Test {
    public static void main(String[] args){
        //����ֱ�ӹ��죺
        String s1 = "Hello";

        //���Ը����췽��һ���ַ�����
        String s2 = new String("Hello");

        //���Ը����췽��һ��byte���飺
        byte[] byteArray = {97 , 98, 99};
        String s3 = new String(byteArray);
        System.out.println(s3);//abc
        //��byte�����һ����,���±�Ϊ1��Ԫ�أ�����Ϊ2
        String s4 = new String(byteArray, 1, 2);
        System.out.println(s4);//bc

        //�����췽��һ��char���飺
        char[] charArray = {'��', '��', 'ѧ', '��'};
        String s5 = new String(charArray);
        System.out.println(s5);//����ѧ��
        //��char�����һ���֣����±�Ϊ2������Ϊ2
        String s6 = new String(charArray, 2, 2);
        System.out.println(s6);//ѧ��

        /**
         * ��StringBuffer��StringBuilder�����ַ�����ƴ��
         */
        //StringBuffer���̰߳�ȫ�ģ�����StringBuilder�Ͳ�֪����
        String a = "http://";
        StringBuffer sb = new StringBuffer(a);
        sb.append("java.com");
        System.out.println(sb);

        String s = sb.toString();
        System.out.println(s);

        StringBuilder strBuilder = new StringBuilder("https://");
        strBuilder.append("baidu");
        strBuilder.append(".com");
        System.out.println(strBuilder);
    }
}
