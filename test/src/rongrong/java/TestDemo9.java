package rongrong.java;

import java.util.Scanner;

/**
 * @description：
 * @auther lurongrong
 * @create 2021-05-18 21:37
 */

// Definition for singly-linked list.
 public class TestDemo9 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListNode headA  = null ;
        ListNode headB = null;
        System.out.print("请从键盘读入链表A的大小：");
        int n = scanner.nextInt();
        int a[] = new int[n];
        System.out.print("输入A的值：");
        for (int i = 0; i < n; i++) {
            Scanner input = new Scanner(System.in);
            a[i] = input.nextInt();
            headA = new ListNode(a[i]);
            if (headA.next != null){

                headA = headA.next;
            }

        }
//       for(ListNode l:headA){
//
//       }
        System.out.print("请从键盘读入链表B的大小：");

        int m = scanner.nextInt();
        int b[] = new int[n];
        System.out.print("输入B的值：");

        for (int i = 0; i < m; i++) {
//            if (b.length < m) {
                Scanner input = new Scanner(System.in);
                b[i] = input.nextInt();
                headB = new ListNode(b[i]);
                if (headB.next != null){

                    headB = headB.next;
                }
//            }
        }

        ListNode listNode = getIntersectionNode(headA, headB);
        System.out.println(listNode);
    }


    public static ListNode  getIntersectionNode(ListNode headA,ListNode headB){
        int lenA=length(headA), lenB=length(headB);
        while (lenA != lenB){
            if(lenA>lenB){
                headA=headA.next;
                lenA--;
            }else {
                headB=headB.next;
                lenB--;
            }
        }
        while (headA!=headB){

            headA=headA.next;
            headB=headB.next;
        }
        return headA;
    }

    public  static int length(ListNode node){
        int length=0;
        while(node.next!=null){
            length++;
            node=node.next;
        }
        return length;
    }


}
class ListNode{
    public int val;
    public ListNode next;
    ListNode(int x){
        val=x;
        next=null;
    }

//    public void addNode(int i) {
//        ListNode a = new ListNode(i);
//    }
}



