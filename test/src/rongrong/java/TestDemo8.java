package rongrong.java;

import java.util.Arrays;

/**
 * @description：敲 狂敲
 * @auther lurongrong
 * @create 2021-04-18 10:11
 */


    public class TestDemo8 {

    public static void main(String[] args) {
        int[] arr = {1,5,2,3,6,8,4,9,7};
//        quickSort(arr,0, arr.length-1);
        int[] temp = new int[arr.length];
//        radixSort(arr);
        insertSort1(arr);
        System.out.println(Arrays.toString(arr));
        //测试快排的执行速度
        //创建要给80000个的随机的数组
        /*int[] arr = new int[8000000];
        for (int i = 0; i < 8000000; i++) {
            arr[i] = (int) (Math.random() * 8000000);//生成一个随机[0,80000]的数
        }
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(date);
        System.out.println("排序前的时间是=" + date);
        quickSort(arr, 0, arr.length - 1);
        Date date1 = new Date();
        String format1 = simpleDateFormat.format(date1);
        System.out.println("排序后的时间是=" + format1);*/
    }

    //快排
    public static void quickSort(int[] arr, int left, int right) {
        int l = left;//左下标
        int r = right;//右下标
        //pivot 中轴值
        int pivot = arr[(left + right) / 2];
        int temp = 0;//临时变量，作为交换时使用
        //while循环的目的是让比pivot值小的放到左边
        while (l < r) {
            //在pivot的左边一直找，找到大于等于pivot值，才退出
            while (arr[l] < pivot) {
                l += 1;
            }
            while (arr[r] > pivot) {
                r -= 1;
            }
            //如果l>=r说明pivot的左右两的值，已经按照左边全部是
            //小于等于pivot的值
            if (l >= r) {
                break;
            }
            //交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            //如果交换完后，发现这个arr[l]==pivot值，r--，前移
            if (arr[l] == pivot) {
                r -= 1;
            }
            if ((arr[r] == pivot)) {

                l += 1;
            }

        }
        //如果l == r，必须l++，r--，否则会出现栈溢出
        if (l == r) {
            l++;
            r--;
        }
        //向左递归
        if (left < r) {
            quickSort(arr, left, r);
        }
        if (right > l) {
            quickSort(arr, l, right);
        }
    }

    //归并排序
    //分合法
    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;//中间索引
            //向左递归进行分解
            mergeSort(arr, left, mid - 1, temp);
            //右
            mergeSort(arr, mid + 1, right, temp);
            //合并
            merge(arr, left, mid,right, temp);
        }


    }
    //合并法

    /**
     *
     * @param arr 排序的原始数组
     * @param left 左边有序数列的初始索引
     * @param mid 中间索引
     * @param right 右边有序序列的初始索引
     * @param temp 做中转的索引
     */
    public static void merge(int[] arr,int left,int mid,int right,int[] temp) {
        int i = left;//初始化i，左边有序序列的初始索引
        int j = mid + 1;//初始化j，右边有序序列的初始索引
        int t = 0;//指向temp数组的当前索引
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[t] = arr[i];
                t++;
                i++;
            } else {
                temp[t] = arr[j];
                t++;
                j++;
            }
        }
        while (i <= mid) {
            temp[t] = arr[i];
            t++;
            i++;
        }
        while (j <= right) {
            temp[t] = arr[j];
            t++;
            j++;
        }
       //将temp中的数拷贝到arr中
        t = 0;
        int tempLeft = left;
        while (tempLeft<=right){
            arr[tempLeft] = temp[t];
            t++;
            tempLeft++;
        }
    }

   //基数排序  空间换时间
   public static void radixSort(int[] arr){
        //1.得到数组中最大的数
        int max = arr[0];//假设第一个数就是最大数
       for (int i = 1;i<arr.length;i++){
           if (arr[i]>max){
               max = arr[i];
           }
       }
       //2.判断最大数是几位数
       int maxlength = (max + "").length();
       //定义一个二维数组，表示10个桶，每个桶就是一个一维数组
       int[][] bucket = new int[10][arr.length];
       //记录每个桶中存储的元素的个数
       int[] bucketElementCounts = new int[10];
       for (int i = 0,n = 1; i < maxlength; i++,n*=10) {
           for (int j = 0; j < arr.length; j++) {
               //取出每个元素对应位置的值
               int digitOfElement = arr[j]/n%10;
               //放入到对应的桶中
               bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
               bucketElementCounts[digitOfElement]++;
           }
           int index = 0;
           for (int k = 0; k < bucketElementCounts.length; k++) {
               if (bucketElementCounts[k] != 0){
                   for (int l = 0; l < bucketElementCounts[k]; l++) {
                       arr[index++] = bucket[k][l];
                   }
               }
               bucketElementCounts[k] = 0;
           }

       }
   }

/**
 * 插入排序
 */
public static void insertSort(int[] arr){
    if (arr == null || arr.length == 0){
        System.out.println("数组为null或数组为空");
        return;
    }
    for (int i = 1; i < arr.length; i++) {
        int Value = arr[i];
        int index ;
        for (index = i-1; index >= 0; --index) {
            if (Value < arr[index]){
                arr[index+1] = arr[index];
            }else break;
//            arr[j+1] = Value;
        }
        arr[index+1] = Value;
    }


}
public static void insertSort1(int[] a){
    if (a == null || a.length == 0){
        System.out.println("数组为null或数组为空");
        return;
    }
    for (int i = 1; i < a.length; i++) {
        int Value = a[i];
        int index = i-1;
        while (index >= 0 && a[index] > Value){
            a[index+1] = a[index];
            index--;
        }
        a[index+1] = Value;
    }
}















    }
