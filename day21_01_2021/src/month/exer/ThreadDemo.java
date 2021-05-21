package month.exer;

/**
 * @description：
 * @auther lurongrong
 * @create 2021-01-24 11:12
 */
class MyThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}
class MyThread1 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 1) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}
public class ThreadDemo {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        MyThread1 myThread1 = new MyThread1();
        myThread.start();
        myThread1.start();
    }
}
