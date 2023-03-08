package javase.test.Thread;


/**
 *
 * 写两个线程，交替输出数字，
 * t1输出奇数，t2输出偶数
 */
public class ThreadWork {
    public static void main(String[] args){
        Num n = new Num(1);
        Thread t1 = new Thread(new odd(n));
        Thread t2 = new Thread(new even(n));
        t1.setName("t1");
        t2.setName("t2");
        t1.start();
        t2.start();
    }
}
class Num{
    int i;

    public Num(int i) {
        this.i = i;
    }
}

class odd implements Runnable{
    Num n;
    //这个线程负责输出奇数

    public odd(Num n) {
        this.n = n;
    }

    @Override
    public void run() {
        while(true) {
            synchronized (n) {
                if (n.i % 2 == 0) {
                    try {
                        n.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + ":--->" + n.i++);
                n.notifyAll();
            }
        }
    }
}
class even implements Runnable{
    Num n;
    //这个方法负责输出偶数

    public even(Num n) {
        this.n = n;
    }

    @Override
    public void run() {
        while(true) {
            synchronized (n) {
                if (n.i % 2 != 0) {
                    try {
                        n.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + ":--->" + n.i++);
                n.notifyAll();
            }
        }
    }
}
