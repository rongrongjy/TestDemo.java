package lurongrong.java;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @description：
 * @auther lurongrong
 * @create 2021-02-03 9:35
 */
public class Person {
    private String name;
    private double age;


    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

//    @Test
//    public void test(){
//        String[] arr = new String[]{"sas","frrrrd","dsd"};
//        Arrays.sort(arr, new Comparator() {
//
//            @Override
//            public int compare(Object o1, Object o2) {
//                if (o1 instanceof String && o2 instanceof String) {
//                    String s1 = (String) o1;
//                    String s2 = (String) o2;
//                    return s1.compareTo(s2);
//                }
////                return 0;
//                throw new RuntimeException("输入的数据类型不一致");
//            }
//        });
//        System.out.println(Arrays.toString(arr));
//
//    }




}