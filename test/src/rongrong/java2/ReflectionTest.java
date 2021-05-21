package rongrong.java2;

import org.junit.Test;
import rongrong.java1.Person;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @description��
 * @auther lurongrong
 * @create 2021-05-07 13:12
 */
/*
��β�������ʱ����ָ��������
 */

public class ReflectionTest {
    @Test
    public void test() throws Exception {
        //��ȡ����ʱ��
        Class<Person> personClass = Person.class;
        //��������ʱ��Ķ���
        Person person = personClass.newInstance();
        //��ȡ����ʱ��ָ��������������
        Field name = personClass.getDeclaredField("name");
        //��֤��ȡ���������ǿɷ��ʵ�
        name.setAccessible(true);
        //��ȡ������ָ�����������ֵ
        name.set(person,"Tom");
        System.out.println(name.get(person));
        Method declaredMethod = personClass.getDeclaredMethod("show", String.class);
        declaredMethod.setAccessible(true);
        Object invoke = declaredMethod.invoke(person,"CHINA");
        System.out.println(invoke);


    }
}

