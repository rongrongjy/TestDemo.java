package lurongrong.java;

/**
 * @description：银行有一个账户。
 *              有两个储户分别向一个账户存3000元，每次存1000元，分三次存完，
 *              每次存完打印账户余额。
 * @auther lurongrong
 * @create 2021-01-27 11:13
 */
class ChuHu implements Runnable{
    private int balance = 3000;

    @Override
    public void run() {
        while (true){
            if (balance > 0) {
                System.out.println(balance);
                balance -= 1000;
            }else {
                break;
            }
        }
    }
}
public class AccountTest {
    public static void main(String[] args) {
        ChuHu c = new ChuHu();

        Thread t1 = new Thread();
        Thread t2 = new Thread();

        t1.start();
        t2.start();
    }
}
