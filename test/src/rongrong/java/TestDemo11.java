package rongrong.java;

import java.util.Scanner;

/**
 * @description����ֵ�������η�
 * ����һ��double���͵ĸ�����base��int���͵�����exponent����base��exponent�η���
 * ��֤base��exponent��ͬʱΪ0������ʹ�ÿ⺯����ͬʱ����Ҫ���Ǵ�������Ҳ���ÿ���С�����0��λ����
 * @auther lurongrong
 * @create 2021-05-24 20:24
 */
public class TestDemo11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("��Ӽ�������base��exponent");
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
