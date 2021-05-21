package rongrong.java;

import java.util.Arrays;

/**
 * @description：
 * @auther lurongrong
 * @create 2021-04-05 20:06
 */
public class TestDemo1 {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = {2,5,6};
        int n = 3;
        merge(nums1,m,nums2,n);
    }
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if(m==0) System.out.println(Arrays.toString(nums2));
        if(n==0) System.out.println(Arrays.toString(nums1));
        for(int i = m;i<m+n;i++){
            nums1[i] = nums2[i-m];
        }
        System.out.println(Arrays.toString(nums1));
        for(int i = 0;i<nums1.length;i++){
            boolean flag = false;
            for (int j = 0; j < nums1.length-i-1; j++) {
                if (nums1[j] > nums1[j+1]){
                    int temp = nums1[j];
                    nums1[j] = nums1[j+1];
                    nums1[j+1] = temp;
                    flag = true;
                }
            }
            if (!flag){
                break;
            }
        }
        System.out.println(Arrays.toString(nums1));
    }
    public static void merge1(int[] nums1,int m,int[] nums2,int n){
        int len1 = m - 1;
        int len2 = n - 1;
        int len = m+n-1;
        while (len1>=0 && len2>=0){

            nums1[len--] = nums1[len1] > nums2[len2] ? nums1[len1--] : nums2[len2--];

        }
        //表示将nums2数组从下标0位置开始，拷贝到nums1数组中，从下标0位置开始，长度为len2+1
        System.arraycopy(nums2,0,nums1,0,len2+1);
    }
}
