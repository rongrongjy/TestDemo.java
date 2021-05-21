package rongrong.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @description：
 * @auther lurongrong
 * @create 2021-03-24 19:30
 */
public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int n = scanner.nextInt();
            List<Integer> list = new ArrayList<Integer>();
            for(int i = 0;i <= n;i++)
                list.add(i);
            while(list.size() != 1){
                for(int i = 0;i < list.size();i=i+1)
                    list.remove(i);
            }
            System.out.println(list.get(0));
        }
    }
}
