package rongrong.java;

/**
 * @description：银行卡
 * @auther lurongrong
 * @create 2021-03-06 14:35
 */
public class BankCard {

    private int id;//账号
    private int password;//密码
    private double balance;//余额

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }


    public BankCard(int id, int password) {
        this.id = id;
        this.password = password;
    }

    /**
     * 取钱
     */
    public boolean getMoney(double money){
        if (this.balance >= money){
            this.balance -= money;
            return true;
        }else {
            return false;
        }
    }
    /**
     * 存钱
     */
    public boolean setMoney(double money){
        this.balance += money;
        return true;
    }

}
