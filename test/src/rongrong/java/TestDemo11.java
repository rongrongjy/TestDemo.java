package rongrong.java;

import java.util.Scanner;

/**
 * @description：数值的整数次方
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * 保证base和exponent不同时为0，不得使用库函数，同时不需要考虑大数问题也不用考虑小数点后0的位数。
 * @auther lurongrong
 * @create 2021-05-24 20:24
 */
public class TestDemo11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请从键盘输入base和exponent");
        System.out.print("base = ");
        double base = scanner.nextDouble();
        System.out.print("exponent = ");
        int exponent = scanner.nextInt();
        double power = power(base, exponent);
        System.out.println(power);


    }
    public static double power(double b,int e){
        double res = 1;
        if (e>=0){
            for (int i = 0; i < e; i++) {
                res *=b;
            }
        }else {
            for (int i = 0; i < (-e); i++) {
                res *=b;
            }
            return (double) 1/res;
        }

        return res;
    }
}
