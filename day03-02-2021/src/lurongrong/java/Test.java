package lurongrong.java;

import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * ArrayList
 * @description：
 * @auther lurongrong
 * @create 2021-02-04 9:12
 */
public class Test {
    @org.junit.Test
    public void test1() {
        Person[] p = new Person[4];//{new Person("Lisa",19),new Person("Tom",15),new Person("Jony",21)};
        p[0] = new Person("Tom",15);
        p[1] = new Person("Jony",21);
        p[2] = new Person("Lisa",16);
        p[3] = new Person("Mike",23);

        Arrays.sort(p, new Comparator() {

            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Person && o2 instanceof Person) {
                    Person s1 = (Person) o1;
                    Person s2 = (Person) o2;
                    return s1.getName().compareTo(s2.getName());
//                    if (s1.getName().equals(s2.getName())) {
//                        return Double.compare(s1.getAge(),s2.getAge());
//                    }else {
//                        return s1.getName().compareTo(s2.getName());
//                    }
                }
//                return 0;
                throw new RuntimeException("输入的数据类型不一致");
            }
        });
        System.out.println(Arrays.toString(p));

    }
}
