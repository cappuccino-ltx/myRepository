package javase.test.firstclass;

import java.util.Random;
import java.util.Scanner;

public class Test02 {
    public static void main(String[] args){
        System.out.print("请输入班级人数:>");
        Scanner scan = new Scanner(System.in);
        //获取班级人数
        int count = scan.nextInt();
        //创建班级成绩数组
        int[] clazz = new int[count];
        //不及格人数
        int fail = 0;
        //分数总计
        int tag = 0;
        //创建随机数对象
        Random random = new Random();
        for (int i = 0; i < count; i++){
            clazz[i] = random.nextInt(101);
            tag += clazz[i];
            if(clazz[i] < 60)
                fail++;
        }
        System.out.println("不及格人数：" + fail);
        System.out.println("班级平均分：" + (tag / count));
    }
}
