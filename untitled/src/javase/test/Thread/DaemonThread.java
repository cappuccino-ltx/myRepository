package javase.test.Thread;

/**
 *
 * 守护线程：讲一个线程设置为守护线程，那么在用户线程（主线程，普通线程）结束的时候，守护线程就会自动结束
 * 在线程启动前设置线程为守护线程setDaemon(true);
 * t1.setDaemon(true);
 */
public class DaemonThread {
    public static void main(String[] args){
        Thread t1 = new Thread(new daemon());
        t1.setName("守护线程t1");
        t1.setDaemon(true);
        t1.start();
        for (int i = 1;i <= 10; i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("主线程---->"+i);
        }
    }
}

class daemon implements Runnable{
    @Override
    public void run() {
        int i = 0;
        while(true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() +"---->"+ (++i));
        }
    }
}
