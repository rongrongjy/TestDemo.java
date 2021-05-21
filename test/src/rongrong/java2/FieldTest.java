package rongrong.java2;

import org.junit.Test;
import rongrong.java1.Person;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * @description：获取当前运行时类的属性结构
 * @auther lurongrong
 * @create 2021-05-07 13:11
 */
public class FieldTest {
    @Test
    public void test1(){
        Class<Person> clazz = Person.class;
        //获取属性结构
        //getFields()获取去当前运行时类及父类中声明为public访问权限 的属性
        Field[] fields = clazz.getFields();
        for(Field f:fields){
            System.out.println(f);
        }
        System.out.println();
        //获取当前运行时类已经声明的所有的属性并不包含父类中声明的属性
        Field[] declaredFields = clazz.getDeclaredFields();
        for(Field f:declaredFields){
            System.out.println(f);
        }
    }
    @Test
    public void test2(){
        Class<Person> personClass = Person.class;
        Field[] declaredFields = personClass.getDeclaredFields();
        for(Field f:declaredFields){
            //权限修饰符
            int modifiers = f.getModifiers();
            System.out.print(Modifier.toString(modifiers) + "\t");
            //数据类型
            Class<?> type = f.getType();
            System.out.print(type + "\t");
            //变量名
            String name = f.getName();
            System.out.print(name + "\t");
            System.out.println();
        }


    }
}
