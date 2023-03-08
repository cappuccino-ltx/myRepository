package javase.test.Class;

/**
 * java当中提供的日期类Date，可以获取这系统的时间，
 */

import java.text.SimpleDateFormat;
import java.util.Date;

public class DataClassTest05 {
    public static void main(String[] args)throws Exception {
        //获取系统当前时间，精确到毫秒
        Date nowTime = new Date();
        System.out.println(nowTime);

        //日期格式化：SimpleDateFormat  在java.text包下
        //作用就是用来格式化日期，让日期以指定的形式去输出，具体方法使用format()这个实例方法。
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒 SSS");
        String time = sdf.format(nowTime);
        System.out.println(time);

        //把一个日期类型的字符串，怎么转换成Date类型的数据；
        String dateStr = "2000/11/01 13:24:53";
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date TimeStr = sdf2.parse(dateStr);
        System.out.println(TimeStr);

        /**
         * 获取自1970年1月1日 00时00分00秒 000毫秒开始，到当前时刻的毫秒数。
         */
        //System类下的一个静态方法，返回总毫秒数，返回long类型数据：
        long newTimeMillis = System.currentTimeMillis();
        System.out.println(newTimeMillis);

        //我们可以利用这个机制去计算一个方法执行所耗费的时长

        //在执行方法前去一个毫秒数，
        long begin = System.currentTimeMillis();
        print();
        //执行方法后给一个毫秒数，
        long end = System.currentTimeMillis();
        long methodUseTime = end - begin;
        System.out.println(methodUseTime);


        /*
        此外，Date类还有一个构造方法是Date(long Date)
        参数是一个毫秒数数，意思是构造一个从1970年1月1日00时00分00秒000毫秒开始往后Date毫秒的日期
         */

        //构造一个昨天现在的日期
        Date MillisTime = new Date(System.currentTimeMillis() - 1000*60*60*24);
        //格式化日期
        SimpleDateFormat mt = new SimpleDateFormat("yyyy/MM/dd HH/mm/ss SSS");
        String millisTime = mt.format(MillisTime);
        //输出日期
        System.out.println(millisTime);

        //练习
        System.out.println("------------------------------------------------------");

        Date nowTime01 = new Date();//获取当前时间
        //创建格式化时间对象
        SimpleDateFormat Time = new SimpleDateFormat("yyyy-MM-dd HH/mm/ss SSS");
        //格式化nowTime01这个时间
        String NowTime = Time.format(nowTime01);
        System.out.println(NowTime);
        //System.currentTimeMillis 获取当前时间戳的毫秒数
        long nowTime02 = System.currentTimeMillis();
        System.out.println(nowTime02);
        Date nowTime03 = new Date(nowTime02);
        String nowTime04 = Time.format(nowTime03);
        System.out.println(nowTime04);
    }



    public static void print(){
        for (int i = 0; i < 100; i ++){
            System.out.println("i = " + i);
        }
    }
}
