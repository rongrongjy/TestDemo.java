package rongrong.java3;

/**
 * @description����̬�������  �ص㣺������ͱ��������ڱ����ڼ��ȷ��������
 * @auther lurongrong
 * @create 2021-05-09 22:46
 */
interface ClothFactory{
    void produceClose();
}
//������
class ProxyClothFactory implements ClothFactory{
    private ClothFactory factory;//�ñ�������������ʵ����
    public ProxyClothFactory(ClothFactory factory){
        this.factory = factory;
    }
    @Override
    public void produceClose() {
        System.out.println("��������һЩ׼��������");
        factory.produceClose();
        System.out.println("��������һЩ��������β������");
    }
}
//��������
class LiningClothFactory implements ClothFactory{

    @Override
    public void produceClose() {
        System.out.println("������������һ���˶�����");
    }
}
public class StaticProxyTest {
    public static void main(String[] args) {
        //������������Ķ���
        LiningClothFactory liningClothFactory = new LiningClothFactory();
        //����������Ķ���
        ProxyClothFactory proxyClothFactory = new ProxyClothFactory(liningClothFactory);
        proxyClothFactory.produceClose();
    }
}

