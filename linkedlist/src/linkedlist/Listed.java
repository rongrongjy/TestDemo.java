package linkedlist;

/**
 * @description：
 * @auther lurongrong
 * @create 2021-03-09 18:59
 */

public class Listed<T> {
        private class Node {
            private T t;
            private Node next;
            public Node(T t,Node next){
                this.t = t;
                this.next = next;
            }
            public Node(T t){
                this(t,null);
            }
        }
        private Node head;//头结点
        private int size;//链表元素个数
    //构造函数
    public Listed(){
        this.head = null;
        this.size = 0;
    }
}