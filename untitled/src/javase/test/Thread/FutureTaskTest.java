package javase.test.Thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 *
 * java���ܹ�������ʵ���̵߳ķ�����
 *      ��һ�֣���дһ����̳�Thread�࣬
 *          class MyThread extents Thread{}
 *      �ڶ��֣���дһ����ʵ��Runnable�ӿڣ�
 *          class MyThread implements Runnable{}
 *
 *      �����֣�ʵ��callable�ӿ�
 *          ����ʵ���̵߳ķ��������Ի�ȡ�߳�ִ�еĽ����
 *          ��������ʵ�ַ�ʽ��Ч�ʱȽϵͣ�
 *              ��Ϊget������Ҫ�ȴ�����ȡ�߳�ִ����ɣ��ᵼ�µ���get�������̶߳�����
 */
public class FutureTaskTest {
    public static void main(String[] args){
        FutureTask task = new FutureTask(new Callable(){

            //���call�������൱��run����
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

        //��ô�����߳��л�ȡt1�̵߳ķ���ֵ�أ�
        try {
            Object obj = task.get();
            System.out.println(obj);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("Hello��");
    }
}
