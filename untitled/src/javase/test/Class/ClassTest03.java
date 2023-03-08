package javase.test.Class;
/**
 * 装箱的意义：
 *      当我们有一个基本数据类型
 *      但一个方法需要的参数是一个引用数据类型的时候，
 *      这个时候可以将基本数据类型进行装箱操作，然后传给方法。
 *      八个封装类
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
        //这种写法在java9后不建议使用，

        //这叫自动装箱，
        Integer a = 3;
        //将一个基本数据类型封装成对象的形式叫做“装箱”


        //System.out.println(a);
        print(a);

        //拆箱：
        //将封装好的对象，转换成基本数据类型的形式，叫做拆箱；
        int num = a.intValue();//将a中的值以int类型进行转换
        System.out.println(num);
        double num1 = a.doubleValue();//将a以double类型进行转化
        System.out.println(num1);

        //也可以自动拆箱
        int x = a;
        System.out.println(x);
    }

    public static void print(Object obj){
        System.out.println(obj);
    }
}
