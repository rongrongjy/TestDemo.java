package rongrong.java;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @description：了解类的加载器
 * @auther lurongrong
 * @create 2021-05-07 10:21
 */
public class ClassLoaderTest {
    @Test
    public void test1(){
        //对于自定义类使用系统类加载器进行加载
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        System.out.println(classLoader);
        ClassLoader parent = classLoader.getParent();
        ClassLoader parent1 = parent.getParent();
        ClassLoader classLoader1 = String.class.getClassLoader();
        System.out.println(classLoader);
        System.out.println(parent);
        System.out.println(parent1);
        System.out.println(classLoader1);
    }
    /*
    Properties:用来读取配置文件
     */
    @Test
    public void test2(){
        Properties properties = new Properties();
//        try {
//            FileInputStream fileInputStream = new FileInputStream("src\\jdbc1.properties");
//            properties.load(fileInputStream);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        try {
            ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
            InputStream resourceAsStream = classLoader.getResourceAsStream("jdbc1.properties");
            properties.load(resourceAsStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        System.out.println("user = " + user + ", password = " + password);
    }


}
