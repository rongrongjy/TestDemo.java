package rongrong.java3;

import org.junit.Test;

/**
 * @description：
 * @auther lurongrong
 * @create 2021-05-20 21:31
 */
public class LambdaTestDemo {
    //语法格式一：无参，无返回值
    @Test
    public void test1(){
        Runnable r = () -> System.out.println("111");
        r.run();
    }

}
