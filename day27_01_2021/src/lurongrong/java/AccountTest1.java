package lurongrong.java;

/**
 * @description：
 * @auther lurongrong
 * @create 2021-01-27 11:25
 */
class Account{
    private  double balance;
    private Object obj = new Object();
    public Account(double balance) {
        this.balance = balance;
    }
    //存钱
    public void deposit(double amt){
        if (amt > 0) {
            synchronized (obj) {
                balance += amt;

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName() + ":存钱成功，余额为：" + balance);
            }
        }
    }

}
class Customer extends Thread{
    private Account acc;

    public Customer(Account acc) {
        this.acc = acc;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            acc.deposit(1000);
        }
    }
}
public class AccountTest1 {
    public static void main(String[] args) {
        Account acct = new Account(0);
        Customer c1 = new Customer(acct);
        Customer c2 = new Customer(acct);

        c1.setName("甲");
        c2.setName("乙");

        c1.start();
        c2.start();
    }
}
