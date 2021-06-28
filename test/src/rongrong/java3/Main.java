package rongrong.java3;
/**
 * @description����Ŀ���������þ���
 * С�����ڿ���һ����������, ��ʱ���������û����� "happy"��ʱ�� �п������ ����� "hapy"����"heppy" ��ʱ,
 * ����С����ʹ�õ��ǱȽ��㷨, �޷���֪����û���ʵ����Ҫ�� happy.  ��������Ҫһ������, �ܹ�֪��, �û������
 * "hapy"�� "happy" �ж���ƫ��. ������綨: ����"happy" ����, ����������������ĵ��ַ��� (����ָ, ���,
 * ɾ��, �޸�-���������) Ϊ����ַ���. �����Խ����ô����������Խ���ס�
 * ���� "happy" ��"hapy"��˵, ����ͨ������һ�� 'p' �����, ��Ϊֻ��Ҫһ���������������Ϊ1
 * ����"xiaomi" �� "x"��˵,  ��Ҫ5���ſ��Ա�Ϊ xiaomi, �������Ϊ5
 * ��������
 * �����ַ������������룩�����������ַ���ֱ�ӵ�����ԣ�ֻ����Ӣ����ĸ���ַ������֡�
 * ÿһ��Ϊһ���ַ������롣
 * �������
 * �����С������������int��ʽ�����
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
    //��̨�ף�һ����һ��������
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
    //��̨�������棬һ��һ����������...��n��
    //f(n)=f(n-1)+f(n-2)+...+f(1)
    //f(n-1)=f(n-2)+...+f(1)
    //��ʽ�����   f(n) = 2*f(n-1)
    public static int f1(int target){
        if (target < 2) return target;

        int a = 1,sum = 0;
        for (int i = 2; i < target+1; i++) {
            sum = a << 1;//�ھ�������*2������/2
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
