package rongrong.java;

import java.util.Arrays;

/**
 * @description：
 * @auther lurongrong
 * @create 2021-04-01 20:19
 */
public class FibonacciSearch {
    public static int maxSize = 10;
    public static void main(String[] args) {
        int[] a = {1,5,6,9,45,456,7894,159753};
        int search = fibSearch(a, 456);
        System.out.println("index = " + search);
//        int[] fib = fib();
//        System.out.println(Arrays.toString(fib));
    }

    /**
     * 非递归方法得到一个斐波那契数列
     * @return 数列
     */
    public static int[] fib(){
        int[] f = new int[maxSize];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < maxSize; i++) {
            f[i] = f[i-1] + f[i-2];
        }
        return f;
    }
    /**
     * 利用斐波那契数列进行查找
     */
    public static int fibSearch(int[] a,int findVal){
        //mid = low + f[k-1]-1;
        int[] f = fib();
        int mid = 0;
        int low = 0;
        int high = a.length-1;
        int k = 0;
        while (high > f[k] - 1){
            k++;
        }
        int[] temp = Arrays.copyOf(a,f[k]);
        for (int i = high+1; i < temp.length; i++) {
            temp[i] = a[high];
        }
        while (low <= high) {
            mid = low + f[k - 1] - 1;
            if (findVal < temp[low]){
                high = mid - 1;
                k--;
            }else if (findVal > temp[high]){
                low = mid +1;
                k -= 2;
            }else {
                if (mid <= high){
                    return mid;
                }else {
                    return high;
                }
            }

        }
        return-1;

    }
















    /*
    public static int[] fib(){
        int[] f = new int[maxSize];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < maxSize; i++) {
            f[i] = f[i-1]+f[i-2];
        }
        return f;
    }
    public static int fibSearch(int[] a,int finVal){
        //mid = low + fib(k-1) -1;
        //数组的第一个数的下标
        int low = 0;
        //数组的最后一个下标
        int higt = a.length-1;
        //存储中间坐标
        int mid = 0;
        //斐波那契分割的下标
        int k = 0;
        //获取斐波那契数列
        int[]f = fib();
        //f[k]-1必须大于等于high
        while (higt > f[k]-1){
            k++;
        }
        //f[k]的值有可能大于数组的长度，因此需要使用Arrays类，构造一个新的数组，
        //并指向temp[]，不足的部分用0填充
        int[] temp = Arrays.copyOf(a,f[k]);

        for (int i = higt+1; i < temp.length; i++) {
            temp[i] = a[higt];
        }
        //使用while循环找到findVal
        while (low <= higt){
            mid = low + f[k-1] - 1;
            if (finVal < temp[mid]){
                   higt = mid-1;
                   k--;
            }else if (finVal > temp[mid]){
                low = mid + 1;
                k -= 2;
            }else {
                if (mid <= higt){
                    return mid;
                }else {
                    return higt;
                }
            }
        }
return -1;

    }*/
}
