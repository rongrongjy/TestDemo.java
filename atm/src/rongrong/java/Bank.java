package rongrong.java;

import java.util.Arrays;

/**
 * @description：银行
 * @auther lurongrong
 * @create 2021-03-06 14:35
 */
public class Bank {
    private BankCard[] bankCards;//银行卡
    private int size;//记录银行卡张数
    private static final int INITSIZE = 100;//银行卡初始个数

    public Bank() {
        bankCards = new BankCard[INITSIZE];//初始化
    }

    /**
     * 添加银行卡
     * @param bankCard
     */
    public void add(BankCard bankCard){
        if (bankCards.length == size){
            bankCards = Arrays.copyOf(bankCards,bankCards.length+(bankCards.length>>1));
        }
        bankCards[size] = bankCard;
        size++;
    }
    /**
     * 查询是否存在账户和密码为id和password的银行卡
     */
    public boolean contains(int id,int password){
        for (int i = 0; i < size; i++) {
            if (bankCards[i].getId() == id && bankCards[i].getPassword() == password){
                return true;
            }
        }
        return false;
    }
    /**
     * 查询是否存在账户为id的银行卡
     */
    public boolean contains2(int id){
        for (int i = 0; i < size; i++) {
            if (bankCards[i].getId() == id){
                return true;
            }
        }
        return false;
    }
    /**
     * 输入账号，密码返回银行卡
     */
    public BankCard getcard(int id,int password){
        for (int i = 0; i < size; i++) {
            if (bankCards[i].getId() == id && bankCards[i].getPassword() == password){
                return bankCards[i];
            }
        }
        return null;
    }
    /**
     * 输入账号返回银行卡
     */
    public BankCard getcard1(int id){
        for (int i = 0; i < size; i++) {
            if (bankCards[i].getId() == id){
                return bankCards[i];
            }
        }
        return null;
    }
    /**
     * 存款
     */
    public boolean deposite(BankCard bankCard,double money){
        return bankCard.setMoney(money);
    }
    /**
     * 取款
     */
    public boolean withdrawMoney(BankCard bankCard,double money){
        return bankCard.getMoney(money);
    }
    /**
     * 转账
     */
    public boolean transferAccounts(BankCard bankCard,BankCard bankCard1,double money){
        if (bankCard.getMoney(money)){
            bankCard1.setMoney(money);
            return true;
        }else {
            return false;
        }
    }
    /**
     * 查询余额
     */
    public double queryAccounts(BankCard bankCard){
        return bankCard.getBalance();
    }


}
