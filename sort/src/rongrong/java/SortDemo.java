package rongrong.java;

import org.junit.Test;

/**
 * @description：
 * @auther lurongrong
 * @create 2021-03-21 11:14
 */
public class SortDemo {
    public static void main(String[] args) {
        int[] arr = {1,3,5,2,8,4,9,1};
        sort(arr,arr.length);
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
}
