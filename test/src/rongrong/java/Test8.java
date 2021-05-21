package rongrong.java;

import java.util.Scanner;

/**
 * @description：
 * @auther lurongrong
 * @create 2021-05-13 23:12
 */
public class Test8 {
        public static void main(String[] args) {
            bineryFind();
        }

    private static void bineryFind() {
        int start = 0,end,middle = 0;
        int a[] = {12,45,67,89,123,-45,67};
        int N=a.length-1;
        sort(a, N+1);
        System.out.println("输入整数，程序判断该整数是否在数组中：");
        int number = new Scanner(System.in).nextInt();
//        int count = 0;//从这里开始 就有点看不懂了
        end = a.length-1;
        boolean flag = false;
        while(start <= end && !flag) {
            middle=(start+end)/2;

            if(number==a[middle]) {
                flag = true;
            }else if (number<a[middle]) {

                start = middle + 1;
            }else {
                end = middle - 1;
            }
        }
        if(flag)
            System.out.printf("%d在数组中.\n",number);
        else
            System.out.printf("%d不在数组中.\n",number);
    }

    private static void sort(int[] a, int N) {
        for(int i = 0; i< N; i++) {
            for(int j = i+1; j< N; j++) {
                if(a[i]< a[j]) {
                    int t= a[i];
                    a[i]= a[j];
                    a[j]=t;
                }
            }
        }
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + "\t");
        }
        System.out.println();
    }

}
