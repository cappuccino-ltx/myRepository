package javase.test.Exception;

public class ExceptionTest02 {
    public static void main(String[] args){

        NullPointerException n = new NullPointerException("空指针异常");


        //getMessage()方法是用来获取异常构造方法上免得String参数的
        String str = n.getMessage();
        System.out.println(str);


        //printStackTrace()方法是用来打印异常堆栈信息的
        n.printStackTrace();
    }
}
