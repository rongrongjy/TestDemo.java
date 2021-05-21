package rongrong.java2;

import org.junit.Test;
import rongrong.java1.Person;

import java.lang.reflect.Method;

/**
 * @description：获取运行时类的方法结构
 * @auther lurongrong
 * @create 2021-05-07 13:11
 */
public class MethodTest {
    @Test
    public void test1(){
        Class<Person> personClass = Person.class;
        Method[] declaredMethods = personClass.getDeclaredMethods();
        for(Method m:declaredMethods){
            //抛出的异常
            Class<?>[] exceptionTypes = m.getExceptionTypes();
            if (exceptionTypes.length > 0) {
                System.out.print("throws");
                for (int i = 0; i < exceptionTypes.length; i++) {
                    if (i == exceptionTypes.length - 1){
                        System.out.print(exceptionTypes[i].getName());
                        break;
                    }
                    System.out.print(exceptionTypes[i].getName() + ",");
                }
            }
        }
    }
}
