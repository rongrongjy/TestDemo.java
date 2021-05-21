package lurongrong.java;

/**
 * @description：
 * @auther lurongrong
 * @create 2021-01-30 20:22
 */

public class StringTest3 {
    public static void main(String[] args) {
        String str = "  abc 123   ";
        String s = Trim1(str);
        System.out.println(s);
        String str1 = "abcengf";
        System.out.println(str1.substring(1,6));
        String s2 = reverse(str1, 1, 5);
        System.out.println(s2);
        System.out.println(reverse1(str1,1,5));
        System.out.println(reverse2(str1,1,5));
        String s1 = "abdfafsakjadfgjncxvbsdansfbanfb";
        String s3 = "fafsahusjhsdghdgas";
        System.out.println(getCount(s1,s3));
        System.out.println(maxSameString(s1, s3));
    }
    //去除字符串两端的空格
    public static String  Trim1(String str) {
        char[] c  = str.toCharArray();
        int len = c.length;
        int star = 0;
        while ((star < len) && (c[star] == ' ')){
            star++;
        }
        while ((star < len) && (c[len - 1] == ' ')){
            len--;
        }
        return str.substring(star,len);
    }
    //字符串的反转：方式一
    public static String reverse(String str,int srartIndex,int endIndex){
        if (str != null && srartIndex < endIndex) {
            char[] c = str.toCharArray();

            for (int i = srartIndex,j = endIndex; i < j; i++,j--) {
                char temp = c[i];
                c[i] = c[j];
                c[j] = temp;
            }

            return new String(c);
        }
        return null;
    }
    //方式二:String的拼接
    public static String reverse1(String str,int srartIndex,int endIndex) {
        if (str != null && srartIndex < endIndex) {
            String reverseStr = str.substring(0,srartIndex);
            for (int i = endIndex; i >= srartIndex ; i--) {
                reverseStr += str.charAt(i);
            }
            reverseStr += str.substring(endIndex + 1);
            return reverseStr;
        }
        return null;
    }
    //方式三
    public static String reverse2(String str,int srartIndex,int endIndex) {
        if (str != null && srartIndex < endIndex) {

            StringBuilder stringBuilder1 = new StringBuilder(str.substring(srartIndex, endIndex + 1)).reverse();
            String s1 = new String(stringBuilder1);
            s1 = str.substring(0,srartIndex) + s1 + str.substring(endIndex + 1);
            return s1;
        }
            return null;
    }
        //获取字符串在另一个字符串中出现的次数
    public static int getCount(String mainStr,String subStr){
        int index;
        int count = 0;
        if (mainStr == null || subStr == null || mainStr.length() < subStr.length()) {
            return 0;
        }else if (mainStr.equals(subStr)) {
            return 1;
        }else {
            while ((index = mainStr.indexOf(subStr)) != -1) {
                count++;
                mainStr = mainStr.substring(index + subStr.length());

            }

            return count;
        }

    }
    //对字符串中字符进行自然顺序排序
    public static void sort(String str){
        char[] c = str.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if ((c[i] >= 'a' && c[i] <='z') || (c[i] >= 'A' && c[i] <='Z')) {

            }
            if (c[i] >= '0' && c[i] <= '9') {

            }


        }
    }
    //获取两个字符串中最大相同子串
    public static String maxSameString(String string1,String string2){

        if (string1 != null && string2 != null) {
//            if (string1.length() >= string2.length()) {
//                 maxstring = string1;
//                 minstring = string2;
//            }else {
//                 maxstring = string2;
//                 minstring = string1;
//            }
            String maxstring = (string1.length() >= string2.length()) ? string1 : string2;
            String minstring = (string1.length() < string2.length()) ? string1 : string2;
            int length = minstring.length();
            for (int i = 0; i < length; i++) {

                for (int x = 0,y = length - i; y <= length; x++,y++) {
                    String subStr = minstring.substring(x,y);
                    if (maxstring.contains(subStr)) {
                        return subStr;
                    }
                }
            }
        }
        return null;
    }
}
