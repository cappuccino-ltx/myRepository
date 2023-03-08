package javase.test.Class;

public class ClassTest04 {
    public static void main(String[] args){
        /**
         * String int Integer 之间的转换
         */
        //int转换成Stirng
        int a = 100;
        String a1 = a + "";
        System.out.println(a1);

        //String转换成int
        int a2 = Integer.parseInt(a1);
        System.out.println(a2);

        //int转换成Integer(自动装箱)
        Integer b = 101;
        System.out.println(b);

        //Integer转换成int(自动拆箱)
        int b1 = b;

        //String转换成Integer
        Integer b2 = new Integer("123");
        Integer b3 = Integer.valueOf("123");
        System.out.println(b2);
        System.out.println(b3);

        //Integer转换成String
        String c = String.valueOf(b3);
        System.out.println(c);
    }
}
