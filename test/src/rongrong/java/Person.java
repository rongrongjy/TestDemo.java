package rongrong.java;

/**
 * @description��
 * @auther lurongrong
 * @create 2021-05-05 23:11
 */
public class Person {
    private String name;
    public int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person(int age) {
        this.age = age;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private Person(String name) {
        this.name = name;
    }

    public Person() {
        System.out.println("Person()");
    }
    public void show(){
        System.out.println("��ã�����һ���ˣ�");
    }
    private String showNation(String nation){
        System.out.println("�ҵĹ����ǣ�" + nation);
        return nation;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
