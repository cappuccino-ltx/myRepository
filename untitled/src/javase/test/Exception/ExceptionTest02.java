package javase.test.Exception;

public class ExceptionTest02 {
    public static void main(String[] args){

        NullPointerException n = new NullPointerException("��ָ���쳣");


        //getMessage()������������ȡ�쳣���췽�������String������
        String str = n.getMessage();
        System.out.println(str);


        //printStackTrace()������������ӡ�쳣��ջ��Ϣ��
        n.printStackTrace();
    }
}
