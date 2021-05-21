package rongrong.java;

/**
 * @description：
 * @auther lurongrong
 * @create 2021-04-11 15:17
 */
public class ThreadedBinaryTreeDemo {
    public static void main(String[] args) {
        //测试中序线索二叉树的功能
        HeroNode root = new HeroNode(1, "Tom");
        HeroNode node2 = new HeroNode(3, "Jack");
        HeroNode node3 = new HeroNode(6, "Smith");
        HeroNode node4 = new HeroNode(8, "Mary");
        HeroNode node5 = new HeroNode(10, "King");
        HeroNode node6 = new HeroNode(14, "Dim");
        //二叉树，后面我们要递归创建，现在简单处理使用手动创建
        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);
        //测试中序线索化
        ThreadedBinaryTree threadedBinaryTree = new ThreadedBinaryTree();
        threadedBinaryTree.setRoot(root);
        threadedBinaryTree.threadedNodes();
        //当线索二叉树后，不能在使用原来的遍历方法
        System.out.println("使用线索化的方式遍历，线索化二叉树");
        threadedBinaryTree.threadedList1();
    }
}
//定义TreadedBinaryTree实现了线索化功能的二叉树
class ThreadedBinaryTree{
    private HeroNode root;
    //为了实现线索化，需要创建要指向当前节点的前驱节点的指针
    //在递归进行线索化时，pre总是保留前一个节点
    private HeroNode pre = null;

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    //重载一把treadedNode方法
    public void threadedNodes(){
        this.threadedNodes(root);
    }
    //遍历线索化二叉树的方法
    public void threadedList(){
        //定义一个变量，存储当前遍历的节点，从root开始
        HeroNode node = root;
        while (node != null){
            //循环的找到leftType==1的节点
            //后面随着遍历而变化，因为当leftType==1时，说明该节点是按照线索化
            //处理后的有效节点
            while (node.getLeftType()==0){
                node = node.getLeft();
            }
            //打印当前这个节点
            System.out.println(node);
            //如果当前节点的右指针指向的是后继节点，就一直输出
            while (node.getRightType()==1){
                //获取到当前节点的后继节点
                node = node.getRight();
                System.out.println(node);
            }
            //替换这个遍历的节点
            node  = node .getRight();
        }
    }
    //编写对二叉树进行中序线索化的方法

    /**
     *
     * @param node 就是当前需要线索化的节点
     */
    public void threadedNodes(HeroNode node){
        //如果node==null，不能线索化
        if (node ==null){
            return;
        }
        //①先线索化左子树
        threadedNodes(node.getLeft());
        //②线索化当前节点
        //处理当前节点的前驱节点
        if (node.getLeft()==null){
            //让当前节点的左指针指向前驱节点
            node.setLeft(pre);
            //修改当前节点的左指针的类型，指向前驱节点
            node.setLeftType(1);
        }
        //处理后继节点
        if (pre!=null && pre.getRight()==null){
            //让前驱节点的右指针指向当前节点
            pre.setRight(node);
            //修改前驱节点的右指针类型
            pre.setRightType(1);
        }
        //每处理一个节点后，让当前节点是下一个节点的前驱节点
        pre= node;
        //③再线索化右子树
        threadedNodes(node.getRight());
    }
//遍历线索化二叉树的方法
    public void threadedList1(){
        //定义一个变量，存储当前遍历的节点，从root开始
        HeroNode node = root;
        while (node != null){
            //循环的找到leftType==1的节点
            //后面随着遍历而变化，因为当leftType==1时，说明该接待是按照线索化
            //处理后的有效节点
            while (node.getLeftType() == 0){
                node  = node.getLeft();
            }
            //打印当前这个节点
            System.out.println(node);
            //如果当前节点的右指针指向的是后继节点，就一直输出
            while (node.getRightType()==1){
                //获取到当前节点的后继节点
                node = node.getRight();
                System.out.println(node);
            }
            //替换这个遍历的节点
            node = node.getRight();
        }
    }
}
