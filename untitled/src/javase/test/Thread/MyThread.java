package javase.test.Thread;


/**
 *  ģ�������߳�ͬʱ��һ���˻�����ȡ�������
 *
 *  ���������������߳�ͬ���Ĺܿأ��Ϳ��ܳ���ͬʱ���˻������в������������˻���Ϣ�Ĳ���ȫ
 *
 *  ʹ��synchronized�ؼ��ֶԷ������߹ؼ���������������������,���˾���ÿ������һ������ͬһ���˻���ͬһʱ��ֻ��
 *  ��һ���̶߳�����в���
 *
 *  ���synchronized�ؼ���ʹ���ھ�̬�����ϣ�static��������������������Ҳ����һ������һ��ʱ�̣�ֻ����һ���߳�
 *  ������в�������ͬ�Ķ���Ҳ���С�
 *  synchronized�ؼ���
 */
public class MyThread {
    public static void main(String[] args){
        Account act = new Account("act_1",10000);

        AccountThread a = new AccountThread(act);

        Thread t1 = new Thread(a);
        Thread t2 = new Thread(a);
        t1.setName("t1");
        t2.setName("t2");

        t1.start();
        t2.start();
    }
}

class AccountThread implements Runnable{

    Account act;

    public AccountThread(Account act) {
        this.act = act;
    }

    @Override
    public void run() {
        double money = 5000;
        act.withdraw(money);
        System.out.println(Thread.currentThread().getName()+"���˻�"+act.getName()+"ȡ��"+money+",��"+act.getBalance());
    }
}

class Account{
    String name;
    double balance;

    public Account() {
    }

    public Account(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    //ȡ���
    public synchronized void withdraw(double money){
        //ȡ��ǰ�����
        double before = this.balance;
        //ȡ�������
        double after = this.balance - money;

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //�޸����
        this.setBalance(after);
    }
}
