package javase.test.firstclass;

import java.util.Random;
import java.util.Scanner;

public class Test02 {
    public static void main(String[] args){
        System.out.print("������༶����:>");
        Scanner scan = new Scanner(System.in);
        //��ȡ�༶����
        int count = scan.nextInt();
        //�����༶�ɼ�����
        int[] clazz = new int[count];
        //����������
        int fail = 0;
        //�����ܼ�
        int tag = 0;
        //�������������
        Random random = new Random();
        for (int i = 0; i < count; i++){
            clazz[i] = random.nextInt(101);
            tag += clazz[i];
            if(clazz[i] < 60)
                fail++;
        }
        System.out.println("������������" + fail);
        System.out.println("�༶ƽ���֣�" + (tag / count));
    }
}
