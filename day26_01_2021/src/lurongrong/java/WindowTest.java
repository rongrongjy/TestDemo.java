package lurongrong.java;

/**
 *
 * @description：创建三个售票窗口，总票数：100张：使用继承thread类的方式实现
 * @auther lurongrong
 * @create 2021-01-25 10:29
 * 存在线程安全问题，未解决
 */
class Window extends Thread{
    private static int ticket = 100;//总票数  没加static之前该属性为实例变量
    private static Object obj = new Object();
    @Override
    public void run() {
        while (true) {
            //正确的
            //synchronized (obj){//此时的this：唯一的window的对象//方式二synchronized (obj)
            synchronized (Window.class){//Class class = Window.class,Window.class只会加载一次
                //错误的方式：this代表着window1，window2，window3三个对象
                //synchronized (this){
                if (ticket > 0) {

                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(getName() + ":卖票，票号为" + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
        }
    }
}

public class WindowTest {
    public static void main(String[] args) {
        Window window1 = new Window();
        Window window2 = new Window();
        Window window3 = new Window();

        window1.setName("窗口1");
        window2.setName("窗口2");
        window3.setName("窗口3");

        window1.start();
        window2.start();
        window3.start();


    }
}
