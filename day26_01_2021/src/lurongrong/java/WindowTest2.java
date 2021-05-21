package lurongrong.java;

/**
 * @description：使用同步方法解决实现Runnable接口的线程安全问题
 * @auther lurongrong
 * @create 2021-01-26 21:11
 */
class Window2 implements Runnable{
    private int ticket = 100;
    @Override
    public void run() {
        while (true){
            show();

        }
    }

    public synchronized void show(){//同步监视器：this
        if (ticket > 0) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "：卖票，票号" + ticket);
            ticket--;
        }
    }
}
public class WindowTest2 {
    public static void main(String[] args) {
        //只造了一个对象，故100张票分给三个窗口
        Window2 w2 = new Window2();


        Thread t1 = new Thread(w2);
        Thread t2 = new Thread(w2);
        Thread t3 = new Thread(w2);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }


}

