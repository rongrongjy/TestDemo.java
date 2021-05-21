import java.util.Arrays;

/**
 * @description：
 * @auther lurongrong
 * @create 2021-04-12 20:50
 */
public class TestDemo6 {
    public static void main(String[] args) {
        int[] A = {0,1};
        int[] ints = sortArrayByParity(A);
        System.out.println(Arrays.toString(ints));
    }
    public static int[] sortArrayByParity(int[] A) {
        if(A.length<1){
            return null;
        }
        int index = 0;
        int endIndex = A.length-1;
        int[] res = new int[A.length];
        for(int i = 0;i < A.length;i++){
            if(A[i]%2==0){
                res[index++] = A[i];
            }else{
                res[endIndex--] = A[i];
            }
        }
        return res;
    }
}
