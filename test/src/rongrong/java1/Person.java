package rongrong.java1;

/**
 * @description：
 * @auther lurongrong
 * @create 2021-05-07 10:48
 */
@MyAnnotation(value = "hi")
public class Person extends Creature<String> implements Comparable<String>,MyInterface {
    private String name;
    int age;
    public int id;

    public Person() {
    }
    @MyAnnotation(value = "abc")
    public Person(String name) {
        this.name = name;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    @MyAnnotation
    private String show(String nation){
        System.out.println("我的国籍是：" + nation);
        return nation;
    }
    public String display(String interests,int age) throws NullPointerException,ClassCastException{
        return interests + age;
    }

    @Override
    public int compareTo(String o) {
        return 0;
    }



    @Override
    public void info() {

    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }
}
