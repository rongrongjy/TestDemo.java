package linkedlist;

/**
 * @description：约瑟夫环问题
 * @auther lurongrong
 * @create 2021-03-13 17:28
 */
public class Josepfu {
    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addKid(5);
        circleSingleLinkedList.showKid();
        circleSingleLinkedList.countKis(1,2,5);
    }
}

/**
 * 创建环形单向链表
 */
class CircleSingleLinkedList{
    private Kid first = null;

    /**
     * 添加小孩节点
     * @param nums：小孩的总数
     */
    public void addKid(int nums){
        //数据校验
        if (nums < 1){
            System.out.println("输入的数据有误");
            return;
        }
        Kid curKid = null;//辅助指针，帮助构建环形链表
        //使用for创建环形链表
        for (int i = 1; i <= nums; i++) {
            Kid kid = new Kid(i);//根据编号创建小孩节点
            //如果是第一个小孩
            if (i == 1) {
                first = kid;
                first.setNext(first);//构成环
                curKid = first;//让curKid指向第一个小孩
            }else {
                curKid.setNext(kid);
                kid.setNext(first);
                curKid = kid;
            }
        }

    }
    /**
     * 遍历当前的环形列表
     */
    public void showKid(){
        //判断链表是否为空
        if (first == null){
            System.out.println("链表为空");
            return;
        }
        //因为first不能动，因此我们仍然使用一个指正完成遍历
        Kid curKid = first;
        while (true){
            System.out.printf("小孩的编号%d\n",curKid.getId());
            if (curKid.getNext() == first){//遍历完毕
                break;
            }
            curKid = curKid.getNext();
        }
    }

    /**
     * 根据用户的输入，计算小孩的出拳顺序
     * @param startId：表示从第几个小孩开始计数
     * @param countNum：表示数几下
     * @param nums：表示最初小孩的个数
     */
    public void countKis(int startId,int countNum,int nums){
        //对数据进行校验
        if (first == null || startId < 1 || startId > nums){
            System.out.println("数据有误");
            return;
        }
        //创建辅助指正，帮助完成小孩完成出圈
        Kid helper = first;
        //创建一个辅助指针（变量）helper，事先指向环形链表的最后的节点
        while (true){
            if (helper.getNext() == first){//说明helper指向最后的小孩节点
                break;
            }
            helper = helper.getNext();
        }
        //小孩报数钱，先让first和helper移动k-1次
        for (int i = 0; i < startId-1; i++) {
            first = first.getNext();
            helper = helper.getNext();
        }
        //当小孩报数是，让helper和first指针同时移动m-1次，然后出圈
        //这里是一个循环操作，知道圈中只有一个节点
        while (true){
            if (helper == first){
                break;
            }
            for (int i = 0; i < countNum -1; i++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            System.out.printf("小孩%d出圈\n",first.getId());
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.printf("最后留在权重的小孩编号%d\n",first.getId());
    }
}

/**
 * 定义孩子节点
 */
class Kid{
    private int id;
    private Kid next;

    public Kid(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Kid getNext() {
        return next;
    }

    public void setNext(Kid next) {
        this.next = next;
    }
}
