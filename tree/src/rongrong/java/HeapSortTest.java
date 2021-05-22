package rongrong.java;

import java.util.Arrays;

/**
 * @description��������
 * ��һ������һ�����齨�ɴ󶥶ѣ����ڵ��ֵ���ӽڵ��ֵ���������򣩻�С���ѣ����ڵ��ֵ���ӽڵ��ֵС��
 *      �����±�Ϊi�����ӽڵ���±�Ϊ2*i+1�����ӽڵ���±�Ϊ2*i+2
 * �ڶ������������õĴ󶥶ѣ�С���ѣ��ĵ�һ���ڵ��ֵ�����һ���ڵ��ֵ���н���
 * ���������ӵڶ���������ȥ���һ���ڵ��ʣ�µ������ٴν��ɴ󶥶ѣ�С���ѣ�
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
        System.out.println("������");
        //��ÿһ����Ҷ�ӽڵ���н���
        for (int i = arr.length/2-1; i >= 0; i--) {

            buildHeap(arr,i,arr.length);
        }
        //���Զ�Ԫ����ĩβԪ�ؽ����������Ԫ�ء�����������ĩ��
        //���µ����ṹ����������Ѷ��壬Ȼ����������Ѷ�Ԫ���뵱ǰĩβԪ�أ�����ִ�е���+�������裬
        //ֱ��������������
        for (int i = arr.length-1; i > 0 ; i--) {
            //����
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
            //ּ���ұ��±�Ϊi�Ľڵ��ֵ��Ľڵ���±�
            //j��������ڵ�ֵ���±�
            if (j+1<length && arr[j] < arr[j+1]){//��ڵ��ֵС���ҽڵ��ֵ
                j++;//��ʱ��jΪ�ҽڵ�ֵ���±�
        }
            if (arr[j] > temp){//�ӽڵ��ֵ���ڸ��ڵ��ֵ
                arr[i] = arr[j];//�ѽϴ��ֵ������ǰ�ڵ�
                i = j;//iָ��j������ѭ���Ƚ�
            }else {
                break;
            }

        }
        //��forѭ�������������Ѿ���iΪ���ڵ���������ֵ������������ֲ���
        arr[i] = temp;
    }
    public static void heapSort1(int[] arr){
        if (arr == null || arr.length == 0) return;
        int temp = 0;
        //��һ�ν��ö�
        for (int i = arr.length/2-1; i >= 0; --i) {

            buildHeap1(arr,i,arr.length);
        }
        //�����Զ�Ԫ�غ�ĩβԪ��
        for (int i = arr.length-1; i > 0; --i) {
            temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            buildHeap1(arr,0,i);
        }
    }
    //��ÿһ����Ҷ�ӽڵ���н���
    public static void buildHeap1(int[] arr,int i,int length){
        if (arr == null || arr.length == 0) return;
        int temp = arr[i];
        //�����ڵ����ӽڵ��ֵ���бȽϣ����н���
        for (int j = 2*i+1; j < length; j = j*2+1) {
            if (j+1 < length && arr[j] < arr[j+1]){
                j++;//ָ�� �ҽڵ�
            }
            //��ʱ��j��Ӧ�ļӵ��ֵ��Ϊ�ӽڵ��������Ǹ�
            if (arr[i] < arr[j]){
                arr[i] = arr[j];//���ȸ��ڵ��Ľڵ��ֵ�������ڵ�
                i = j;
            }else {
                break;
            }
        }
        arr[i] = temp;
    }
}
