package LeetCode;

/**
 * 33. 搜索旋转排序数组
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * 你可以假设数组中不存在重复的元素。
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 */
public class Solution_33 {

    public int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length-1;
        if (left == right) {
            return target == nums[left] ? left : -1;
        }
        return search(nums, target, left, right);
    }

    private int search(int[] nums, int target, int left, int right) {

        if (nums.length < 1 || left > right) return -1;
        int mid = left + (right - left)/2;

        if (nums[left] == target) return left;
        if (nums[mid] == target) return mid;
        if (nums[right] == target) return right;

        // 如果数组旋转
        if (nums[left] > nums[right]){
            // 判断target在左半面还是右半面
            if (nums[left] < target && nums[mid] > target) {
                return search(nums, target, left, mid);
            }else {
                return search(nums, target, mid, right);
            }
        }
        // 如果数组没有旋转
        else if (nums[left] < nums[right]){
            if (target < nums[left] || target > nums[right]) return -1;
            if (nums[mid] > target){
                return search(nums, target, left, mid);
            }else {
                return search(nums, target, mid, right);
            }
        }

        return -1;
    }
}
