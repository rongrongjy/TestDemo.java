package lurongrong.java;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * @description：
 * @auther lurongrong
 * @create 2021-02-14 8:47
 */
public class FileTest1 {
    @Test
    public void test1() {
        File file = new File("D:\\idea2020.3.1\\IdeaProjects\\HelloWorld\\day14-02-2021\\file");

        if(file.mkdir()){
            System.out.println("创建成功");
        }
        File file1 = new File("D:\\idea2020.3.1\\IdeaProjects\\HelloWorld\\day14-02-2021\\file1");
        if(file1.mkdirs()){
            System.out.println("创建成功1");
        }


    }

    @Test
    public void test2() throws IOException {
        File file1 = new File("file1.txt");
        if (file1.exists()) {
//            try {
                file1.createNewFile();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
            System.out.println("创建成功");

        }else {
            file1.delete();
            System.out.println("删除成功");
        }
    }
    @Test
    public void test3(){
        File file3 = new File("file3");
        if (!file3.exists()) {
            try {
                file3.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("创建成功");
        }else {
            file3.delete();
            System.out.println("删除成功");
        }
    }
    @Test
    public void test4(){
        File file4 = new File("C:\\Users\\Dell\\Pictures");
        String[] list = file4.list();
        for(String str:list){
            if(str.endsWith(".jpg")){
                System.out.println(str);
            }
        }
    }
    @Test
    public void test5(){
        File file5 = new File("D:\\idea2020.3.1\\IdeaProjects\\HelloWorld\\day14-02-2021");

        String[] list = file5.list();

        for(String files:list){
            System.out.println(files);
        }


    }

    public static void main(String[] args) {
        File file5 = new File("D:\\idea2020.3.1\\IdeaProjects\\HelloWorld\\day14-02-2021");

//        String[] list = file5.list();
//
//        for(String files:list){
//            System.out.println(files);
//        }
//
        printSubFile(file5);
    }

    private static void printSubFile(File file5) {
        File[] files = file5.listFiles();
        for(File f:files){
            if(f.isDirectory()){
                printSubFile(f);
            }else {
                System.out.println(f.getAbsolutePath());
            }
        }


    }
}
