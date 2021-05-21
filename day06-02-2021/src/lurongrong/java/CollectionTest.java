package lurongrong.java;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @description：
 * @auther lurongrong
 * @create 2021-02-06 10:20
 */
public class CollectionTest {
    @Test
    public void test1(){
        Collection coll = new ArrayList();

        coll.add(123);
        coll.add(456);
        coll.add("abc");
        SimpleDateFormat sdf = new SimpleDateFormat();
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd-hh-mm");
        Date date = new Date();
        String format = sdf.format(date);
        String format1 = sdf1.format(date);
        coll.add(format);
        coll.add(format1);


        System.out.println(coll.size());
        Object[] array = coll.toArray();
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);

        }
        System.out.println(coll);
        System.out.println(coll.isEmpty());
//        coll.clear();
//        System.out.println(coll.isEmpty());
        System.out.println(coll.contains(123));
        Collection coll1 = new ArrayList();
        coll1.add(789);
        coll1.add(456);
        coll.addAll(coll1);
        System.out.println(coll);
        System.out.println(coll.containsAll(coll1));
        System.out.println(coll.remove(123));
        System.out.println(coll);
        System.out.println(coll.removeAll(coll1));
        System.out.println(coll);
        System.out.println(coll.retainAll(coll1));
        System.out.println(coll);
        System.out.println(coll.hashCode());
        System.out.println(coll.equals(123));
        List list = Arrays.asList(new String[]{"a", "b", "c"});
        System.out.println(list);
        System.out.println("$$$$$$$$$$$$$");

        //迭代器的使用
        Collection coll2 = new ArrayList();
        coll2.add(123);
        coll2.add(456);
        coll2.add("789");
        coll2.add("Tom");



        Iterator iterator = coll2.iterator();
        while (iterator.hasNext()){
//            iterator.remove();
            Object obj = iterator.next();
            if ("Tom".equals(obj)) {
                iterator.remove();
            }
//            System.out.println(iterator.next());
        }
        Iterator iterator1 = coll2.iterator();
        while (iterator1.hasNext()){
            System.out.println(iterator1.next());
        }
        for (Object obj:coll2) {
            System.out.println(obj);
        }
    }
    @Test
    public void test2(){
        ArrayList arrayList = new ArrayList(123);
        arrayList.add(123);
        arrayList.add(0,12);
        System.out.println(arrayList.size());
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("***************");
        System.out.println(arrayList);
    }
}
