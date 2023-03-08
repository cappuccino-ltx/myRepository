package javase.test.Thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 *
 * java中总共有三种实现线程的方法，
 *      第一种：编写一个类继承Thread类，
 *          class MyThread extents Thread{}
 *      第二种：编写一个类实现Runnable接口：
 *          class MyThread implements Runnable{}
 *
 *      第三种：实现callable接口
 *          这种实现线程的方法，可以获取线程执行的结果，
 *          但是这种实现方式，效率比较低：
 *              因为get方法需要等待被获取线程执行完成，会导致调用get方法的线程堵塞。
 */
public class FutureTaskTest {
    public static void main(String[] args){
        FutureTask task = new FutureTask(new Callable(){

            //这个call方法就相当于run方法
            @Override
            public Object call() throws Exception {

                System.out.println("call method begin!");
                Thread.sleep(1000 * 5);
                System.out.println("call method end!");
                return 100 +200;
            }
        });

        Thread t1 = new Thread(task);
        t1.start();

        //怎么在主线程中获取t1线程的返回值呢：
        try {
            Object obj = task.get();
            System.out.println(obj);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("Hello！");
    }
}
