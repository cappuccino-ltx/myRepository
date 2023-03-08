package javase.test.Thread;


/**
 *  模拟两个线程同时对一个账户进行取款操作，
 *
 *  如果，不对其进行线程同步的管控，就可能出现同时对账户余额进行操作，而导致账户信息的不安全
 *
 *  使用synchronized关键字对方法或者关键语句进行上锁（对象锁）,有人就是每个对象一把锁，同一个账户在同一时刻只能
 *  有一个线程对其进行操作
 *
 *  如果synchronized关键字使用在静态方法上（static），这种锁叫做类锁，也就是一个类在一个时刻，只能有一个线程
 *  对其进行操作，不同的对象也不行。
 *  synchronized关键字
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
        System.out.println(Thread.currentThread().getName()+"：账户"+act.getName()+"取款"+money+",余额："+act.getBalance());
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

    //取款方法
    public synchronized void withdraw(double money){
        //取款前的余额
        double before = this.balance;
        //取款后的余额
        double after = this.balance - money;

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //修改余额
        this.setBalance(after);
    }
}
