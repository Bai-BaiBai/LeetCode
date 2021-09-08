package LeetCode;

//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
//
// 示例:
//
// 输入: [0,1,0,3,12]
//输出: [1,3,12,0,0]
//
// 说明:
//
//
// 必须在原数组上操作，不能拷贝额外的数组。
// 尽量减少操作次数。
// 类似题目 27、26、80
public class Solution_283 {

    public void moveZeroes(int[] nums) {
        // non-zero in [0...index)
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index++] = nums[i];
            }
        }
        // put zero to [index...)
        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public void moveZeroes2(int[] nums) {
        // 保证[0,i]中的所有元素
        // [0...firstZeroIndex)为非零元素
        // [firstZeroIndex...i]为0
        int firstZeroIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (firstZeroIndex != i) {
                    int temp = nums[firstZeroIndex];
                    nums[firstZeroIndex] = nums[i];
                    nums[i] = temp;
                    firstZeroIndex++;
                } else {
                    firstZeroIndex++;
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution_283 solution_283 = new Solution_283();
        solution_283.moveZeroes(new int[]{1, 0, 3, 0, 12});

    }
}
