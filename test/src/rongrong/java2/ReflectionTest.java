package rongrong.java2;

import org.junit.Test;
import rongrong.java1.Person;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @description：
 * @auther lurongrong
 * @create 2021-05-07 13:12
 */
/*
如何操作运行时类中指定的属性
 */

public class ReflectionTest {
    @Test
    public void test() throws Exception {
        //获取运行时类
        Class<Person> personClass = Person.class;
        //创建运行时类的对象
        Person person = personClass.newInstance();
        //获取运行时类指定变量名的属性
        Field name = personClass.getDeclaredField("name");
        //保证获取到的属性是可访问的
        name.setAccessible(true);
        //获取，设置指定对象的属性值
        name.set(person,"Tom");
        System.out.println(name.get(person));
        Method declaredMethod = personClass.getDeclaredMethod("show", String.class);
        declaredMethod.setAccessible(true);
        Object invoke = declaredMethod.invoke(person,"CHINA");
        System.out.println(invoke);


    }
}

