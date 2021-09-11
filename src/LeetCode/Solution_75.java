package LeetCode;

//给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，
// 使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
//
// 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
//
// 示例 1：
//输入：nums = [2,0,2,1,1,0]
//输出：[0,0,1,1,2,2]
//
// 示例 2：
//输入：nums = [2,0,1]
//输出：[0,1,2]
//
// 示例 3：
//输入：nums = [0]
//输出：[0]
//
// 示例 4：
//输入：nums = [1]
//输出：[1]
// 提示：n == nums.length
// 1 <= n <= 300
// nums[i] 为 0、1 或 2

// 类似 215题 88题
public class Solution_75 {

    public void sortColors(int[] nums) {
        int n = nums.length;
        int zero = -1;// [0...zero] = 0
        int two = n;// [two...n-1] = 2;
        int i = 0;// // [zero+1...i-1] = 1
        while (i < two) {
            if (nums[i] == 1) i++;
            else if (nums[i] == 0) {
                swap(nums, ++zero, i);
                i++;
            } else if (nums[i] == 2) {
                swap(nums, --two, i);
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        new Solution_75().sortColors(nums);
    }
}
