package rongrong.java2;

import org.junit.Test;
import rongrong.java1.Person;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * @description����ȡ��ǰ����ʱ������Խṹ
 * @auther lurongrong
 * @create 2021-05-07 13:11
 */
public class FieldTest {
    @Test
    public void test1(){
        Class<Person> clazz = Person.class;
        //��ȡ���Խṹ
        //getFields()��ȡȥ��ǰ����ʱ�༰����������Ϊpublic����Ȩ�� ������
        Field[] fields = clazz.getFields();
        for(Field f:fields){
            System.out.println(f);
        }
        System.out.println();
        //��ȡ��ǰ����ʱ���Ѿ����������е����Բ�����������������������
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
            //Ȩ�����η�
            int modifiers = f.getModifiers();
            System.out.print(Modifier.toString(modifiers) + "\t");
            //��������
            Class<?> type = f.getType();
            System.out.print(type + "\t");
            //������
            String name = f.getName();
            System.out.print(name + "\t");
            System.out.println();
        }


    }
}
