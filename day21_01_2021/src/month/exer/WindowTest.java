package month.exer;

/**
 *
 * @description：创建三个售票窗口，总票数：100张：使用继承thread类的方式实现
 * @auther lurongrong
 * @create 2021-01-25 10:29
 * 存在线程安全问题，未解决
 */
class Window extends Thread{
    private static int ticket = 100;//总票数  没加static之前该属性为实例变量
    @Override
    public void run() {
        while (true){
            if (ticket > 0) {
                System.out.println(getName() + ":卖票，票号为" + ticket );
                ticket--;
            }else{
                break;
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
