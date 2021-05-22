package rongrong.java;

import java.util.Arrays;

/**
 * @description：堆排序
 * 第一步：将一个数组建成大顶堆（父节点的值比子节点的值大，升序排序）或小顶堆（父节点的值比子节点的值小）
 *      数组下标为i的左子节点的下标为2*i+1，右子节点的下标为2*i+2
 * 第二步：将建立好的大顶堆（小顶堆）的第一个节点的值与最后一个节点的值进行交换
 * 第三步：接第二步，将除去最后一个节点的剩下的数组再次建成大顶堆（小顶堆）
 * @auther lurongrong
 * @create 2021-05-21 16:34
 */
public class HeapSortTest {
    public static void main(String[] args) {
        int[] arr = {4,6,8,5,9,0,12,-1,56};
        heapSort1(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void heapSort(int[] arr){

        int temp = 0;
        System.out.println("堆排序");
        //将每一个非叶子节点进行建堆
        for (int i = arr.length/2-1; i >= 0; i--) {

            buildHeap(arr,i,arr.length);
        }
        //将对顶元素与末尾元素交换，将最大元素“沉”到数组末端
        //重新调整结构，是其满足堆定义，然后继续交换堆顶元素与当前末尾元素，反复执行调整+交换步骤，
        //直到整个序列有序。
        for (int i = arr.length-1; i > 0 ; i--) {
            //交换
            temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            buildHeap(arr,0,i);
        }
    }
    public static void buildHeap(int[] arr,int i,int length){

      if (arr == null || arr.length < 0) return;
      int temp = arr[i];
        for (int j = i*2+1; j < length; j = j*2+1) {
            //旨在找比下标为i的节点的值大的节点的下标
            //j本就是左节点值的下标
            if (j+1<length && arr[j] < arr[j+1]){//左节点的值小于右节点的值
                j++;//此时的j为右节点值的下标
        }
            if (arr[j] > temp){//子节点的值大于父节点的值
                arr[i] = arr[j];//把较大的值赋给当前节点
                i = j;//i指向j，继续循环比较
            }else {
                break;
            }

        }
        //当for循环结束后，我们已经将i为父节点的树的最大值，放在了最顶（局部）
        arr[i] = temp;
    }
    public static void heapSort1(int[] arr){
        if (arr == null || arr.length == 0) return;
        int temp = 0;
        //第一次建好堆
        for (int i = arr.length/2-1; i >= 0; --i) {

            buildHeap1(arr,i,arr.length);
        }
        //交换对顶元素和末尾元素
        for (int i = arr.length-1; i > 0; --i) {
            temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            buildHeap1(arr,0,i);
        }
    }
    //对每一个非叶子节点进行建堆
    public static void buildHeap1(int[] arr,int i,int length){
        if (arr == null || arr.length == 0) return;
        int temp = arr[i];
        //将父节点与子节点的值进行比较，进行交换
        for (int j = 2*i+1; j < length; j = j*2+1) {
            if (j+1 < length && arr[j] < arr[j+1]){
                j++;//指向 右节点
            }
            //此时的j对应的加点的值即为子节点中最大的那个
            if (arr[i] < arr[j]){
                arr[i] = arr[j];//将比父节点大的节点的值赋给父节点
                i = j;
            }else {
                break;
            }
        }
        arr[i] = temp;
    }
}
