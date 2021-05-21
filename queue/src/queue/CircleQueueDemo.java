package queue;

import java.util.Scanner;

/**
 * @description：
 * @auther lurongrong
 * @create 2021-03-10 9:27
 */
public class CircleQueueDemo {
    public static void main(String[] args) {
        CircleQueue queue = new CircleQueue(4);
        char key = ' ';//接收用户输入
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        //输出一个菜单
        while (loop){
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出程序");
            System.out.println("a(add):添加数据到队列");
            System.out.println("g(get):从队列额取出数据");
            System.out.println("h(head):查看队列头的数据");
            key = scanner.next().charAt(0);
            switch (key){
                case 's' :
                    queue.showQueue();
                    break;
                case 'e' :
                    scanner.close();
                    loop = false;
                    break;
                case 'a' :
                    System.out.println("输出一个数");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g' :
                    try {
                        int res = queue.getQueue();
                        System.out.printf("取出的数据是%d\n",res);

                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;

                case 'h' :

                    try {
                        int res = queue.headQueue();
                        System.out.printf("对头的数据是%d\n",res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                default:
                    break;

            }

        }
        System.out.println("程序退出");
    }
}
//使用数组模拟队列-编写一个ArrayQueue类
class CircleQueue{
    private int maxSize;//表示数组的最大容量
    private int front;//队列头
    private int rear;//队列尾
    private int[] arr;//该数组用于存放数据，模拟队列

    //创建队列的构造器
    public CircleQueue(int arrMaxSize){
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = 0;//指向队列头部，分析出front是指向队列头位置
        rear = 0;//指向队列尾具体的最后一个数据的下一个
    }

    //判断队列是否已满
    public boolean isFull(){
        return (rear+1) % maxSize == front;
    }

    //判断队列是否为空
    public boolean isEmpty(){
        return front == rear;
    }

    //添加数据到队列
    public void addQueue(int data){
        //判断队列是否已满
        if (isFull()){
            System.out.println("队列已满");
            return;
        }
        arr[rear] = data;
        rear = (rear+1)%maxSize;
    }
    //获取队列的数据，出队列
    public int getQueue(){
        //判断队列是否为空
        if (isEmpty()){
            //通过抛出异常
            throw new RuntimeException("队列为空，无数据可取");
        }
        int value = arr[front];
        front = (front+1)%maxSize;
        return value;
    }

    //显示队列的所有数据
    public void showQueue(){
        //遍历
        if (isEmpty()){
            System.out.println("空");
            return;
        }
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d]=%d\n",i % maxSize,arr[i%maxSize]);
        }
    }
    //求出当前队列有效数据的个数
    public int size(){
        return (rear + maxSize - front) % maxSize;
    }
    //返回队列的第一个数据
    public int headQueue(){
        //判断是否为空
        if (isEmpty()){
            throw new RuntimeException("空");
        }
        return arr[front];
    }
}
