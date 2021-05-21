package rongrong.java;

import java.util.Arrays;

/**
 * @description：选择排序
 * @auther lurongrong
 * @create 2021-03-22 21:34
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {5,812,10,61,2,3895,81563,912};
        System.out.println("原始数据为：" + "\n" +  Arrays.toString(arr));
        System.out.println("排序之后：");
        int[] temp = new int[arr.length];
//        mergeSort(arr,0, arr.length-1, temp);
//        radixSort(arr);
//        selectSort(arr,arr.length);
//        System.out.println("冒泡排序：");
//        bubbleSort(arr,arr.length);
//        System.out.println("插入排序：");
//        insertSort(arr, arr.length);
        System.out.println("快速排序：");
        quickSort(arr,0, arr.length-1);
        System.out.println(Arrays.toString(arr));
//        quick_sort(arr,0, arr.length-1);



//        int[] arr = new int[8];
//        for (int i = 0; i < 8; i++) {
//            arr[i] = (int)(Math.random()*8);
//        }
//        System.out.println("排序前：");
//        System.out.println(Arrays.toString(arr));
//
//        Date date = new Date();
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String dateStr = simpleDateFormat.format(date);
//        System.out.println("排序前的时间是：" + dateStr);
//        shellSort(arr);
//        Date date1 = new Date();
//        String datelStr = simpleDateFormat.format(date1);
//        System.out.println("排序后的时间是：" + datelStr);
//        System.out.println(Arrays.toString(arr));











        /*
        //测试快排的速度
        int[] arr = new int[8];
        for (int i = 0; i < 8; i++) {
            arr[i] = (int)(Math.random()*8);
        }
        System.out.println("排序前：");
        System.out.println(Arrays.toString(arr));

        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = simpleDateFormat.format(date);
        System.out.println("排序前的时间是：" + dateStr);
        quickSort(arr,0, arr.length-1);
        Date date1 = new Date();
        String datelStr = simpleDateFormat.format(date1);
        System.out.println("排序后的时间是：" + datelStr);
        System.out.println(Arrays.toString(arr));
*/
    }

    /**
     * 选择排序
     * @param arr
     * @param n
     */
    public static void selectSort(int[] arr,int n){
        //检验数据
        if (n <= 0)
            return;
        for (int i = 0; i < n; i++) {
            int index = i;
            int min = arr[i];
            for (int j = i+1; j < n; j++) {
                if (min > arr[j]){
                    index = j;
                    min = arr[j];
                }
            }
           if(index != i){
               arr[index] = arr[i];
               arr[i] = min;
           }
        }
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 冒泡排序
     * @param arr
     * @param n
     */
    public static void bubbleSort(int[] arr,int n){
        if (n<=1)
            return;
        for (int i = 0; i < n; i++) {

            boolean flag = false;//优化算法的关键
            for (int j = 0; j < n-i-1; j++) {
                if (arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[ j+1];
                    arr[j+1] = temp;
                    flag = true;
                }
            }
            if (!flag) break;
        }
    }
    /**
     * 希尔排序
     */

    public static void shellSort(int[] arr){
      for (int gap = arr.length/2;gap > 0;gap /= 2){
          for (int i = gap; i < arr.length; i++) {
              int index = i;
              int indexVal = arr[index];
              if (arr[index] < arr[index-gap]){
                  while (index - gap >= 0 && indexVal < arr[index-gap]) {
                      arr[index] = arr[index-gap];
                      index -= gap;

                  }
                  //当退出while循环就给indexVal找到插入的位置
                  arr[index] = indexVal;
              }
          }
      }
    }

    /**
     * 插入排序
     * @param arr
     * @param n
     */
    public static void insertSort(int[] arr,int n){
        if (n<=1)
            return;
        for (int i = 1; i < n; i++) {
            int insertVal = arr[i];
            int index = i-1;
           while (index >= 0 && arr[index] > insertVal){
               arr[index+1] = arr[index];
               index--;
           }
            arr[index+1] = insertVal;
        }
    }
    /**
     * 快速排序
     */
    public static void quickSort(int[] arr,int left,int right){
//        if (left < 0 || right < 0) return;
       int l = left;//左下标
       int r = right;//右下标
       int pivot = arr[(left+right)/2];//中轴值

       int temp = 0;//临时变量，作为交换时使用
       //while循环的目的是让比pivot值小的放到左边
        //比pivot大的放到右边
        while (l<r){
            if (l < 0 || r < 0) return;
            //在pivot的左边一直找，找到大于等于pivot值，才退出
            while (arr[l]<pivot){
                l += 1;
            }
            //在pivot的左边一直找，找到小于等于pivot值，才退出

            while (arr[r]>pivot){
                r -= 1;
            }
            //如果l>r说明pivot的左右两边的值，已经按照左边全是小于等于pivot的值，
            //右边全是大于等于pivot的值
            if(l>=r){
                break;
            }
            //交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            //如果交换完后，发现这个arr[l]==pivot r--,前移
            if (arr[l]==pivot){
                r -= 1;
            }
            //如果交换完后，发现这个arr[r]==pivot l++,后移
            if (arr[r]==pivot){
                l -= 1;
            }
        }
        //如果r=l，必须l++，r--，否则会出现栈溢出
        if (l==r){
            l += 1;
            r -= 1;
        }
        //向左递归
        if (left < r){
            quickSort(arr,left,r);
        }
        //向右递归
        if (right > l){
            quickSort(arr,l,right);
        }
    }
   public static void quick_sort(int s[], int l, int r)
    {
        if (l < r)
        {
            //Swap(s[l], s[(l + r) / 2]); //将中间的这个数和第一个数交换 参见注1
            int i = l, j = r, x = s[l];
            while (i < j)
            {
                while(i < j && s[j] >= x) // 从右向左找第一个小于x的数
                    j--;
                if(i < j)
                    s[i++] = s[j];

                while(i < j && s[i] < x) // 从左向右找第一个大于等于x的数
                    i++;
                if(i < j)
                    s[j--] = s[i];
            }
            s[i] = x;
            quick_sort(s, l, i - 1); // 递归调用
            quick_sort(s, i + 1, r);
        }
    }


public static void quickSort1(int[] a,int left,int right){
        if (left < right) {
            int l = left;
            int r = right;
            int tmp = a[l];
            while (l < r) {
                while (l < r && a[r] >= tmp) {
                    r--;
                }
                if (l < r) {
                    a[l++] = a[r];
                }
                while (l < r && a[l] < tmp) {
                    l++;
                }
                if (l < r) {
                    a[r--] = a[l];
                }
            }
            a[l] = tmp;
            quickSort1(a, left, l - 1);
            quickSort1(a, l + 1, right);
        }
}
public static void mergeSort(int[] arr,int left,int right,int[] temp){
    if (left<right){
        int mid = (left+right)/2;//中间索引
        //向左递归进行分解
        mergeSort(arr,left,mid,temp);
        //向右递归进行分解
        mergeSort(arr,mid+1,right,temp);
        //合并
        merge(arr,left,right,mid,temp);
    }
}

    /**
     * 合并的方法
     * @param arr 排序的原始数组
     * @param left 左边有序序列的初始索引
     * @param right 右边索引
     * @param temp 做中转的索引
     * @param mid 中间索引
     */
    public static void merge(int[] arr,int left,int right,int mid,int[] temp){
        int i = left;//初始化i，左边有序序列的初始索引
        int j = mid + 1;//初始化j，右边序列的初始化索引
        int t = 0;//指向temp数组的当前索引
        //（一）
        //先把左右两边有序的数据按照规则填充到temp数组
        //直到左右两边的有序序列，有一边处理完毕为止
        while (i<=mid && j<=right){//继续
            //如果左边的有序序列的当前元素，小于等于右边有序序列的当前元素
            //即将左边的当前元素，填充到temp数组
            //然后t++，i++
            if (arr[i]<=arr[j]){
                temp[t++] = arr[i++];
//                t++;
//                i++;
            }else {
                temp[t++] = arr[j++];
//                t++;
//                j++;
            }
        }
        //（二）
        //把有剩余数据的一遍的数据依次全部填充到temp
        while (i<=mid){//左边的有序序列还有剩余的元素，就全部填充到temp
            temp[t++] = arr[i++];
//            t++;
//            i++;

        }
        while (j<=right){//右边的有序序列还有剩余的元素，就全部填充到temp
            temp[t++] = arr[j++];
//            t++;
//            j++;

        }
        //（三）
        //将temp数组的元素拷贝到arr
        //注意，并不是每次都拷贝所有
        t=0;
        int tempLeft = left;
        //第一次合并tempLeft = 0，right = 1
        while (tempLeft<=right){
            arr[tempLeft++] = temp[t++];
//            t++;
//            tempLeft ++;
        }
}
/**
 * 基数排序：创建一个二维数组，由十个一维数组组成
 */
public static void radixSort(int[] arr){
    //空间换时间
    //根据对应的位数将数据放入对应的数组中
    //最大数的位数即为排序的轮数
    //找到最大数
    int max = arr[0];
    for (int i = 1; i < arr.length; i++) {
        if (max < arr[i])
            max = arr[i];
    }
    //最大数的位数
    int maxLength = (max+"").length();
    //定义一个二维数组，表示10个桶，每个桶就是一个一维数组
    //每个桶中所装的数的个数最大化，防止数据溢出，即空间换时间
    int [][] bucket = new int[10][arr.length];
    //记录每个桶中装入的数据的个数,用一个一维数组分别表示十个桶的数据的个数
    int [] bucketElementCounts = new int[10];
    //开始循环代码的实现,位数有几个就循环几次
    //n是对每次取位数的处理
    for (int i = 0,n = 1; i < maxLength; i++,n*=10) {
        //取出每个元素对应位置的值，再放入对应的桶
        for (int j = 0; j < arr.length; j++) {
            //计算出对应的位数
            int digitOfElement = arr[j]/n%10;
            //放入到对应的桶中
            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
            //桶中的个数+1
            bucketElementCounts[digitOfElement]++;
        }
        //将放好的数组再进行遍历，取出桶中的数据放入数组
        int index = 0;
        for (int j = 0; j < bucketElementCounts.length; j++) {
            //如果桶中有数据，我们才放入原数组
            if (bucketElementCounts[j]!=0){
                for (int k = 0; k < bucketElementCounts[j]; k++) {
                    arr[index++]=bucket[j][k];
                }
            }
            //第i+1轮处理后，需要将每个bucketElementCount[k]=0，清空
            bucketElementCounts[j]=0;
        }

    }
}


}













