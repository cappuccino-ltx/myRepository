package javase.test.Class;



import java.text.DecimalFormat;
import java.math.BigDecimal;
import java.util.Random;

public class NumberClassTest06 {
    public static void main(String[] args){
        /**
         * 数字格式化： DecimalFormat 类是java.text包下的一个类；
         * 用于数字格式化
         *      # 表示任意数字
         *      , 表示千分位
         *      . 表示小数点
         *      类似于：##,###,###.### 表示保留三位小数
         */
        DecimalFormat df = new DecimalFormat("###,###.0000");
        double n1 = 12345.671;
        long n2 = 12345;

        String num = df.format(n1);
        System.out.println(num);

        String num1 = df.format(n2);
        System.out.println(num1);

        /**
         * BigDecimal 属于大数据 ，精度极高，不属于基本数据类型，属于java对象。
         * 这是专门用于财务软件当中的一种引用数据类型，
         *
         * 在财务软件当中，double其实是不够用的，
         *
         * BigDecimal 在java.math.BigDecimal
         *
         */
        //这是一个精度极大的100和200
        BigDecimal num2 = new BigDecimal(100);
        BigDecimal num3 = new BigDecimal(200);

        //两数相加:add
        BigDecimal num4 = num2.add(num3);
        System.out.println(num4);
        //两数相减:subtract
        BigDecimal num5 = num2.subtract(num3);
        System.out.println(num5);
        //两数相乘：multiply
        BigDecimal num6 = num2.multiply(num3);
        System.out.println(num6);
        //两数相除：divide
        BigDecimal num7 = num2.divide(num3);
        System.out.println(num7);

        /**
         * 产生随机数：Random
         * java.util.random;
         */

        //创建随机数对象
        Random random = new Random();
        //生成int范围内的随机数
        int rnum1 = random.nextInt();
        System.out.println(rnum1);

        //生成0~100之间的随机数
        int rnum2 = random.nextInt(101);//这个101是一个边界值，不会产生101
        System.out.println(rnum2);

    }
}
