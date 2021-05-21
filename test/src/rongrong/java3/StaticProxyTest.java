package rongrong.java3;

/**
 * @description：静态代理举例  特点：代理类和被代理类在编译期间就确定下来了
 * @auther lurongrong
 * @create 2021-05-09 22:46
 */
interface ClothFactory{
    void produceClose();
}
//代理类
class ProxyClothFactory implements ClothFactory{
    private ClothFactory factory;//用被代理类对象进行实例化
    public ProxyClothFactory(ClothFactory factory){
        this.factory = factory;
    }
    @Override
    public void produceClose() {
        System.out.println("代理工厂做一些准备工作。");
        factory.produceClose();
        System.out.println("代理工厂做一些后续的收尾工作。");
    }
}
//被代理类
class LiningClothFactory implements ClothFactory{

    @Override
    public void produceClose() {
        System.out.println("李宁工厂生产一批运动服。");
    }
}
public class StaticProxyTest {
    public static void main(String[] args) {
        //创建被代理类的对象
        LiningClothFactory liningClothFactory = new LiningClothFactory();
        //创建代理类的对象
        ProxyClothFactory proxyClothFactory = new ProxyClothFactory(liningClothFactory);
        proxyClothFactory.produceClose();
    }
}

