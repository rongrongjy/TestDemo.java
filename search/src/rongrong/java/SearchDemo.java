package rongrong.java;

import java.util.ArrayList;
import java.util.List;

/**
 * @description：
 * @auther lurongrong
 * @create 2021-03-29 16:58
 */
public class SearchDemo {
    public static void main(String[] args) {
//        int[][] a = {{1,2,3},{4,5,6}};
//        System.out.println("a的长度" + a.length + "***" + a[1].length + "****" + a[0].length);
        int[] arr = {1,5,9,56,56,88,88,99};
        int i = binarySearch(arr, 0, arr.length-1, 88);
        if (i<0){
            System.out.println("没有找到！");
        }else
        System.out.println("找到的位置为："+i);
        List<Integer> list = insertSearch1(arr, 0, arr.length-1, 56);
        System.out.println("所找数据的位置：" + list);
        int i1 = insertValueSearch(arr, 0, arr.length - 1, 12);
        if (i1<0){
            System.out.println("没有找到！");
        }else
            System.out.println("插入排序：" + i1);

    }

        /**
         * 二叉树查找：无重复元素
         */

    public static int binarySearch(int[] arr,int left,int right,int findVal){
        if (left > right)
            return -1;
        //中间值的索引
        int mid = (left + right) / 2;
        //中间值
        int midVal = arr[mid];
        if (findVal > midVal){
            return binarySearch(arr,mid+1,right,findVal);
        }else if (findVal < midVal){
            return binarySearch(arr,left,mid-1,findVal);
        }else {
            return mid;
        }
    }
        /**
         * 二叉树查找：假如有重复元素
         * 在找到mid值时，不要马上返回
         *
         */

    public static List<Integer> binarySearch2(int[] arr, int left, int right, int findVal){
        if (left > right)
            return new ArrayList<Integer>();
//        int[] a = {};
        //中间值的索引
        int mid = (left + right) / 2;
        //中间值
        int midVal = arr[mid];

            if (findVal > midVal){
                return binarySearch2(arr,mid+1,right,findVal);
            }else if (findVal < midVal){
                return binarySearch2(arr,left,mid-1,findVal);
            }else {
                List<Integer> integers = new ArrayList<Integer>();
                int temp = mid -1;
               while (true){
                   if (temp < 0 || arr[temp] != findVal){
                       break;
                   }
                   integers.add(temp);
                   temp -= 1;
               }
               integers.add(mid);
               int temp1 = mid + 1;
               while (true){
                   if (temp1 > arr.length-1 || arr[temp1] != findVal){
                       break;
                   }
                   integers.add(temp1);
                   temp1 +=1;
               }
               return integers;
            }


    }
        /**
         * 插值查找：无重复元素
         */
        public static int insertValueSearch(int[] arr, int left, int right, int findVal) {
            if (left > right || findVal < 0 || findVal > arr[arr.length - 1])
                return -1;
            //中间值的索引
            int mid = left + (right - left) * (findVal - arr[left]) / (arr[right] - arr[left]);
            //中间值
            if (mid < 0 || mid > arr.length){

                return -1;
            }
            int midVal = arr[mid];
//            while (mid >= 0) {
                if (findVal > midVal) {
                    return insertValueSearch(arr, mid + 1, right, findVal);
                } else if (findVal < midVal) {
                    return insertValueSearch(arr, left, mid - 1, findVal);
                } else {
                    return mid;
                }
//            }
        }
        public static List<Integer> insertSearch1(int[] a,int left,int right,int findVal){
          if (left > right || findVal > a[right] || findVal < a[left])
              return new ArrayList<Integer>();
          int mid = left + (right - left) * (findVal - a[left]) / (a[right] - a[left]);
          if (mid < 0 || mid > a.length - 1){
              return new ArrayList<Integer>();
          }
          int midVal = a[mid];
          if (findVal > midVal){
              return insertSearch1(a,mid - 1,right,findVal);
          }else if (findVal < midVal){
              return insertSearch1(a,left,mid + 1,findVal);
          }else {
              List<Integer> list = new ArrayList<>();
              int temp = mid -1;
              while (true){
                  if (findVal != a[temp] || temp < 0){
                      break;
                  }else {
                      list.add(temp++);
                  }
              }
              list.add(mid);
              temp = mid + 1;
              while (true){
                  if (findVal != a[temp] || temp > a.length - 1){
                      break;
                  }else {
                      list.add(temp++);
                  }
              }
              return list;
          }
        }
    }















