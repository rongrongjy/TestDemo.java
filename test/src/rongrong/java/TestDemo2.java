package rongrong.java;

/**
 * @description：给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 最多出现两次 ，
 * 返回删除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成
 *
 * 输入：nums = [1,1,1,2,2,3]
 * 输出：5, nums = [1,1,2,2,3]
 * 解释：函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。
 * 不需要考虑数组中超出新长度后面的元素
 *
 * @auther lurongrong
 * @create 2021-04-06 20:35
 */
public class TestDemo2 {
    public static void main(String[] args) {
        int[] nums = {1,1,1,1,2,2,3};
        int i = removeDuplicates(nums);
        for (int j = 0; j < i; j++) {

            System.out.print(nums[j] + "\t");
        }
    }
    public static int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n <= 3) {
            return n;
        }
        int slow = 3, fast = 3;
        while (fast < n) {
            if (nums[slow - 3] != nums[fast]) {
                nums[slow] = nums[fast];
                ++slow;
            }
            ++fast;
        }
        return slow;
    }
    public static int removeDuplicates1(int[] nums){
        int max = 4;
        int slow = max-1;
        int fast = max;
        for (;fast < nums.length;fast++){
            if (nums[fast] != nums[slow-max+1]){
                slow++;
                nums[slow] = nums[fast];
            }
        }
        return slow+1;
    }
}
