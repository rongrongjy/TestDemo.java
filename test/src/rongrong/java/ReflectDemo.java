package rongrong.java;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @description��
 * @auther lurongrong
 * @create 2021-05-05 23:11
 */
public class ReflectDemo {
    //����֮ǰ������Person�Ĳ���
    @Test
    public void test1(){
        //1.����Person��Ķ���
        Person p1 = new Person("Yum", 12);
        //2.ͨ�����󣬵������ڲ������ԡ�����
        p1.age = 10;
        System.out.println(p1.toString());

        p1.show();
        //��person����ⲿ��������ͨ��person��Ķ���������ڲ�˽�нṹ
        //���磺name  showNation()�Լ�˽�еĹ�����
    }
    //����֮�󣬶���person�Ĳ���
    @Test
    public void test2() throws Exception {
        Class<?> forName = Class.forName("java.lang.ref.Reference");
        System.out.println(forName);
        Class clazz = Person.class;
        //1.ͨ�����䣬����person��Ķ���
        Constructor constructor = clazz.getConstructor(String.class, int.class);
        Object o = constructor.newInstance("Tom", 12);
        Person p = (Person) o;
        System.out.println(p.toString());
        //ͨ�����䣬���ö���ָ�������ԣ�����
        //��������
        Field age = clazz.getDeclaredField("age");
        age.set(p,1);
        System.out.println(p.toString());
        Field name = clazz.getDeclaredField("name");//nameΪ˽������
        name.setAccessible(true);
        name.set(p,"Jony");

//        name.set(p,"Jony");
//        Person p2 = (Person) constructor.newInstance("Jerry");
        System.out.println(p);
        //���÷���
        Method show = clazz.getDeclaredMethod("show");
        show.invoke(p);


    }
    /*
    ����Java.lang.Class�����
    1.��ļ��ع���
    ���򾭹�java.exe����󣬻�����һ������.class�ֽ����ļ����ֽ����ļ��ٴξ���java.exe
    �������С��൱�ڽ�ĳ���ֽ����ļ����ص��ڴ��У��˹��̾ͳ�Ϊ��ļ��ء����ص��ڴ��е���ͳ�Ϊ����ʱ�࣬������ʱ��Ϳ�����Ϊ
    Class��һ��ʵ����

    2.���仰˵��Class��ʵ���Ͷ�Ӧ��һ������ʱ��

    3.���ص��ڴ��е�����ʱ��Ỻ��һ����ʱ�䡣�ڴ�֮ǰ�����ǿ���ͨ����ͬ�ķ�ʽ
    ����ȡ������ʱ�ࡣ
     */
    //��ȡClass����ʱ��ķ�ʽ
    @Test
    public void test3(){
        //һ��ͨ������ʱ������ԣ�.class
        Class<Person> personClass = Person.class;
        System.out.println(personClass+"***********");
        System.out.println("@@@@@@@@22");
        //����ͨ������ʱ��Ķ��󣬵���getClass()
        Person person = new Person();
        Class<? extends Person> aClass = person.getClass();
        System.out.println(aClass+"$$$$$$$$$$$4");

        //��������Class�ľ�̬������forName(String classPath)
        try {
            Class<?> aClass1 = Class.forName("lurongrong.Person");
            System.out.println(aClass1+"&&&&&&&&&&&&");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //�ģ�ʹ����ļ�������ClassLoader
        ClassLoader classLoader = ReflectDemo.class.getClassLoader();
        Class<?> aClass1 = null;
        try {
            aClass1 = classLoader.loadClass("lurongrong.Person");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(aClass1);

    }
    @Test
    public void test4(){
        Class<Person> personClass = Person.class;
        Person person = new Person();
        Class<? extends Person> aClass = person.getClass();
        try {
            Class<?> aClass1 = Class.forName("lurongrong.Person");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        ClassLoader classLoader = ReflectDemo.class.getClassLoader();
        try {
            Class<?> aClass2 = classLoader.loadClass("lurongrong.Person");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
