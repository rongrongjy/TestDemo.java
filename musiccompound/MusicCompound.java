package musiccompound;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @description��
 * @auther lurongrong
 * @create 2021-05-23 17:12
 */
public class MusicCompound {
    public static void main(String args[])
    {
        FileOutputStream fileOutputStream = null;
        FileInputStream fileInputStream = null;
        String fileNames[] = {"E:\\demomusic-java\\ʾ������\\������.mp3","E:\\demomusic-java\\ʾ������\\��ֻ�ں���.mp3"};
//        System.out.println("E:\\demomusic-java\\ʾ������");
        //����byte���飬ÿ����������д���8K������
        byte by[] = new byte[1024*4];
        try
        {
            fileOutputStream = new FileOutputStream("E:/�ϲ�.mp3");
            for(int i=0;i<2;i++)
            {
                int count = 0;
                fileInputStream = new FileInputStream(fileNames[i]);
                //����ǰ��3M�ĸ�������
                fileInputStream.skip(1024*1024*3);
                while(fileInputStream.read(by) != -1)
                {
                    fileOutputStream.write(by);
                    count++;
                    System.out.println(count);
                    //Ҫ��ȡ�м�2MB�����ݣ�ÿ������8k�����ݣ���������Ĵ�����1024*2/8
                    if(count == (1024*2/4))
                    {
                        break;
                    }
                }
            }
        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                //�����ɺ�ر����������
                fileInputStream.close();
                fileOutputStream.close();
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}
