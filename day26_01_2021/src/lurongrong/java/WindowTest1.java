package lurongrong.java;

/**
 * @description：创建三个售票窗口，总票数：100张：使用实现runnable接口的方式实现
 * @auther lurongrong
 * @create 2021-01-25 17:12
 * 1.问题：卖票过程中，出现了重票，错票 -->出现了线程的安全问题
 * 2.问题出现的原因：当某个线程操作车票的过程中，尚未操作完成时，其他线程参与进来，
 *                  也操作车票
 * 3.如何解决：当一个线程a在操作ticket的时候，其他线程不能参与进来，直到线程a操作完ticket时，
 *              其他线程才可以开始操作ticket。这种情况即使线程a出现了阻塞，也不能被改变。
 *4.在java中我们通过同步机制，来解决线程的安全问题。
 *5.同步的方式，解决了线程的安全问题。----好处
 *              操作同步代码时，只能有一个线程参与，其他线程等待。
 *              相当于是一个单线程的过程，效率低。---
 *
 */
class Window1 implements Runnable{
    private int ticket = 100;

    Object obj = new Object();

    @Override
    public void run() {
        while (true){
            synchronized(obj) {
                if (ticket > 0) {

                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + "：卖票，票号" + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
        }
    }
}

public class WindowTest1 {
    public static void main(String[] args) {
        //只造了一个对象，故100张票分给三个窗口
        Window1 w1 = new Window1();


        Thread t1 = new Thread(w1);
        Thread t2 = new Thread(w1);
        Thread t3 = new Thread(w1);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }


}
