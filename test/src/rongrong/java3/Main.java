package rongrong.java3;
/**
 * @description：题目描述：米兔纠错
 * 小米兔在开发一个搜索功能, 这时候他发现用户输入 "happy"的时候 有可能输错 会输成 "hapy"或者"heppy" 此时,
 * 由于小米兔使用的是比较算法, 无法得知这个用户其实是想要的 happy.  于是他想要一个方法, 能够知道, 用户输入的
 * "hapy"与 "happy" 有多大的偏差. 因此他界定: 对于"happy" 而言, 与其相差两个操作的的字符串 (操作指, 添加,
 * 删除, 修改-即输入错误) 为相关字符串. 相关性越大，那么纠正起来就越容易。
 * 对于 "happy" 与"hapy"来说, 可以通过插入一个 'p' 来完成, 因为只需要一个纠正操作，输出为1
 * 对于"xiaomi" 与 "x"来说,  需要5步才可以变为 xiaomi, 其纠错步数为5
 * 输入描述
 * 两个字符串（两行输入），计算两个字符串直接的相关性，只考虑英文字母、字符和数字。
 * 每一行为一个字符串输入。
 * 输出描述
 * 输出最小纠错步数，并以int形式输出。
 * @auther lurongrong
 * @create 2021-06-11 18:51
 */
public class Main {
    public static void main(String[] args) {
        int target = 4;
        System.out.println(f(target));

        System.out.println("sum = " + f1(target));
        System.out.println("*************");

        int[] a = {3,1,2,5,2,4};
        System.out.println(maxWater(a));
    }
    //跳台阶，一次挑一个或两个
    public static int f(int target){
     /*   if (target <= 2) {
            return target;
        }else


        return f(target-1)+f(target-2);*/
        int a = 1,b = 2;
        for (int i = 3; i < target+1; i++) {
            b = b + a;
            a = b - a;
        }
        return b;

    }
    //跳台阶升级版，一次一个，两个，...，n个
    //f(n)=f(n-1)+f(n-2)+...+f(1)
    //f(n-1)=f(n-2)+...+f(1)
    //两式相减的   f(n) = 2*f(n-1)
    public static int f1(int target){
        if (target < 2) return target;

        int a = 1,sum = 0;
        for (int i = 2; i < target+1; i++) {
            sum = a << 1;//口诀：左移*2，右移/2
            a = sum;
        }
        return sum;
    }
    public static long maxWater (int[] arr) {
        if (arr == null || arr.length == 0){
            return 0;
        }
        int low = 0,temp = 0,sum = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[low] > arr[i]){
                temp = temp + arr[low] - arr[i];
            }
            if (arr[low] <= arr[i]){
                sum = temp + sum;
                temp = 0;
                low = i;
            }
        }
        low = arr.length - 1;
        temp = 0;
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[low] > arr[i]){
                temp = temp + arr[low] - arr[i];
            }
            if (arr[low] < arr[i]){
                sum = temp + sum;
                temp = 0;
                low = i;
            }
        }
        return sum;
    }

}
