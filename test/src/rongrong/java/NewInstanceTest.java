package rongrong.java;

import org.junit.Test;

import java.util.Random;

/**
 * @description��ͨ�����䴴����Ӧ������ʱ��Ķ���
 * @auther lurongrong
 * @create 2021-05-06 22:34
 */
public class NewInstanceTest {
    @Test
    public void test1(){
        Class<Person> personClass = Person.class;
        /*
        newInstance():���ô˷�����������Ӧ������ʱ��Ķ����ڲ�������
        ����ʱ��ĿղεĹ�����

        Ҫ��˷��������Ĵ�������ʱ��Ķ���Ҫ��
        1.����ʱ������ṩ�ղεĹ�����
         */
        try {
            Person person = personClass.newInstance();
            System.out.println(person);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
    //��ᷴ��Ķ�̬��
    @Test
    public void test(){
        for (int i = 0; i < 100; i++) {
            int num = new Random().nextInt(3);
            String classPath = "";
            switch (num){
                case 0:
                    classPath = "java.util.Date";
                    break;
                case 1:
                    classPath = "java.lang.Object";
                    break;
                case 2:
                    classPath = "rongrong.java.Person";
                    break;
            }
            try {
                Object instance = getInstance(classPath);
                System.out.println(instance);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    /*
    ����һ��ָ����Ķ���
    classPath��ָ�����ȫ����
     */
    public Object getInstance(String classPath) throws Exception {
        Class aClass = Class.forName(classPath);
        return aClass.newInstance();

    }
    @Test
    public void test4(){
        int[] a = {4,2,3};
        boolean b = checkPossibility(a);
        System.out.println(b);
    }
    public static boolean checkPossibility(int[] nums) {
        int n = nums.length, cnt = 0;
        for (int i = 0; i < n - 1; ++i) {
            int x = nums[i], y = nums[i + 1];
            if (x > y) {
                cnt++;
                if (cnt > 1) {
                    return false;
                }
                if (i > 0 &&
                        y < nums[i - 1]) {
                    nums[i + 1] = x;
                }
            }
        }
        return true;
    }

}
