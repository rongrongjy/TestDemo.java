package rongrong.java;

import org.junit.Test;

/**
 * @description：假设有一个矩阵，使矩阵的每一列每一行从小到大排列
 * 4 2 6
 * 1 9 3
 * 8 2 5
 * @auther lurongrong
 * @create 2021-03-21 11:14
 */
public class SortDemo {
    public static void main(String[] args) {
//        int[] arr = {1,3,5,2,8,4,9,1};
////        sort(arr,arr.length);
//        selectSort1(arr, arr.length);
//        System.out.println(Arrays.toString(arr));

        int[][] a = {{4,2,6},{1,9,3},{8,2,5}};
        for (int i = 0; i < a.length; i++) {
//            for (int j = 0; j < a[0].length; j++) {
                selectSort1(a[i],a[i].length );
//            }
        }
        revertMatrix(a);

//        int[][] a = {{4,2,6},{1,9,3},{8,2,5}};
        for (int i = 0; i < a.length; i++) {
//            for (int j = 0; j < a[0].length; j++) {
            selectSort1(a[i],a[i].length );
//            }
        }
        revertMatrix(a);
//        for (int i = 0; i < a.length; i++) {
//            for (int j = 0; j < a[0].length; j++) {
//                selectSort1(a[][j], );
//            }
//        }

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }

    }
    public static void revertMatrix(int[][] a){
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j < a[i].length ; j++) {
                if (i != j){
                    int temp = a[i][j];
                    a[i][j] = a[j][i];
                    a[j][i] = temp;
                }
            }
        }
    }

    @Test
    public static void sort(int[] arr,int n){
        if (n <= 0){
            return;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {

            }
        }
        int temp = arr[0];
        for (int i = 0; i < n; i++) {
            if (temp > arr[i]){
                int cur = temp;
                temp = arr[i];
                arr[i] =cur;
            }else {
                temp = arr[i];
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    public static void selectSort(int[] a,int n){
        if (a == null || a.length == 0 || n < 0) return;
        for (int i = 0; i < n; i++) {
            int minIndex = i;
            int maxIndex = n-i-1;
            for (int j = i+1; j < n; j++) {
                if (a[j] < a[minIndex]){
                    minIndex = j;
                }

            }
            if (minIndex != i){
                int temp  = a[minIndex];
                a[minIndex] = a[i];
                a[i] = temp;
            }

        }
    }
    public static void selectSort1(int[] a,int n){
        if (a == null || n < 0 || a.length == 0) return;
        for (int i = 0; i < n; i++) {
            int index = i;
            for (int j = i+1; j < n; j++) {
                if (a[index] > a[j]){
                    index = j;
                }
            }
            if (index != i){
                int temp = a[i];
                a[i] = a[index];
                a[index] = temp;
            }
        }
    }
}
