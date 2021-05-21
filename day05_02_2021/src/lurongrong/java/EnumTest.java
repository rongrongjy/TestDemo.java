package lurongrong.java;

class Season{
    //1.声明Season对象的属性：private final修饰
    private final String seasonName;
    private final String seasonDesc;

    public Season(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    public static final Season SPRING = new Season("春天","春暖花开");
    public static final Season SUMMER = new Season("夏天","夏日炎炎");

    public static final Season AUTUMN = new Season("秋天","秋风瑟瑟");

    public static final Season WINTER = new Season("冬天","冰天雪地");

    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

    @Override
    public String toString() {
        return "" +
                "Season{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }

    /**
     * @description：自定义枚举类
     * @auther lurongrong
     * @create 2021-02-05 23:29
     */

}