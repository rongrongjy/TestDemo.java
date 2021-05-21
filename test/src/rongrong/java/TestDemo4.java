package rongrong.java;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @description：
 * @auther lurongrong
 * @create 2021-04-10 22:53
 */
public class TestDemo4 {
    public static void main(String[] args) {
        int[] input = {4,5,1,6,2,7,3,8};
        int k = 4;
        ArrayList<Integer> list = GetLeastNumbers_Solution(input, k);
        System.out.println(list);
    }
    @Test
    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {

        ArrayList<Integer> res = new ArrayList<Integer>();
        if(k>input.length){
            return new ArrayList<Integer>();
        }
        for(int i = 0;i<input.length;i++){
            boolean flag = false;
            for(int j = 0;j<input.length-i-1;j++){
                if(input[j]>input[j+1]){
                    int temp = input[j];
                    input[j] = input[j+1];
                    input[j+1] = temp;
                    flag = true;
                }

            }
            if(!flag){
                break;
            }
        }
//        System.out.println(Arrays.toString(input));
        for(int i = 0;i<k;i++){
            res.add(input[i]);
        }
        System.out.println("*********");
//
//        Iterator<Integer> iterator = res.iterator();
//        while (iterator.hasNext()){
//            System.out.println(iterator.next());
//        }

        return res;
    }
}
