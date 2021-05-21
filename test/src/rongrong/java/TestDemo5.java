package rongrong.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @description：二分查找
 * @auther lurongrong
 * @create 2021-04-11 19:12
 */
public class TestDemo5 {
//import java.util.*;
public static void main(String[] args) {
    int[] nums = {1,2,2,3,4};
    int search = search(nums, 2);
    System.out.println(search);
}


        /**
         * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
         *
         * 如果目标值存在返回下标，否则返回 -1
         * @param nums int整型一维数组
         * @param target int整型
         * @return int整型
         */
        public static int search (int[] nums, int target) {
            if(nums.length < 1 || target<nums[0] || target>nums[nums.length-1] ){
                return -1;
            }
            // write code here
            int left = 0,right = nums.length-1;

            int res = binarySearch(nums,left,right,target);
            return res;

        }
        public static int binarySearch(int[] nums,int left,int right,int target){


            if(left > right){
                return -1;
            }
            int mid = (left+right)/2;
            int midValue = nums[mid];
            if(midValue>target){
                return binarySearch(nums,left,mid-1,target);
            }else if(midValue<target){
                return binarySearch(nums,mid+1,right,target);
            }else{
            /*
            1.在找到mid索引值时，不要马上返回
            2.向mid索引值的左边扫描，将于mid对应的值相同的元素的下标，加入到一个集合中
            3.向mid索引值的右边扫描，将于mid对应的值相同的元素的下标，加入到一个集合中
            4.返回集合中的第一个元素即可。
            */
                List<Integer> resIndexList = new ArrayList<>();
                int temp = mid-1;
                while(true){
                    if(temp<0 || nums[temp] != target){
                        break;
                    }
                    resIndexList.add(temp--);
                }
                resIndexList.add(mid);
                temp = mid+1;
                while(true){
                    if(temp>nums.length-1 || nums[temp] != target){
                        break;
                    }
                    resIndexList.add(temp++);
                }
                Collections.sort(resIndexList);
//                for(int i:resIndexList){
                    System.out.print(resIndexList + "  ");
//                }
                return resIndexList.get(0);
            }

        }

}
