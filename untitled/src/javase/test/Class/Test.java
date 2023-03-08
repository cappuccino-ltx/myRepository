package javase.test.Class;

public class Test {
    public static void main(String[] args){
        //可以直接构造：
        String s1 = "Hello";

        //可以给构造方法一个字符串：
        String s2 = new String("Hello");

        //可以给构造方法一个byte数组：
        byte[] byteArray = {97 , 98, 99};
        String s3 = new String(byteArray);
        System.out.println(s3);//abc
        //给byte数组的一部分,从下标为1的元素，长度为2
        String s4 = new String(byteArray, 1, 2);
        System.out.println(s4);//bc

        //给构造方法一个char数组：
        char[] charArray = {'我', '是', '学', '生'};
        String s5 = new String(charArray);
        System.out.println(s5);//我是学生
        //给char数组的一部分，从下表为2，长度为2
        String s6 = new String(charArray, 2, 2);
        System.out.println(s6);//学生

        /**
         * 用StringBuffer和StringBuilder进行字符串的拼接
         */
        //StringBuffer是线程安全的，至于StringBuilder就不知道了
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
