package lurongrong.java;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @description：
 * @auther lurongrong
 * @create 2021-01-31 14:53
 */
public class TimeTest {
    public static void main(String[] args) {
        //实例化SimpleDateFormat
        SimpleDateFormat s1 = new SimpleDateFormat();

        //格式化：日期-->字符串
        Date date = new Date();

        System.out.println(date);
        String format = s1.format(date);
        System.out.println(format);

        //解析：格式化的逆过程，字符串-->日期
        String str = "21-1-31 下午3:18\n";
        try {
            Date date1 = s1.parse(str);
            System.out.println(date1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
        String format1 = simpleDateFormat.format(date);
        System.out.println(format1);
    }
    @Test
    public void testExer() throws ParseException{
        String birth = "1998-04-15";
        SimpleDateFormat sim1 = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sim1.parse(birth);
        java.sql.Date birthDate = new java.sql.Date(date.getTime());
        System.out.println(birthDate);
    }
    @Test
    public void testExer1 (){
        String str =  "2017-08-16";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = format.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        java.sql.Date sql = new java.sql.Date(date.getTime());
        System.out.println(sql);
    }

}
