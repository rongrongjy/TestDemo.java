package lurongrong.java;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
   @description：实现Callable接口
   @auther lurongrong
   @create 2021-01-28 11:22
*/
//1.创建一个实现Callable的实现类
class NumThread implements Callable {
    //2.实现call方法，将此线程需要执行的操作声明
    @Override
    public Object call() throws Exception {
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
                sum += i;
            }
        }
        return sum;
    }


}
public class ThreadNew {
    public static void main(String[] args) {
        //3.创建callable接口实现类的对象
        NumThread n1 = new NumThread();

        //4.将此callable接口实现类的对象作为传递到futureTask构造器中，
        //创建FutureTask的对象
        FutureTask futureTask = new FutureTask(n1);

        //5.将FutureTask的对象作为参数传递到Thread类的构造器中，创建Thread对象，并调用start（）
         new Thread(futureTask).start();

        //6.获取callable中call方法的返回值

        try {
            //get()返回值即为FutureTask构造器参数callable实现类重写call()的返回值

            Object sum = futureTask.get();
            System.out.println(sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }
}
