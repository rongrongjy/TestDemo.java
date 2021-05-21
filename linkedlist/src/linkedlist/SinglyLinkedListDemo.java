package linkedlist;

import java.util.Stack;

/**
 * 1）单链表的插入、删除、查找操作；
 * 2）链表中存储的是int类型的数据；
 *
 * Author：Zheng
 */
public class SinglyLinkedListDemo {
    public static void main(String[] args) {
        HeroNode hero1 = new HeroNode(31, "songjiang", "jishiyu");
        HeroNode hero2 = new HeroNode(1, "lujuyi", "jishiyu");

        HeroNode hero3 = new HeroNode(7, "songjiang", "jishiyu");

        HeroNode hero4 = new HeroNode(4, "songjiang", "jishiyu");
        HeroNode hero5 = new HeroNode(52, "songjiang", "jishiyu");
        HeroNode hero6 = new HeroNode(80, "songjiang", "jishiyu");
        HeroNode hero7 = new HeroNode(7, "songjiang", "jishiyu");


        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.add(hero1);
        singleLinkedList.add(hero2);
        singleLinkedList.add(hero3);
        singleLinkedList.add(hero4);
        System.out.println("从尾到头打印单列表*******");
        printList(singleLinkedList.getHead());
        System.out.println("$$$$$$$$$$$$$");
//        System.out.println("偶数中间结点：");
//        System.out.println(midNode(singleLinkedList.getHead()));
        SingleLinkedList singleLinkedList1 = new SingleLinkedList();
        singleLinkedList1.add(hero5);
        singleLinkedList1.add(hero6);
        singleLinkedList1.add(hero7);
        singleLinkedList1.list();


        System.out.println("合并之后的列表：");

        mergeTwoList(singleLinkedList.getHead(),singleLinkedList1.getHead());

//        System.out.println(mergeSortedLists(singleLinkedList.getHead(),singleLinkedList1.getHead()));
//        System.out.println(mergeTwoLists(singleLinkedList.getHead().next,singleLinkedList1.getHead().next));
        System.out.println("%%%%%%%%%%%");

        System.out.println("反转之前的单列表：");
        singleLinkedList.list();
//        reserve(singleLinkedList.getHead());
//        System.out.println("反转之后的单列表：");
//        singleLinkedList.list();

        singleLinkedList1.list();
        System.out.println("中间结点：");
        System.out.println(midNode(singleLinkedList.getHead()));
//        singleLinkedList.insertNode(hero1);
//        singleLinkedList.insertNode(hero2);
//        singleLinkedList.insertNode(hero3);
//        singleLinkedList.insertNode(hero1);
//        singleLinkedList.insertNode(hero4);
//
//        singleLinkedList.list();
//
//        HeroNode hero = new HeroNode(2, "问问", "多少分");
//        singleLinkedList.updata(hero);
//        int size = size(singleLinkedList.getHead());
//        HeroNode res = findLastIndex(singleLinkedList.getHead(),1);
//        System.out.println(res);
//        System.out.println();
//        System.out.print("输出单列表的节点个数：" + size);
//        singleLinkedList.delete(hero1);
//        singleLinkedList.delete(hero2);
//        singleLinkedList.delete(hero3);
//        singleLinkedList.delete(hero4);
//
//
//
//        System.out.println("***");
//        singleLinkedList.list();



    }
    /**
     *
     */
    /**
     * 从尾到头打印单链表
     */
    public static void printList(HeroNode head){
        Stack<HeroNode> stack = new Stack<>();
        if (head.next == null){
            return;
        }
        HeroNode temp = head.next;
        while (temp !=null){
            stack.push(temp);
            temp = temp.next;
        }
        while (stack.size() > 0){
            System.out.println(stack.pop());
        }
    }
    /**
     * 合并两个列表
     */


