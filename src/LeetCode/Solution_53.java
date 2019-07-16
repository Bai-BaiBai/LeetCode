package LeetCode;

/**
 * 53. 最大子序和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 */
public class Solution_53 {

    /**
     * 动态规划
     *
     */
    public int maxSubArray(int[] nums) {
        if (nums.length < 1) return 0;
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (sum[i-1] < 0){
                sum[i] = nums[i];
            }else {
                sum[i] = nums[i] + sum[i-1];
            }
        }

//        for (int i = 0; i < sum.length; i++) {
//            System.out.print(sum[i] + " ");
//        }

        int res = sum[0];
        for (int i = 1; i < sum.length; i++) {
            if (res < sum[i] ) res = sum[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        new Solution_53().maxSubArray(nums);
    }
}
