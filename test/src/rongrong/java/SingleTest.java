package rongrong.java;

/**
 * @description��
 * @auther lurongrong
 * @create 2021-05-07 13:41
 */
public class SingleTest {

}
class
SingletonEH{
    //˽�й�����

    private SingletonEH() {
    }
    //�ڲ��ṩһ����ǰ���ʵ��
    //��ʵ��Ҳ���뾲̬��
    private static SingletonEH singletonEH = new SingletonEH();
    //�ṩ�����ľ�̬�ķ��������ص�ǰ��Ķ���
    public static SingletonEH getInstance(){
        return singletonEH;
    }

}
class SingletonLH{
    private SingletonLH(){
    }
    private static SingletonLH singletonLH;
    public static SingletonLH getInstance(){
        if (singletonLH == null){
             singletonLH = new SingletonLH();
        }
        return singletonLH;
    }
}