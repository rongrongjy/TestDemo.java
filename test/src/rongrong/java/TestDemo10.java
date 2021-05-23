package rongrong.java;

import java.util.Arrays;

/**
 * @description£ºÑ°ÕÒµÚK´óÊı
 * @auther lurongrong
 * @create 2021-05-22 15:13
 */
public class TestDemo10 {
    public static void main(String[] args) {
        int[] a = {1, 5, 1, 1, 4, 3};
        int n = a.length;
        int K = 4;
        int kth = findKth(a, n, K);
        System.out.println(Arrays.toString(a));
        System.out.println(kth);
    }

    public static int findKth(int[] a, int n, int K) {
        // write code here
//        heapSort(a, K);
////        System.out.println(i);
//        System.out.println(Arrays.toString(a));
//
//        return a[0];
        int temp = 0;
//        int count = 0;
//        int c = 0;
        for (int i = a.length / 2 - 1; i >= 0; --i) {
            adjustHeap(a, i, a.length);
//            System.out.println("$$$$$$$$$$$$4");
        }
        for (int i = a.length - 1; i > 0; --i) {
//            count++;
//            c++;
            temp = a[i];
            a[i] = a[0];
            a[0] = temp;
            adjustHeap(a, 0, i);
//            count++;
//            if (count == K) {
////                System.out.println(a[count]);
//                break;
//
//            }
            }
        return a[n - K];
    }


        public static void adjustHeap ( int[] a, int i, int length){
            int temp = a[i];
            for (int j = 2 * i + 1; j < length; j = 2 * j + 1) {
                if (j + 1 < length && a[j] < a[j + 1]) {
                    j++;
                }
                if (temp < a[j]) {
                    a[i] = a[j];
                    i = j;
                } else {
                    break;
                }
            }
            a[i] = temp;
        }

}
