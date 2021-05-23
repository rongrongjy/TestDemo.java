package rongrong.java;

/**
 * @description：
 * @auther lurongrong
 * @create 2021-04-05 13:57
 */
public class BinaryTreeDemo1{
    public static void main(String[] args) {
        BinaryTree1 BinaryTree1 = new BinaryTree1();
        HeroNode root = new HeroNode(1, "宋江");
        HeroNode node2 = new HeroNode(2, "吴用");
        HeroNode node3 = new HeroNode(3, "卢俊义");
        HeroNode node4 = new HeroNode(4, "林冲");
        //手动创建二叉树
        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        BinaryTree1.setRoot(root);
        //测试
//
//        System.out.println("前序遍历");
//        BinaryTree1.preOrder();
//        System.out.println("中序遍历");
//        BinaryTree1.infixOrder();
//        System.out.println("后序遍历");
//        BinaryTree1.postOrder();
//        System.out.println("前序遍历查找结果显示：");
//        HeroNode search = BinaryTree1.infixOrderSearch(4);
//        System.out.println(search);
        System.out.println("删除前前序遍历：");
        BinaryTree1.preOrder();
        BinaryTree1.delNode(3);
        System.out.println("删除后前序遍历：");
        BinaryTree1.preOrder();
    }
}
class BinaryTree1{
    private HeroNode root;

    public void setRoot(HeroNode root) {
        this.root = root;
    }
    public void preOrder(){
        if (this.root != null){
            this.root.preOrder();
        }else {
            System.out.println("二叉树为空，无法遍历");
        }
    }
    public void infixOrder(){
        if (this.root != null){
            this.root.infixOrder();
        }else {
            System.out.println("二叉树为空，无法遍历");
        }
    }
    public void postOrder(){
        if (this.root != null){
            this.root.postOrder();
        }else {
            System.out.println("二叉树为空，无法遍历");
        }
    }
    public HeroNode preOrderSearch(int no){
        if (root != null){
            return root.preOrderSearch(no);
        }else {
            return null;
        }
    }
    public HeroNode infixOrderSearch(int no){
        if (root != null){
            return root.infixOrderSearch(no);
        }else {
            return null;
        }
    }
    public HeroNode postOrderSearch(int no){
        if (root != null){
            return root.infixOrderSearch(no);
        }else {
            return  null;
        }
    }
    /**
     * 删除节点
     */
    public void delNode(int no){
        if (root != null){
            //如果只有一个根节点，立即判断根节点是否是要删除的节点，
            if (root.getNo() == no){
                root = null;
            }else {
                root.delNode(no);
            }
        }else {
            System.out.println("树为空，无法删除！");
        }
    }

}
class HeroNode{
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;
    //说明
    //如果leftType==0表示指向的是左子树，如果1则指向前驱节点
    //如果rightType==0表示指向的是右子树，如果1则指向后继节点
    private int leftType;
    private int rightType;

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name  +
                '}';
    }
    //遍历结点
    /**
     * 前序遍历
     */
    public void preOrder(){
        System.out.println(this);
//        if (this == null){
//            return;
//        }
//        this.left.preOrder();
//        this.preOrder();
        if (this.left != null){
            this.left.preOrder();
        }
        if (this.right != null){
            this.right.preOrder();
        }
    }
    /**
     * 中序遍历
     */
    public void infixOrder(){
        if (this.left != null){
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null){
            this.right.infixOrder();
        }
    }
    /**
     * 后序遍历
     */
    public void postOrder(){
        if (this.left != null){
            this.left.postOrder();
        }
        if (this.right != null){
            this.right.postOrder();
        }
        System.out.println(this);
    }
    //遍历查找
    /**
     * 前序遍历查找
     */
    public HeroNode preOrderSearch(int no){
        if (this.no == no){
            return this;
        }
        HeroNode resNode = null;
        if (this.left != null){
            resNode = this.left.preOrderSearch(no);
        }
        if (resNode != null){
            return resNode;
        }
        if (this.right != null){
            resNode = this.right.preOrderSearch(no);
        }
        return resNode;
    }
    /**
     * 中序遍历查找
     */
    public HeroNode infixOrderSearch(int no){
        HeroNode resNode = null;
        if (this.left != null){
            resNode = this.left.infixOrderSearch(no);
        }
        if (resNode != null){
            return resNode;
        }
        if (this.no == no){
            return this;
        }
        if (this.right != null){
            resNode = this.right.infixOrderSearch(no);
        }
        return resNode;

    }
    /**
     * 后序遍历查找
     */
    public HeroNode postOrderSearch(int no){
        HeroNode resNode = null;
        if (this.left != null){
            resNode = this.left.postOrderSearch(no);
        }
        if (resNode != null){
            return  resNode;
        }
        if (this.right != null){
            resNode = this.right.postOrderSearch(no);
        }
        return resNode;
    }
    /**
     * 递归删除节点
     * 1.如果删除的节点是叶子节点，则删除该节点
     * 2.如果删除的节点是飞叶子节点，则删除该子树
     */
    public void delNode(int no){
        /*
        思路：
        1.因为二叉树是单向的所以我们是判断当前节点的子节点是否是需要删除的节点
        而不能判断当前节点是否是要删除的节点
        2.如果当前节点的左节点不为空，且左节点就是要删除的节点，则删除
        该节点，就将this.left=null；并且就返回（结束递归删除）
        3.如果当前节点的右节点不为空且是要删除的节点，则删除该节点，就将this.right=null
        并且就返回（结束递归删除）
        4.如果2.3都没找到要删除的节点，就要像左子树进项递归删除
        5.如果第4步也没有删除节点，那么久像当前节点的右子树进行递归删除

         */
        //2.如果当前节点的左节点不为空，且左节点就是要删除的节点，则删除
        //        该节点，就将this.left=null；并且就返回（结束递归删除）
        if (this.left != null && this.left.getNo() == no){
            this.left = null;
            return;
        }
        if (this.right != null && this.right.getNo() == no){
            this.right = null;
            return;
        }
        if (this.left != null){
            this.left.delNode(no);
        }
        if (this.right != null){
            this.right.delNode(no);
        }
    }
}
