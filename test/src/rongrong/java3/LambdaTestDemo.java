package rongrong.java3;

import org.junit.Test;

/**
 * @description��
 * @auther lurongrong
 * @create 2021-05-20 21:31
 */
public class LambdaTestDemo {
    //�﷨��ʽһ���޲Σ��޷���ֵ
    @Test
    public void test1(){
        Runnable r = () -> System.out.println("111");
        r.run();
    }

}
