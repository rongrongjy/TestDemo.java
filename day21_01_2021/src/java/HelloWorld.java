package java;

import java.util.Arrays;
import java.util.List;

public class HelloWorld{
    public static void main(String[] args) {
        int[] intArray = new int[]{1, 2, 3};
        Integer[] integerArray = new Integer[]{1, 2, 3};

        List<int[] > intArrayList = Arrays.asList(intArray);
        List<Integer> integerList = Arrays.asList(integerArray);
        List<Integer> integerList2 = Arrays.asList(1, 2, 3);
        integerList2.add(6);
        integerList2.add(0,4);
        integerList2.remove(1);
        System.out.println("HelloWorld");
        System.out.println(integerList2);


    }


}