    public static HeroNode mergeTwoLists(HeroNode l1, HeroNode l2) {
        HeroNode soldier = new HeroNode(0,"",""); //利用哨兵结点简化实现难度 技巧三
        HeroNode p = soldier;
        l1 = l1.next;
        l2 = l2.next;
        while ( l1 != null && l2 != null ){
            if ( l1.no <= l2.no ){
                p.next = l1;
                l1 = l1.next;
            }
            else{
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }

        if (l1 != null) { p.next = l1; }
        else { p.next = l2; }
        return p.next;
    }
    public static HeroNode mergeSortedLists(HeroNode la, HeroNode lb) {
         if (la == null) return lb;
         if (lb == null) return la;

        HeroNode p = la;
         HeroNode q = lb;
         HeroNode head ;
         if (p.no < q.no) {
           head = p;
           p = p.next;
         } else {
           head = q;
           q = q.next;
         }
         HeroNode r = head;

         while (p != null && q != null) {
           if (p.no < q.no) {
             r.next = p;
             p = p.next;
           } else {
             r.next = q;
             q = q.next;
           }
           r = r.next;
         }

         if (p != null) {
           r.next = p;
         } else {
           r.next = q;
         }

         return head.next;
        }

    private static void mergeTwoList(HeroNode l1, HeroNode l2){

        HeroNode node = new HeroNode(0,"","");
       // HeroNode node = p;
        HeroNode head ;
        if (l1.next.no<= l2.next.no){
            head = l1;
        }else {
            head = l2;
        }
        l1 = l1.next;
        l2 = l2.next;
        while(l1 != null && l2 != null){

            if(l1.no <= l2.no){
                node.next = l1;
                l1 = l1.next;
            }
            else {
                node.next = l2;
                l2 = l2.next;
            }
            node = node.next;
        }
//        while (l1 != null){
//            node.next = l1;
//            l1 = l1.next;
//        }
//        while (l2 != null){
//            node.next = l2;
//            l2 = l2.next;
//        }
        if(l1 != null ){
            node.next = l1;
        }else if(l2 != null ){
            node.next = l2;
        }
        HeroNode cur = head.next;
        while (cur != null){
//            if (cur.no <= cur.next.no) {
                System.out.println(cur);
//            }
            cur = cur.next;

        }
    }

/*
    public static HeroNode mergeTwoList(HeroNode head1,HeroNode head2){
        if (head1.next == null && head2 == null){
            return null;
        }
        if (head1.next == null && head2 != null){
            return head2;
        }
        if (head1.next != null && head2 == null){
            return head1;
        }
        HeroNode cur = head1.next;
        HeroNode temp = null;
        while (cur != null){
            temp = cur;
            cur = cur.next;
        }
        HeroNode curr = temp;
        HeroNode temp1 = head2.next;
        temp1.next = curr.next;
        return head1.next;
    }
    */


    /**
     * 反转单链表
     * @param head
     */
    public static void reserve(HeroNode head){
        if (head.next == null || head.next.next == null){
            return;
        }
        HeroNode newList = new HeroNode(0,"","");
        HeroNode cur = head.next;
        HeroNode next = null;//cur的下一个节点
        while (cur != null){
            next = cur.next;
            cur.next = newList.next;
            newList.next = cur;
            cur = next;
        }
        head.next = newList.next;
    }
    /**
     * 求中间结点
     */
    public static HeroNode midNode(HeroNode head){

        if (head.next == null){
            return null;
        }
        HeroNode temp = head.next;
        if (size(head) / 2 != 0){
            for (int i = 1; i < (size(head)+1)/2; i++) {
                temp = temp.next;
            }
            return temp;
        }else {
            for (int i = 1; i <= (size(head)+1)/2; i++) {
                temp = temp.next;
            }
            return temp ;
        }

    }

    /**
     *  求倒数第k个节点
     * @param head
     * @param index
     * @return
     */
    public static HeroNode findLastIndex(HeroNode head,int index){
        if (head.next == null){
            return null;
        }
        int size = size(head);
        if (index < 0 || index >size){
            return null;
        }

        HeroNode temp = head.next;
        for (int i = 0; i < size - index; i++) {
            temp = temp.next;
        }
        return temp;

    }

    /**
     * 求单列表中节点的个数
     */

    public static int size(HeroNode head){
        if (head.next == null){
            return 0;
        }
        HeroNode temp = head.next;
        int size = 0;
        while (temp != null){

            size++;
            temp = temp.next;

        }
        return size;
    }


}
/**
 * 定义SingleLinkedList管理英雄
 */
class SingleLinkedList{
    //先初始化一个头节点，头结点不要动，不存放具体的数据
    private HeroNode head = new HeroNode(0,"","");


    public HeroNode getHead() {
        return head;
    }


    /**
     * 删除节点
     */
    public boolean delete(HeroNode heroNode){
        if (isEmpty()){
            System.out.println("空");
            return false;
        }
        HeroNode temp = head;
        boolean flog = false;
        while (true){
            if (temp.next.no == heroNode.no){
                flog = true;
                break;
            }
            if (temp.next == null){
                break;
            }
            temp = temp.next;
        }
        if (flog){
            temp.next = temp.next.next;
            return true;
        }else {
            System.out.println("wu");
        }
        return false;
    }
    /**
     * 插入节点
     */
    public void insertNode(HeroNode heroNode){
        HeroNode temp = head;
        boolean flog = false;
        while (true){
            if (temp.next == null){
                break;
            }
            if (temp.next.no > heroNode.no) {

                break;
            }else if (temp.next.no == heroNode.no){
                flog = true;
                break;
            }
            temp = temp.next;
        }
        if (flog){
            System.out.printf("%d已存在\n",heroNode.no);
        }else {
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    /**
     * 判断列表是否为空
     */
    public boolean isEmpty(){
        return head.next == null;
    }
    /**
     *修改节点的信息，根据节点的no来修改，即no不变
     */
    public void updata(HeroNode newHeroNode){
        if (isEmpty()){
            System.out.println("空");
            return;
        }
        HeroNode temp = head.next;
        boolean flog = false;
        while (true){
            if (temp == null){
                break;
            }
            if (temp.no == newHeroNode.no){
                flog = true;
                break;
            }
            temp = temp.next;
        }
        if (flog){
            temp.name = newHeroNode.name;
            temp.nickname = newHeroNode.nickname;
        }else {
            System.out.println("无");
        }

    }
    //第二种方式在添加英雄时，根据排名将英雄插入到指定位置
    //(如果有这个排名，则添加失败，并给出提示--->flag)
    public void add(HeroNode heroNode) {
        HeroNode temp = head;
        boolean flag = false;
        //找temp的位置,位于添加的前一个结点
        while (true){
            if (temp.next==null){
                break;
            }
            if (temp.next.no > heroNode.no){//位置找到
                break;
            }else if (temp.next.no == heroNode.no){//位置找到
                flag = true;
                break;
            }

            temp = temp.next;
        }
        if (flag){
            System.out.printf("该%d号英雄已存在,无法插入\n",heroNode.no);
        }else{
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }




    /**
     * 显示列表
     */
    public void list(){
        if (head.next == null){
            System.out.println("空");
            return;
        }
        HeroNode temp = head.next;
        while (temp != null){
            System.out.println(temp);
            temp = temp.next;
        }
//        while (true){
//            if (temp == null) {
//                break;
//            }
//
//            System.out.println(temp);
//            temp = temp.next;
//        }
    }
}

/**
 * 定义HeroNode，每个HeroNode对象就是一个节点
 */
class HeroNode{
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;//指向下一个节点

    //构造器
    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    //显式方便

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname ;
    }

}