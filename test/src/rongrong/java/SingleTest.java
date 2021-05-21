package rongrong.java;

/**
 * @description：
 * @auther lurongrong
 * @create 2021-05-07 13:41
 */
public class SingleTest {

}
class
SingletonEH{
    //私有构造器

    private SingletonEH() {
    }
    //内部提供一个当前类的实例
    //此实例也必须静态化
    private static SingletonEH singletonEH = new SingletonEH();
    //提供公共的静态的方法，返回当前类的对象
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