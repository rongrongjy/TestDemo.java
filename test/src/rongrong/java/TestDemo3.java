package rongrong.java;

import java.util.Scanner;

/**
 * @description：
 * @auther lurongrong
 * @create 2021-04-10 11:43
 */
public class TestDemo3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请从键盘输入： index=");
        int index = scanner.nextInt();
        int getUglyNumber = GetUglyNumber_Solution(index);
        System.out.println(getUglyNumber);
    }
    public static int GetUglyNumber_Solution(int index) {
        if(index<=0){
            return 0;
        }
        int[] res = new int[index];
        int p2 = 0,p3 = 0,p5 = 0;
        res[0] = 1;
        for(int i = 1;i < index;i++){
            int min = Math.min(res[p2]*2,Math.min(res[p3]*3,res[p5]*5));
            if(min == res[p2]*2){
                res[i] = min;
                p2++;
            }
            if (min==res[p3]*3){
                res[i]=min;
                p3++;
            }
            if (min==res[p5]*5){
                res[i]=min;
                p5++;
            }
        }
        return res[index-1];
    }
}
