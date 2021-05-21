package rongrong.java;

import java.util.Scanner;

/**
 * @description：
 * @auther lurongrong
 * @create 2021-04-03 16:55
 */
public class HashtableDemo {
    public static void main(String[] args) {
        //创建哈希表
        Hashtable hashtable = new Hashtable(5);
        //下一个简单的菜单
        String key = "";//从键盘上输入的值
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("add: 添加员工");
            System.out.println("list:显示员工");
            System.out.println("find:找到员工");
            System.out.println("exit:退出系统");

            key = scanner.next();

            switch (key){
                case "add":
                    System.out.println("输入id");
                    int id = scanner.nextInt();
                    System.out.println("输入姓名");
                    String name = scanner.next();
                    //创建员工
                    Emp emp = new Emp(id,name);
                    hashtable.add(emp);
                    break;
                case "find":
                    System.out.println("输入要查找的id");
                    id = scanner.nextInt();
                    hashtable.findEmp(id);
                    break;
                case "list":
                    hashtable.list();
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);
//                break;
                default:
                    break;
            }
        }
    }
}

/**
 * 创建员工
 */
class Emp{
    public int id;//员工号
    public String name;//员工姓名
    public Emp next;//默认为空

    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
/**
 * 创建EmpLinkedList,表示链表，存储员工
 */
class EmpLinkedList{
    //头指针，执行第一个Emp，因此我们这个链表的head是直接指向第一个Emp
    private Emp head;//默认为空
    //添加员工到链表
    //说明
    //假定，当添加员工时，id是自增长，即id的分配总是从小到大
    //因此我们将该员工直接加入到本链表的最后即可
    public void add(Emp emp){
        //如果是添加第一个员工
        if (head==null){
            head = emp;
            return;
        }
        //如果不是第一个员工，则使用一个辅助指针定位到最后
        Emp curEmp = head;//辅助指针
        //寻找最后一个员工
        while (true){
            if (curEmp.next==null){
                break;
            }
            curEmp = curEmp.next;
        }
        curEmp.next = emp;
    }
    /**
     * 遍历链表中员工的信息
     */
    public void list(int no){
        if (head==null){//没有员工
            System.out.println("第" + (no+1) + "条链表为空");
            return;
        }
        System.out.print("第" + (no+1) + "条链表的信息为：");
        Emp curEmp = head;
        while (true){
            System.out.printf("→id=%d name=%s\t",curEmp.id,curEmp.name);
            if (curEmp.next==null){//说明curEmp已经是最后一个员工
                break;
            }
            curEmp=curEmp.next;//后移遍历
        }
        System.out.println();
    }
    /**
     * 根据id查找员工
     */
    public Emp findEmp(int id){
        //判断链表是否为空
        if (head==null){
            System.out.println("链表为空");
            return null;
        }
        //辅助指针
        Emp curEmp = head;
        while (true){
            if (curEmp.id==id){
                break;//这时curEmp就是指向要查找的员工
            }
            if (curEmp.next==null){//说明遍历当前链表没有找到该员工
                curEmp = null;
                break;
            }
            curEmp = curEmp.next;//后移
        }
        return curEmp;
    }
}
/**
 * 创建Hashtable管理多条链表
 */
class Hashtable{
    private EmpLinkedList[] empLinkedListArray;
    private int size;//表示有多少条链表

    public Hashtable(int size) {
        this.size = size;
        //初始化链表及每一条链表
        empLinkedListArray = new EmpLinkedList[size];
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i] = new EmpLinkedList();
        }
    }
    //添加员工
    public void add(Emp emp){
        //根据员工的id，得到该员工应当添加到那条链表
        int empLinkedListNO = hashFun(emp.id);
        //将emp添加到对应的链表中
        empLinkedListArray[empLinkedListNO].add(emp);
    }
    /**
     * 遍历所有的链表，遍历Hashtable
     */
    public void list(){
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i].list(i);
        }
    }
    /**
     * 散列函数,使用简单取模法
     */
    public int hashFun(int id){
        return id % size;
    }
    /**
     * 根据输入的id查找员工
     */
    public void findEmp(int id){
        //使用散列函数确定到要查找的链表
        int empLinkedListNO = hashFun(id);
        Emp emp = empLinkedListArray[empLinkedListNO].findEmp(id);
        if (emp!=null){
            System.out.printf("在第%d条链表中找到员工 id = %d name = %s\n",(empLinkedListNO+1),id,emp.name);

        }else {
            System.out.println("在哈希表中，没有找到该雇员~");
        }
    }
}
class Emp1{
    public int id;
    public String name;
    public Emp next;

    public Emp1(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
class EmpLinkedList1{
    private Emp head;

//    public EmpLinkedList1(Emp head) {
//        this.head = head;
//    }



}
