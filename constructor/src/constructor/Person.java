package constructor;

/**
 * @description：构造器的理解与使用
 * @auther lurongrong
 * @create 2021-03-05 15:48
 */
public class Person {
    //属性
    private int age;
    private String name;
    private String sex;

    /**
     * 构造器的修饰符一般与类的修饰符一致
     * 没有自定义构造器时，系统默认生成无参构造器
     * 构造器没有返回值
     * 构造器的形参可以有0个或多个
     * 构造器是用来初始化对象的
     *
     */
    //无参构造器
    public Person() {
    }

    //带有一个形参的构造器
    public Person(int age) {
        this.age = age;
        System.out.println("带有一个形参的构造器");
    }

    //带有部分形参的构造器
    public Person(String name, String sex) {
        this.name = name;
        this.sex = sex;
        System.out.println("带有部分形参的构造器");
    }
    //带有全部形参的构造器
    public Person(int age, String name, String sex) {
        this.age = age;
        this.name = name;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Person person = new Person("Tom", "男");
        person.age = 15;
        System.out.println(person.toString());
    }
}
class Student extends Person{
    private int id;//学号

    /**
     * 子类同过使用super(形参列表)的方式调用父类中已经声明的构造函数
     * 并且super(形参列表)必须声明的子类构造器的首行
     * 若子类的构造器中没有super(形参列表)，则系统默认使用super()
     * @param age:年龄
     * @param name:姓名
     * @param sex:性别
     * @param id:学号
     */
    public Student(int age,String name,String sex,int id) {
        super(age,name,sex);
        this.id = id;
    }
}
