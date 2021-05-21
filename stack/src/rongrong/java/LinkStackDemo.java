package rongrong.java;

/**
 * @description：
 * @auther lurongrong
 * @create 2021-03-17 9:40
 */
public class LinkStackDemo {
}
class LinkStack{
    private Node top;
    /**
     * 入栈
     */
    public boolean push(Object obj){
        Node s = new Node(obj);
        return true;
    }
}
class Node{
    public Node next;//指向栈顶元素
    public Object obj;

    public Node(Object obj) {
       this.obj = obj;
    }
    

}
