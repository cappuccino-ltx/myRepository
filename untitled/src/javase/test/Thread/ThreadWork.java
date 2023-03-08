package javase.test.Thread;


/**
 *
 * д�����̣߳�����������֣�
 * t1���������t2���ż��
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
    //����̸߳����������

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
    //��������������ż��

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
