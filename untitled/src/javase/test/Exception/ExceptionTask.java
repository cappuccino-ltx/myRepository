package javase.test.Exception;

import java.util.Scanner;
/**
 * �쳣��ҵ
 *
 *      Ҫ��
 *          ��д����ģ���û�ע�᣻
 *          1�������û������û��������룻
 *          2��������Ϣ�󣬺�̨java����ģ���û�ע��
 *          3��ע��ʱ�û���Ҫ���ڡ�6~14��֮�䲻����Ҫ�󶼱�ʾ�쳣��
 */


public class ExceptionTask {
    public static void main(String[] args){

        //��ȡ�û��˺ź�����
//        Scanner read = new Scanner(System.in);
//        System.out.print("�˺�:>");
//        String user = read.next();
//        System.out.print("����:>");
//        String password = read.next();


        //����UserService()��������ע�ᣡ
        try {
            UserService.register("zhangxiumei", "123456");
        } catch (CharacterLengthException e) {
            e.printStackTrace();
            //System.out.println(e.getMessage());
        }
    }
}
