package javase.test.Exception;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * try..catch 还有一个子语句finally
 *
 *      在finally子句中的代码是最后执行的，并且是一定会执行的，
 *      即使try语句中的代码出现了异常，一还是会执行，
 */
public class ExceptionTest03 {

    public static void main(String[] rgs){
        FileInputStream fi = null;
        try {
            fi = new FileInputStream("E:\\，李同学。\\linux\\Doc1(2).docx");
            //FIleInputStream()这个方法抛出了一个异常，需要处理
            fi.read();//对文件进行读取，捕捉IOException这个异常

            //但是FIleInputStream()是一个流，需要手动关闭，不然是非常浪费资源的
            //fi.close();
            //又因为如果在读取文件的时候出现了异常，这个时候程序就不不会执行到这里。那么流就没有关闭，这是非常危险的
            //就用到了finally语句
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            /*
            finally语句中的代码是一定会执行的，
            尽管在try 语句中出现了异常，导致存在没有被关闭的流，就可以在finally语句中去关闭
             */
            if (fi != null) {
                try {
                    fi.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
