package javase.test.Class.practice;

/**
 * ��дһ���������������ͬ���������
 * ���ŵ�һ��������
 *
 */

import java.util.Random;

public class RandomTest {
    public static void main(String[] args){
        //��������������ķ���
        int[] arr = formRandom(101, 5);
        for (int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
    }

    /**
     * ����һ������������ķ�����
     * @param boundary ָ������������ķ�Χ
     * @param number ָ������������ĸ���
     * @return ����һ����������������
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
