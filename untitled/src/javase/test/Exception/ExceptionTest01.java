package javase.test.Exception;

/**
 *  java ���쳣���������ʽ���ڵģ�ÿһ���쳣�඼���Դ�������
 *
 *      java���������쳣������ƣ�
 *          throws :�ڷ���������ʱ�������׳��쳣�����쳣�׸���һ����
 *          try ..catch���������׽�����쳣��
 */
public class ExceptionTest01 {
    public static void main(String[] args){
        try{
            System.out.println(100 / 0);
        }catch(Exception e){
            System.out.println(e);
        }
        System.out.println("Hello world!");
    }
/*
    private static int  m1() {
        return 100 / 0;
    }
*/
}
