package lurongrong.java;

/**
 * @description：生产者消费者问题
 * @auther lurongrong
 * @create 2021-01-27 21:16
 */
class Productor extends Thread{//生产者
    private Clerk clerk = new Clerk();

    public Productor(Clerk clerk) {
        this.clerk = clerk;
    }
    
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ":开始生产产品.....");
        while (true) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.produce();
        }
    }
}
class Customer1 extends Thread{//消费者
    private Clerk clerk = new Clerk();

    public Customer1(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(getName() + "");
        System.out.println(Thread.currentThread().getName() + ":开始消费产品.....");
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.consumeproduce();
        }
    }
}

class Clerk{
    private int product = 0;
    //生产产品
    public synchronized void produce() {
        if (product < 20) {
            product++;
            System.out.println(Thread.currentThread().getName() + "：开始生产第" + product + "个产品");
            notify();
        }else {
            //等待
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
    //消费产品
    public synchronized void consumeproduce() {
        if (product > 0) {
            System.out.println(Thread.currentThread().getName() + "：开始消费第" + product + "个产品");
            product--;
            notify();
        }else {
            //等待
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
public class ClerkTest {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();

        Productor p1 = new Productor(clerk);
        p1.setName("生产者");

        Customer1 c1 = new Customer1(clerk);
        c1.setName("消费者");

        p1.start();
        c1.start();
    }
}


