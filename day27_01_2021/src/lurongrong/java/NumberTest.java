package lurongrong.java;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @description：使用两个线程打印1-100.线程1，线程2交替打印。
 * @auther lurongrong
 * @create 2021-01-27 20:30
 */
class Number implements Runnable{
    private int number = 1;
    private  ReentrantLock lock = new ReentrantLock();
    @Override

    public   void run() {
        while (true) {

            synchronized (this) {
                notify();
                if (number <= 100) {
                    System.out.println(Thread.currentThread().getName() + number);
                    number++;

                    try {
                        //使得调用如下wait（）方法的线程进入阻塞状态
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }else{
                    break;
                }
            }

        }

    }

}
public class NumberTest {
    public static void main(String[] args) {
        Number n1 = new Number();


        Thread t1 = new Thread(n1);
        Thread t2 = new Thread(n1);

        t1.setName("线程1:");
        t2.setName("线程2:");

        t1.start();
        t2.start();
    }
}
