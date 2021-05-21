package rongrong.java;

/**
 * @description：
 * @auther lurongrong
 * @create 2021-03-31 17:57
 */
public class TestDemo {
    public static void main(String[] args) {

        int[] a = {4,2,3};
        boolean b = checkPossibility(a);
        System.out.println(b);

        int[][] carrot = {{5,7,6,3},{2,4,8,12},{3,5,10,7},{4,16,4,17}};
        int carrots = PickCarrots(carrot);
        System.out.println(carrots);
    }
    public static int PickCarrots(int[][] carrot) {
        // write your code here
        if (carrot == null) return -1;
       //先将中心数的四个方向上的坐标位置存储到二维数组中,上下左右
        int[][] ps = new int[][]{new int[]{-1,0},new int[]{1,0},new int[]{0,-1},new int[]{0,1}};
        //获取二维数组的行列的最大值
        int row = carrot.length;
        int column = carrot[0].length;
        //总数
        int res = 0;
        for (int i = (row-1)/2,j = (column-1)/2;;) {
            res += carrot[i][j];
            //捡完之后归为-1
            carrot[i][j]=-1;
            int c = -1;
            int tempi = 0;
            int tempj = 0;
            for (int[] p:ps) {
                int ti = i+p[0];
                int tj = j+p[1];
                if (ti>=0 && ti<row && tj>=0 && tj<column && carrot[ti][tj]>c){
                    c = carrot[ti][tj];
                    tempi = ti;
                    tempj = tj;
                }
            }
            if (c>0){
                i=tempi;
                j=tempj;

            }else {
                break;


            }
        }
        return res;
    }

    public static boolean checkPossibility(int[] nums) {
        int n = nums.length,count=0;
        if(nums == null || n == 0) return true;
        for(int i = 0;i < n - 1;i++){
            int x =nums[i],y = nums[i+1];
            if(x > y){
                count++;
                if(count == 2){
                    return false;
                }
                if(i>0 && y < nums[i-1]){
                    nums[i+1] = x;
                }
            }
        }
        return true;
    }

}
