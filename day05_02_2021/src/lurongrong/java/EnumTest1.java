package lurongrong.java;

/**
 * @description：
 * @auther lurongrong
 * @create 2021-02-05 23:47
 */
public class EnumTest1 {

        public static void main(String[] args) {
//            Season spring = Season.SPRING;
//            System.out.println(spring.toString());

            Season1[] values = Season1.values();



            for (int i = 0; i < values.length; i++) {
                System.out.println(values[i]);
            }

            System.out.println("************");
            Thread.State[] values1 = Thread.State.values();
            for (int i = 0; i < values1.length; i++) {
                System.out.println(values1[i]);

            }
            Season1 autumn = Season1.valueOf("AUTUMN");
            System.out.println(autumn);

            String s = Season1.AUTUMN.toString();
            System.out.println(s);

            System.out.println("***");
//            Season1.AUTUMN.show();
            Season1.SPRING.show();
        }
}
interface Info{
    public  void show();
}
enum Season1 implements Info{
    SPRING("春天","春暖花开"){
        @Override
        public void show() {
            System.out.println("春天是明媚的");
        }
    },
    SUMMER("夏天","夏日炎炎"){
        @Override
        public void show() {

        }
    },

    AUTUMN("秋天","秋风瑟瑟"){
        @Override
        public void show() {

        }
    },

    WINTER("冬天","冰天雪地"){
        @Override
        public void show() {

        }
    };

    //1.声明Season对象的属性：private final修饰
    private final String seasonName;
    private final String seasonDesc;

    private Season1(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }


    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

    @Override
    public String toString() {
        return "Season1{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }

//    @Override
//    public void show() {
//        System.out.println("Season1.values()");
//    }

    /**
     * @description：自定义枚举类
     * @auther lurongrong
     * @create 2021-02-05 23:29
     */

}