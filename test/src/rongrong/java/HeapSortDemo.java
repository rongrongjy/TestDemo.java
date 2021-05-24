package rongrong.java;

import java.util.Arrays;

/**
 * @description£º¹¹½¨¶Ñ
 * @auther lurongrong
 * @create 2021-05-23 9:07
 */
public class HeapSortDemo {
    public static void main(String[] args) {
        //½¨¶Ñ
        Heap1 heap1 = new Heap1(10);
        heap1.add(12);
        System.out.println(heap1.toString());

    }
}
class Heap1{
    private int[] element;
    public Heap1(int MaxSize) {
        element = new int[MaxSize-1];
        element[0] = 0;
    }
    public boolean isEmpty(){
        return element[0] == 0;
    }
    public boolean isFull(){
        return element[0] == element.length-1;
    }
    public void add(int a){
        if (isFull()) return;
//        for (int i = 1; i < element[0]; i++) {
//            element[1] = a;
//        }

    }

    @Override
    public String toString() {
        return "Heap{" +
                "element=" + Arrays.toString(element) +
                '}';
    }
}
