package javase.test.Class;



import java.text.DecimalFormat;
import java.math.BigDecimal;
import java.util.Random;

public class NumberClassTest06 {
    public static void main(String[] args){
        /**
         * ���ָ�ʽ���� DecimalFormat ����java.text���µ�һ���ࣻ
         * �������ָ�ʽ��
         *      # ��ʾ��������
         *      , ��ʾǧ��λ
         *      . ��ʾС����
         *      �����ڣ�##,###,###.### ��ʾ������λС��
         */
        DecimalFormat df = new DecimalFormat("###,###.0000");
        double n1 = 12345.671;
        long n2 = 12345;

        String num = df.format(n1);
        System.out.println(num);

        String num1 = df.format(n2);
        System.out.println(num1);

        /**
         * BigDecimal ���ڴ����� �����ȼ��ߣ������ڻ����������ͣ�����java����
         * ����ר�����ڲ���������е�һ�������������ͣ�
         *
         * �ڲ���������У�double��ʵ�ǲ����õģ�
         *
         * BigDecimal ��java.math.BigDecimal
         *
         */
        //����һ�����ȼ����100��200
        BigDecimal num2 = new BigDecimal(100);
        BigDecimal num3 = new BigDecimal(200);

        //�������:add
        BigDecimal num4 = num2.add(num3);
        System.out.println(num4);
        //�������:subtract
        BigDecimal num5 = num2.subtract(num3);
        System.out.println(num5);
        //������ˣ�multiply
        BigDecimal num6 = num2.multiply(num3);
        System.out.println(num6);
        //���������divide
        BigDecimal num7 = num2.divide(num3);
        System.out.println(num7);

        /**
         * �����������Random
         * java.util.random;
         */

        //�������������
        Random random = new Random();
        //����int��Χ�ڵ������
        int rnum1 = random.nextInt();
        System.out.println(rnum1);

        //����0~100֮��������
        int rnum2 = random.nextInt(101);//���101��һ���߽�ֵ���������101
        System.out.println(rnum2);

    }
}
