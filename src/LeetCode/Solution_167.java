package LeetCode;

//给定一个已按照 非递减顺序排列 的整数数组 numbers ，请你从数组中找出两个数满足相加之和等于目标数 target 。
//
// 函数应该以长度为 2 的整数数组的形式返回这两个数的下标值。numbers 的下标 从 1 开始计数 ，所以答案数组应当满足 1 <= answer[0]
// < answer[1] <= numbers.length 。
//
// 你可以假设每个输入 只对应唯一的答案 ，而且你 不可以 重复使用相同的元素。
public class Solution_167 {

    public int[] twoSum(int[] numbers, int target) {
        int chazhi = 0;
        for (int i = 0; i < numbers.length; i++) {
            chazhi = find(numbers, target - numbers[i], target - numbers[i] == numbers[i] ? i : -1);
            if (chazhi != -1) {
                return new int[]{i + 1, chazhi + 1};
            }
        }
        return new int[2];
    }

    // 返回数组中dest的下标
    private static int find(int[] nums, int dest, int exclude) {
        int left = 0;
        int right = nums.length - 1;
        return erfen(nums, left, right, dest, exclude);
    }

    private static int erfen(int[] nums, int left, int right, int dest, int exclude) {
        if (left == right) {
            return nums[left] == dest && left != exclude ? left : -1;
        }
        int mid = left + (right - left) / 2;
        if (nums[mid] == dest && mid != exclude) return mid;
        return nums[mid] < dest ? erfen(nums, mid + 1, right, dest, exclude) : erfen(nums, left, mid - 1, dest, exclude);
    }

    public static void main(String[] args) {
        int[] chazhi = new int[]{2, 7, 11, 15};
        int[] ints = new Solution_167().twoSum(chazhi, 9);
        System.out.println(ints);
    }


    // 对撞指针
    public int[] twoSum2(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;

        while (i < j) {
            if (numbers[i] + numbers[j] == target) return new int[]{i + 1, j + 1};
            if (numbers[i] + numbers[j] < target) {
                i++;
            }
            if (numbers[i] + numbers[j] > target) {
                j++;
            }
        }
        return new int[2];
    }


}
