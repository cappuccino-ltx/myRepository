package javase.test.Exception;

import java.util.Scanner;
/**
 * 异常作业
 *
 *      要求：
 *          编写程序模拟用户注册；
 *          1、提醒用户输入用户名和密码；
 *          2、输入信息后，后台java程序模拟用户注册
 *          3、注册时用户名要求在【6~14】之间不符合要求都表示异常。
 */


public class ExceptionTask {
    public static void main(String[] args){

        //获取用户账号和密码
//        Scanner read = new Scanner(System.in);
//        System.out.print("账号:>");
//        String user = read.next();
//        System.out.print("密码:>");
//        String password = read.next();


        //调用UserService()方法进行注册！
        try {
            UserService.register("zhangxiumei", "123456");
        } catch (CharacterLengthException e) {
            e.printStackTrace();
            //System.out.println(e.getMessage());
        }
    }
}
