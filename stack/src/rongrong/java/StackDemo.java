package rongrong.java;

import java.util.Arrays;

/**
 * @description：栈
 * @auther lurongrong
 * @create 2021-03-17 8:24
 */
public class StackDemo {
    public static void main(String[] args) {
        Stack stack = new Stack(10);
        stack.push("0");
        stack.push("1");
        stack.push("2");
//        System.out.println(stack);
        String p1 = stack.pop();
        System.out.println(p1);
//        stack.show();
        for (int i = 0; i <= stack.getCount(); i++) {
            System.out.println(stack.pop());
        }
    }
}
class Stack{
    private String[] items;//创建一个数组
    private int count;//栈中元素的个数
    private int n;//栈的大小

    public int getCount() {
        return count;
    }

    /**
     * 初始化数组，创建一个·大小为n的数组
     * @param n 栈的大小
     */
    public Stack(int n) {
        this.items = new String[n];
        this.count = 0;
        this.n = n;
    }

    /**
     * 入栈
     */
    public boolean push(String str){
        if (count == n){
            return false;
        }
        items[count] = str;
        ++count;
        return true;
    }
    /**
     * 出栈
     */
    public String pop(){
        if (count == 0){
            return null;
        }
        String temp = items[count-1];
        --count;
        return temp;
    }
    /**
     * 显示栈
     */
    public void show(){
        int c = items.length;
        while (c >= 0){
            System.out.println(items[c-1]);
            c--;
        }
    }
    @Override
    public String toString() {
        return "Stack{" +
                "items=" + Arrays.toString(items) +

                '}';
    }
}
