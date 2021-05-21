package month.exer;

/**
 * @description：Runnable
 * @auther lurongrong
 * @create 2021-01-25 16:57
 */
class Mthread implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 100;i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }


    }
}
public class MthreadTest {
    public static void main(String[] args) {
        Mthread mthread = new Mthread();
        Thread t1 = new Thread(mthread);
        t1.setName("线程1");
        t1.start();
    }

}
