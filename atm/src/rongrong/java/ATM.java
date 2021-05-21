package rongrong.java;

import java.util.Scanner;

/**
 * @description：
 * @auther lurongrong
 * @create 2021-03-06 14:34
 */
public class ATM {

    private BankCard bankCard;//银行卡
    private Bank bank;//银行
    private double money;
    private int id;
    private int password;

    public ATM() {
        bank = new Bank();
    }

    /**
     * 登录
     */
    public void login(int id, int password) {
        if (bank.contains(id, password)) {
            bankCard = bank.getcard(id, password);
            start2();
        }else {
            System.out.println("账号密码错误！");
        }
    }
    /**
     * 注册
     */
    public boolean register(int id,int password){
        if (bank.contains(id, password)){
            System.out.println("账号已经被注册！");
            return false;
        }
        BankCard bankCard = new BankCard(id,password);
        bank.add(bankCard);
        System.out.println("注册成功！");
        return true;
    }

    /**
     * 登录之前的菜单页面
     */
    public void start() {
        while (true) {
            System.out.println("1.登录 2.注册 3.退出");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            if (choice == 3) {
                break;
            }
            System.out.println("请输入账号：");
            int id = scanner.nextInt();
            System.out.println("请输入密码：");
            int password = scanner.nextInt();
            switch (choice) {
                case 1:
                    login(id, password);
                    break;
                case 2:
                    register(id, password);
                    break;
            }
        }
    }

    /**
     * 登陆之后的菜单页面
     */
    public void start2() {
        while (true) {
            int id1;
            System.out.println("1.存款 2.取款 3.转账 4.查询 5.退卡");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            if (choice == 5) {
                break;
            }
            switch (choice) {
                case 1://存款
                    System.out.println("请输入存款金额：");
                    money = scanner.nextDouble();
                    bank.deposite(bankCard, money);
                    System.out.println("存款成功！");
                    break;
                case 2://取款
                    System.out.println("请输入取款金额：");
                    money = scanner.nextDouble();
                    if (bank.withdrawMoney(bankCard, money)) {
                        System.out.println("取款成功！");
                    }
                    break;
                case 3://转账
                    System.out.println("请输入转账用户的id：");
                    id1 = scanner.nextInt();
                    if (!bank.contains2(id1)) {//检查账号是否注册
                        System.out.println("账号未注册！");
                    } else {
                        System.out.println("请输入转账金额：");
                        money = scanner.nextDouble();
                        if (bank.transferAccounts(bankCard, bank.getcard1(id1), money)) {
                            System.out.println("转账成功！");
                        } else {
                            System.out.println("余额不足，转账失败！");
                        }
                    }
                case 4://查询余额
                    System.out.println("余额为：" + bank.queryAccounts(bankCard));
            }
        }
    }

}

