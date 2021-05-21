package lurongrong.java;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @description：创建线程的方式四：使用线程池
 * @auther lurongrong
 * @create 2021-01-28 21:22
 */
class NumberThread implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName()  + ":" + i);
            }
        }

    }
}
class NumberThread1 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 != 0) {
                System.out.println(Thread.currentThread().getName() + ":"  + i);
            }
        }

    }
}
public class ThreadPool {
    public static void main(String[] args) {

        ExecutorService service = Executors.newFixedThreadPool(10);
        ThreadPoolExecutor service1 = (ThreadPoolExecutor) service;

        //设置线程池的属性
        System.out.println(service.getClass());
        service1.setCorePoolSize(10);

        service.execute(new NumberThread());//适合适用于Runnable
        service.execute(new NumberThread1());
//        service.submit();//适合适用于Callable
        //关闭连接池
        service.shutdown();
    }
}
