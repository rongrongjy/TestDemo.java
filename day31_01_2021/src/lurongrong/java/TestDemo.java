package lurongrong.java;

import java.util.ArrayList;
import java.util.List;

/**
 * @description：实现一个函数，若出现空格则用%20替换
 * @auther lurongrong
 * @create 2021-03-19 12:49
 */
public class TestDemo {
    public static void main(String[] args) {
        String s = "We are excellent！";
        replace(s," ","%20");
//        System.out.println(s.substring(0,1));
//        chenge(s);
        System.out.println(trans(s,s.length()));

    }

    public static void replace(String str,String str1,String str2){
        String[] strings = str.split("");
        List<String> list = new ArrayList<>();
        for (String item:strings) {
            if (item.matches(" ")){
                list.add("%20");
            }else {
                list.add(item);
            }
        }
        for (String item:list){
            System.out.print(item);
        }

    }
    public static void chenge(String str){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' '){
                list.add(i);
            }
        }
        for (Integer item:list){
            System.out.println(item);
        }
        int i = 0;
        String temp = null;
       while (i < list.size()-1){
            if (list.get(i+1) == list.size()){
                String str1 = str.substring(i,list.get(i));
                String str2 = str.substring(list.get(i+1),str.length());

            }else {
            String str1 = str.substring(i,list.get(i));
            String str2 = str.substring(list.get(i)+1,list.get(i+1));
            temp = str2 + str1;
            i++;
        }}
        System.out.println(temp);
    }

//    public class Solution {
        public static String trans(String s, int n) {
            String res = "";
            String tempStr = "";
            for(int i = 0; i < n; i++){
                char c = s.charAt(i);
                if(c>='a'&& c<='z')
                    tempStr += Character.toUpperCase(c);
                else if(c>='A'&& c<='Z')
                    tempStr += Character.toLowerCase(c);
                else{
                    tempStr = c+tempStr;
                    res = tempStr + res;
                    tempStr="";
                }
            }
            res = tempStr+res;
            return res;
        }
    }

//}

