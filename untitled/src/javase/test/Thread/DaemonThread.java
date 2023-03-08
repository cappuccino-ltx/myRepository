package javase.test.Thread;

/**
 *
 * �ػ��̣߳���һ���߳�����Ϊ�ػ��̣߳���ô���û��̣߳����̣߳���ͨ�̣߳�������ʱ���ػ��߳̾ͻ��Զ�����
 * ���߳�����ǰ�����߳�Ϊ�ػ��߳�setDaemon(true);
 * t1.setDaemon(true);
 */
public class DaemonThread {
    public static void main(String[] args){
        Thread t1 = new Thread(new daemon());
        t1.setName("�ػ��߳�t1");
        t1.setDaemon(true);
        t1.start();
        for (int i = 1;i <= 10; i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("���߳�---->"+i);
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
