package rongrong.java1;

import java.io.Serializable;

/**
 * @description：
 * @auther lurongrong
 * @create 2021-05-07 10:47
 */
public class Creature<T> implements Serializable {
    private char gender;
    public double weight;

    private void breath(){
        System.out.println("生物呼吸");
    }
    public void eat(){
        System.out.println("生物吃东西");
    }

}
