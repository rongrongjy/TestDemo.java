package lurongrong.java;

import org.junit.Test;

import java.io.File;
import java.util.Date;

/**
 * @description：
 * @auther lurongrong
 * @create 2021-02-09 9:24
 */
public  class FileTest {
    @Test
    public void test1(){
        File file1 = new File("file1.txt");
        File file2 = new File("D:\\idea2020.3.1\\IdeaProjects\\HelloWorld", "file2.txt");
        File file3 = new File(file2, "file3.txt");
        File file4 = new File("D:\\idea2020.3.1\\IdeaProjects\\HelloWorld");
        System.out.println(file1.length());
        System.out.println(new Date(file1.lastModified()));
        String[] list = file4.list();
        File[] files = file4.listFiles();
        for(File file:files){
            System.out.println(file);
        }
        for (String str: list) {
            System.out.println(str);
        }
        System.out.println(file2);
        System.out.println(file1);
        System.out.println(file3);

//        file1.createNewFile();
//        file1.mkdir();
//        if (!file1.exists()) {
//            try {
//                file1.createNewFile();
////            } catch (IOException e) {
////                e.printStackTrace();
////            }
//            System.out.println("创建成功");
//        }else{
//            file1.delete();
//            System.out.println("删除成功");
//        }
}
    @Test
    public void test2(){
        File file1 = new File("file1.txt");
        File file2 = new File("D:\\idea2020.3.1\\IdeaProjects\\HelloWorld\\day09-02-2021\\file11.txt");
        file1.renameTo(file2);
        boolean renameTo = file2.renameTo(file1);
        System.out.println(renameTo);
    }
}
