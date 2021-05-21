package lurongrong.java;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @description：
 * @auther lurongrong
 * @create 2021-02-10 20:24
 */
public class FileStreamTest {
    public static void main(String[] args) {
        FileReader fileReader = null;
        try {
            File file1 = new File("file1.txt");
            File file2 = new File("D:\\idea2020.3.1\\IdeaProjects\\HelloWorld\\day10-02-2021\\file2.txt");
//        File file3 = new File("D:\\idea2020.3.1\\IdeaProjects\\HelloWorld\\file3.txt");
            fileReader = new FileReader(file1);
            int read = fileReader.read();
            while (read != -1){
                System.out.println((char) read);
                read = fileReader.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileReader != null) {

                    fileReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
    }
//    @Test
//    public void test1(){
//        FileReader fileReader = null;
//        try {
//            File file1 = new File("file1.txt");
//            File file2 = new File("D:\\idea2020.3.1\\IdeaProjects\\HelloWorld\\day10-02-2021\\file2.txt");
////        File file3 = new File("D:\\idea2020.3.1\\IdeaProjects\\HelloWorld\\file3.txt");
//            fileReader = new FileReader(file1);
//            int read = fileReader.read();
//            while (read != -1){
//                System.out.println((char) read);
//                read = fileReader.read();
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if (fileReader != null) {
//
//                    fileReader.close();
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        boolean renameTo = file1.renameTo(file3);
//        System.out.println(renameTo);


//        System.out.println(file1.getAbsoluteFile());
//        System.out.println(file1.getName());
//        System.out.println(file1.getFreeSpace());
//        System.out.println(file1.getPath());
//        System.out.println("**************");
//        System.out.println(file1.getParent());
//        System.out.println(file1.getParentFile());
//        System.out.println(file2);
//        System.out.println("**************");
//        String[] list = file2.list();
//        System.out.println(file2.listFiles());
//        System.out.println(file2.getParent());
//
//        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$");
    }
}
