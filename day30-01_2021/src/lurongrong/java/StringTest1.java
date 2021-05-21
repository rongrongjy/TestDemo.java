package lurongrong.java;

import org.junit.Test;

/**
 * @description：
 * @auther lurongrong
 * @create 2021-01-30 9:35
 */
public class StringTest1 {



    @Test
    public void Test1(){
        String str1 = "abc123";
        char[] c1 = str1.toCharArray();
//        char[] c3 =
        //中间字符串的反转
        for (int i = 1,j = c1.length - 2; i < c1.length / 2; i++,j--) {
            char temp = c1[i];
                c1[i] = c1[j];
                c1[j] = temp;
        }
//        for (int i = 0; i < c1.length / 2 ; i++) {
//            for (int j = c1.length - 1 ;j >0 ; j--) {
//                char temp = c1[i];
//                c1[i] = c1[j];
//                c1[j] = temp;
//            }
//        }
//
//        for (int i = 1; i < c1.length - 2; i++) {
////            if (i >0 && i < c1.length - 2) {
//                char temp = c1[c1.length - i - 1];
//                c1[c1.length - 2] = c1[i];
//                c1[i] = temp;
////            }
//        }

        System.out.println(str1);
        System.out.println("**********");
        System.out.println(c1);
        System.out.println("***********");
        for (int i = 0; i < c1.length; i++) {
            System.out.println(c1[i]);
        }
        char[] c2 = new char[]{'a','b','c','1'};
        String str2 = String.valueOf(c2);
        System.out.println(str2);
    }
}
