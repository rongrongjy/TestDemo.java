package linkedlist;

/**
 * @description：
 * @auther lurongrong
 * @create 2021-03-11 14:53
 */
class Node {
    private int Data;// 数据域
    private Node Next;// 指针域
    public Node(int Data) {
        // super();
        this.Data = Data;
    }
    public int getData() {
        return Data;
    }
    public void setData(int Data) {
        this.Data = Data;
    }

    public Node getNext() {
        return Next;
    }
    public void setNext(Node Next) {
        this.Next = Next;
    }
    /*
     * 206. 反转链表 反转一个单链表。
     *
     * 示例: 输入: 1->2->3->4->5->NULL 输出: 5->4->3->2->1->NULL
     */

}