package rongrong.java;

/**
 * @description：
 * @auther lurongrong
 * @create 2021-04-13 17:04
 */
//package Tree;
public class TestDemo7 {
    public static void main(String[] args) {
        //创建一颗二叉树
        BinaryTree binaryTree=new BinaryTree();
        HeroNode root=new HeroNode(1,"宋江");
        HeroNode node2=new HeroNode(2,"吴用");
        HeroNode node3=new HeroNode(3,"卢俊义");
        HeroNode node4=new HeroNode(4,"林冲");
        HeroNode node5=new HeroNode(5,"关胜");
//创建二叉树
        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);
        binaryTree.setRoot(root);
//测试
        System.out.println("前序遍历");
        binaryTree.preOrder();

        System.out.println("中序遍历");
        binaryTree.infixOrder();

        System.out.println("后序遍历");
        binaryTree.postOrder();
    }

}
//定义二叉树
class BinaryTree{
    private HeroNode root;

    public void setRoot(HeroNode root) {
        this.root = root;
    }



    //前序遍历
    public void preOrder(){
        if(this.root!=null){
            this.root.preOrder();
        }else{
            System.out.println("二叉树为空，无法遍历");
        }
    }
    //中序遍历
    public void infixOrder(){
        if(this.root!=null){
            this.root.infixOrder();
        }else{
            System.out.println("二叉树为空，无法遍历");
        }
    }
    //后序遍历
    public void postOrder(){
        if(this.root!=null){
            this.root.postOrder();
        }else{
            System.out.println("二叉树为空，无法遍历");
        }
    }
}
//创建HeroNode节点
class HeroNode{
    private int no;
    private String name;
    private HeroNode right;//默认为空
    private HeroNode left;//默认为空
    public HeroNode(int no,String name){
        this.no=no;
        this.name=name;
    }
    public int getNo(){
        return  no;
    }
    public void setNo(int no){
        this.no=no;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){

        this.name=name;
    }
    public HeroNode getRight(){

        return right;
    }
    public void setRight(HeroNode right){
        this. right=right;
    }
    public HeroNode getLeft(){

        return left;
    }
    public void setLeft(HeroNode left){

        this.left=left;
    }
    public String toString(){
        return "HeroNode[no="+no+"name "+name;
    }


    //前序遍历
    public void preOrder(){
        //先输出父节点
        System.out.println(this);
        //向左递归左子树前序遍历
        if(this.left!=null){
            this.left.preOrder();
        }
        //向右递归右子树前序遍历
        if(this.right!=null){
            this.right.preOrder();
        }
    }
    //中序遍历
    public void infixOrder(){
        //递归向左子树中序遍历
        if(this.left!=null){
            this.left.infixOrder();
        }
        //输出父节点
        System.out.println(this);
        //递归向右子树中序遍历
        if(this.right!=null){
            this.right.infixOrder();
        }
    }
    //后序遍历
    public void postOrder(){
        //递归向左子树后序遍历
        if(this.left!=null){
            this.left.postOrder();
        }
        //递归向右子树后序遍历
        if(this.right!=null){
            this.right.postOrder();
        }
        //输出父节点
        System.out.println(this);
    }
}

