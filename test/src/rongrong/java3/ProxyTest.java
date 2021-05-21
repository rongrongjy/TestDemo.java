package rongrong.java3;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @description����̬����ľ���
 * @auther lurongrong
 * @create 2021-05-09 21:26
 */
public class ProxyTest {
    public static void main(String[] args) {
        SuperMan superMan = new SuperMan();//�����������
        //proxyInstance:������Ķ���
        Human proxyInstance = (Human) ProxyFactory.getProxyInstance(superMan);
        //��ͨ�������������÷���ʱ�����Զ��ĵ��ñ���������ͬ���ķ���
        String belief = proxyInstance.getBelief();
        System.out.println(belief);
        proxyInstance.eat("���");
    }
}
interface Human{
    String getBelief();
    void eat(String food);
}
//��������
class SuperMan implements Human{

    @Override
    public String getBelief() {
        return "I believe I can fly!";
    }

    @Override
    public void eat(String food) {
        System.out.println("��ϲ����" + food);
    }
}
/*
Ҫ��ʵ�ֶ�̬�����࣬��Ҫ��������⣿
����һ����θ��ݼ��ص��ڴ��еı������࣬��̬�Ĵ���һ�������༰�����
���������ͨ��������Ķ�����÷���ʱ����ζ�̬��ȥ���ñ��������е�ͬ������

 */
class ProxyFactory{
    //���ô˷���������һ��������Ķ��󡢽������һ
    public static Object getProxyInstance(Object obj){//obj:��������Ķ���
        MyInvocationHandler handler = new MyInvocationHandler();
        handler.bind(obj);
        //��һ����������Ӧ��(������)�ļ�����  �ڶ���������ʵ���������ͬ���Ľӿ�  ���ش�����Ķ���
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(),handler);//����һ����������Ķ���
    }
}
class MyInvocationHandler implements InvocationHandler {

    private Object obj;//��Ҫʹ�ñ�������Ķ�����и�ֵ

    public void bind(Object obj){
        this.obj = obj;
    }

    //������ͨ��������Ķ�����÷���aʱ���ͻ��Զ��ĵ������µķ�����invoke()
    //����������Ҫִ�еķ���a�Ĺ��ܾ�������invoke()��
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //method:��Ϊ����������Ӿ�ķ������˷���Ҳ����Ϊ�˱����������Ҫ���õķ���
        //obj����������Ķ���
        Object returnValue = method.invoke(obj, args);
        //���������ķ���ֵ����Ϊ��ǰ���е�invoke()�ķ���ֵ
        return returnValue;
    }
}

