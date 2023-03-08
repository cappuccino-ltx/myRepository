package javase.test.Class;

/**
 * java�����ṩ��������Date�����Ի�ȡ��ϵͳ��ʱ�䣬
 */

import java.text.SimpleDateFormat;
import java.util.Date;

public class DataClassTest05 {
    public static void main(String[] args)throws Exception {
        //��ȡϵͳ��ǰʱ�䣬��ȷ������
        Date nowTime = new Date();
        System.out.println(nowTime);

        //���ڸ�ʽ����SimpleDateFormat  ��java.text����
        //���þ���������ʽ�����ڣ���������ָ������ʽȥ��������巽��ʹ��format()���ʵ��������
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy��MM��dd�� HHʱmm��ss�� SSS");
        String time = sdf.format(nowTime);
        System.out.println(time);

        //��һ���������͵��ַ�������ôת����Date���͵����ݣ�
        String dateStr = "2000/11/01 13:24:53";
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date TimeStr = sdf2.parse(dateStr);
        System.out.println(TimeStr);

        /**
         * ��ȡ��1970��1��1�� 00ʱ00��00�� 000���뿪ʼ������ǰʱ�̵ĺ�������
         */
        //System���µ�һ����̬�����������ܺ�����������long�������ݣ�
        long newTimeMillis = System.currentTimeMillis();
        System.out.println(newTimeMillis);

        //���ǿ��������������ȥ����һ������ִ�����ķѵ�ʱ��

        //��ִ�з���ǰȥһ����������
        long begin = System.currentTimeMillis();
        print();
        //ִ�з������һ����������
        long end = System.currentTimeMillis();
        long methodUseTime = end - begin;
        System.out.println(methodUseTime);


        /*
        ���⣬Date�໹��һ�����췽����Date(long Date)
        ������һ��������������˼�ǹ���һ����1970��1��1��00ʱ00��00��000���뿪ʼ����Date���������
         */

        //����һ���������ڵ�����
        Date MillisTime = new Date(System.currentTimeMillis() - 1000*60*60*24);
        //��ʽ������
        SimpleDateFormat mt = new SimpleDateFormat("yyyy/MM/dd HH/mm/ss SSS");
        String millisTime = mt.format(MillisTime);
        //�������
        System.out.println(millisTime);

        //��ϰ
        System.out.println("------------------------------------------------------");

        Date nowTime01 = new Date();//��ȡ��ǰʱ��
        //������ʽ��ʱ�����
        SimpleDateFormat Time = new SimpleDateFormat("yyyy-MM-dd HH/mm/ss SSS");
        //��ʽ��nowTime01���ʱ��
        String NowTime = Time.format(nowTime01);
        System.out.println(NowTime);
        //System.currentTimeMillis ��ȡ��ǰʱ����ĺ�����
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
