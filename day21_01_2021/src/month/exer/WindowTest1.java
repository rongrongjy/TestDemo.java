package month.exer;

/**
 * @description：创建三个售票窗口，总票数：100张：使用实现runnable接口的方式实现
 * @auther lurongrong
 * @create 2021-01-25 17:12
 * 存在线程的安全问题，待解决
 */
class Window1 implements Runnable{
    private int ticket = 100;
    @Override
    public void run() {
        while (true){
            if (ticket > 0) {
                System.out.println(Thread.currentThread().getName() + "：卖票，票号" + ticket);
                ticket--;
            }else{
                break;
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
