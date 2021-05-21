package linkedlist;

/**
 * @description：
 * @auther lurongrong
 * @create 2021-03-12 15:22
 */
public class DulLinkedListDemo {
    public static void main(String[] args) {
        DulNode dulNode1 = new DulNode(1, 1);
        DulNode dulNode2 = new DulNode(10, 2);
        DulNode dulNode3 = new DulNode(6, 3);
        DulNode dulNode4 = new DulNode(8, 4);
        DulNode dulNode5 = new DulNode(5, 5);
        DulNode dulNode6 = new DulNode(6, 9);

        DulNode dulNode7 = new DulNode(9, 6);
        DulNode dulNode8 = new DulNode(10, 5);
        DulNode dulNode9 = new DulNode(2, 5);



        DulLinkedList linkedList1 = new DulLinkedList();

        linkedList1.add(dulNode1);
        linkedList1.add(dulNode2);
        linkedList1.add(dulNode3);
        linkedList1.add(dulNode5);
        linkedList1.add(dulNode9);


        linkedList1.list();

        System.out.println("修改节点");
        linkedList1.upNode(dulNode4);
        linkedList1.list();
        System.out.println("删除节点");
        linkedList1.delete(dulNode1);
        linkedList1.list();
        DulLinkedList linkedList2 = new DulLinkedList();
        linkedList2.add(dulNode6);
        linkedList2.add(dulNode8);
        linkedList2.add(dulNode7);

        System.out.println("链表二");
        linkedList2.list();
    }
}
class DulLinkedList{
    private DulNode head = new DulNode(0,0);

    public DulNode getHead() {
        return head;
    }

    /**
     * 遍历双向列表
     */
    public void list(){
        if (head.next == null){
            throw new RuntimeException("链表为空");
        }
        DulNode cur = head.next;
        while (cur != null){
            System.out.println(cur);
            cur = cur.next;
        }

    }
    /**
     * 插入法
     */
    public void add(DulNode node){
//        if (head.next == null){
//            throw new RuntimeException("空链表");
//        }
        boolean flog = false;
        boolean flag1 = false;
        DulNode temp = head;
        while (true){
            if (temp.value > node.value){
                break;
            }
            if (temp.next == null){
                flag1 = true;

                break;
            }
            if (temp.value == node.value){
                flog = true;
                break;
            }
            temp = temp.next;
        }
//        temp = temp.next;
        if (flog) {
            System.out.printf("该%d号yi存在,无法插入\n", node.value);
        }else if (flag1){
            temp.next = node;
            node.prior = temp;
        }else {
            node.next = temp;
            temp.prior.next = node;
            node.prior = temp.prior;
            temp.prior = node;
//            temp.prior.next = node;
//            node.next = temp;
//            temp.prior = node;
        }
//        }else if (temp.next != null){
//            temp.prior.next = node;
//            node.next = temp;
//            temp.prior = node;
//        }
//            else {
//            temp.next = node;
//            node.prior = temp;
//            }

//        if (flog){
//
//            node.next = temp.next;
//            temp.next.prior = node;
//            node.prior = temp;
//
//        }
    }

    /**
     * 尾插法
     */
    public void addTail(DulNode newNode){
        DulNode temp = head;
        while (true){
            if (temp.next == null){
                break;
            }
            temp = temp.next;
        }
            temp.next = newNode;
            newNode.prior = temp;
    }
    /**
     * 修改节点
     */
    public void upNode(DulNode newNode){
        if (head.next == null){
            throw new RuntimeException("链表为空");
        }
        DulNode temp  = head.next;
        boolean flog = false;
        while (true){
            if (temp == null){
              break;
            }
            if (temp.value == newNode.value){
                flog = true;
                break;
            }
            temp = temp.next;
        }
        if (flog){
            temp.age = newNode.age;
        }else {
            System.out.printf("%d无",newNode.value);
        }

    }
    /**
     * 删除节点
     */
    public void delete(DulNode node){
        if (head.next == null){
            throw new RuntimeException("空链表");
        }
        DulNode temp = head.next;
        boolean flog = false;
        while (true){
            if (temp == null){
                break;
            }
            if (temp.value == node.value){

                flog = true;
                break;
            }
            temp = temp.next;
        }
        if (flog){
            temp.prior.next = temp.next;
            if (temp.next != null){
                temp.next.prior = temp.prior;
            }
        }else {
            throw new RuntimeException("无");
        }
    }
}


/**
 * 定义节点
 */
class DulNode{
    public int value;
    public int age;
    public DulNode prior;
    public DulNode next;



    public DulNode(int value,int age) {
        this.value = value;
//        this.prior = null;
//        this.next = null;
        this.age = age;
    }

    @Override
    public String toString() {
        return "DulNode{" +
                "value=" + value +
                ", age=" + age  +
                '}';
    }
}
