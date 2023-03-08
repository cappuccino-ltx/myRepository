package javase.test.Exception;

/**
 *  java 中异常是以类的形式存在的，每一个异常类都可以创建对象，
 *
 *      java中有两种异常处理机制：
 *          throws :在方法声明的时候向上抛出异常，把异常抛给上一级，
 *          try ..catch语句用来捕捉处理异常。
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
