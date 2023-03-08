package javase.test.Class.practice;

/**
 * 编写一个程序，生成五个不同的随机数，
 * 最后放到一个数组里
 *
 */

import java.util.Random;

public class RandomTest {
    public static void main(String[] args){
        //调用生成随机数的方法
        int[] arr = formRandom(101, 5);
        for (int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
    }

    /**
     * 这是一个生成随机数的方法，
     * @param boundary 指定生成随机数的范围
     * @param number 指定生成随机数的个数
     * @return 返回一个存放随机数的数组
     */
    public static int[] formRandom(int boundary, int number){
        int[] arr = new int[number];
        Random random = new Random();
        a:for (int i = 0; i < number; i++){
            int num = random.nextInt(boundary);
            for (int j = 0; j < i; j++){
                if (num == arr[j]) continue a;
            }
            arr[i] = num;
        }
        return arr;
    }
}
