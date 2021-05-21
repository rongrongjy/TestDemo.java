package rongrong.java;

/**
 * @description：用数组创建栈
 * @auther lurongrong
 * @create 2021-03-17 17:32
 */
public class ArrayStackDemo {

}
class ArrayStack{
    private int[] stack;
    private int maxSize;
    private int top = -1;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    public int[] getStack() {
        return stack;
    }

    public void setStack(int[] stack) {
        this.stack = stack;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }
    /**
     * 栈满
     */
    public boolean isFull(){
        return top == maxSize - 1;
    }
    /**
     * 栈空
     */
    public boolean isEmpty(){
        return top == -1;
    }
    /**
     * 入栈
     */
    public void push(int value){
        if (isFull()){
            throw new RuntimeException("栈满了");
        }
        top++;
        stack[top] = value;
    }
    /**
     * 出栈
     */
    public int pop(){
        if (isEmpty()){
            throw new RuntimeException("栈空");
        }
        int value = stack[top];
        top--;
        return value;
    }
    /**
     * 遍历栈
     */
    public void list(){
        if (isEmpty()){
            throw new RuntimeException("栈空");
        }
        for (int i = top; i >=0 ; i--) {
            System.out.printf("stack[%d] = %d\n",i,stack[i]);
        }
    }
}
