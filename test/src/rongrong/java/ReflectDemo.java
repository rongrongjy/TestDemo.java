package rongrong.java;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @description：
 * @auther lurongrong
 * @create 2021-05-05 23:11
 */
public class ReflectDemo {
    //反射之前，对于Person的操作
    @Test
    public void test1(){
        //1.创建Person类的对象
        Person p1 = new Person("Yum", 12);
        //2.通过对象，调用其内部的属性、方法
        p1.age = 10;
        System.out.println(p1.toString());

        p1.show();
        //在person类的外部，不可以通过person类的对象调用其内部私有结构
        //比如：name  showNation()以及私有的构造器
    }
    //反射之后，对于person的操作
    @Test
    public void test2() throws Exception {
        Class<?> forName = Class.forName("java.lang.ref.Reference");
        System.out.println(forName);
        Class clazz = Person.class;
        //1.通过反射，创建person类的对象
        Constructor constructor = clazz.getConstructor(String.class, int.class);
        Object o = constructor.newInstance("Tom", 12);
        Person p = (Person) o;
        System.out.println(p.toString());
        //通过反射，调用对象指定的属性，方法
        //调用属性
        Field age = clazz.getDeclaredField("age");
        age.set(p,1);
        System.out.println(p.toString());
        Field name = clazz.getDeclaredField("name");//name为私有属性
        name.setAccessible(true);
        name.set(p,"Jony");

//        name.set(p,"Jony");
//        Person p2 = (Person) constructor.newInstance("Jerry");
        System.out.println(p);
        //调用方法
        Method show = clazz.getDeclaredMethod("show");
        show.invoke(p);


    }
    /*
    关于Java.lang.Class的理解
    1.类的加载过程
    程序经过java.exe命令后，会生成一个或多个.class字节码文件，字节码文件再次经过java.exe
    编译运行。相当于将某个字节码文件加载到内存中，此过程就称为类的加载。加载到内存中的类就称为运行时类，次运行时类就可以作为
    Class的一个实例。

    2.换句话说，Class的实例就对应着一个运行时类

    3.加载到内存中的运行时类会缓存一定的时间。在此之前，我们可以通过不同的方式
    来获取次运行时类。
     */
    //获取Class运行时类的方式
    @Test
    public void test3(){
        //一：通过运行时类的属性：.class
        Class<Person> personClass = Person.class;
        System.out.println(personClass+"***********");
        System.out.println("@@@@@@@@22");
        //二：通过运行时类的对象，调用getClass()
        Person person = new Person();
        Class<? extends Person> aClass = person.getClass();
        System.out.println(aClass+"$$$$$$$$$$$4");

        //三：调用Class的静态方法：forName(String classPath)
        try {
            Class<?> aClass1 = Class.forName("lurongrong.Person");
            System.out.println(aClass1+"&&&&&&&&&&&&");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //四：使用类的加载器：ClassLoader
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
