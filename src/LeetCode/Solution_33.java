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

        return search(nums, target, 0, nums.length-1);
    }

    private int search(int[] nums, int target, int left, int right) {

        if (left > right) return -1;
        int mid = (left + right)/2;
        if (nums[mid] == target) return mid;

        // 如果nums[mid] 比 nums[right]小 说明 [mid...right] 是有序的
        if (nums[mid] < nums[right]){
            // 判断 target 是否在有序的区间内
            // 在则缩小区间，变为二分查找
            if (nums[mid] < target && target <= nums[right]){
                return search(nums, target, mid+1, right);
            }
            // 不在则去无序区间寻找，递归将数组分成两部分
            else {
                return search(nums, target, left, mid-1);
            }
        }
        // 否则，说明 [left...mid] 是有序的
        else {
            if (nums[left] <= target && nums[mid] > target){
                return search(nums, target, left, mid-1);
            }else {
                return search(nums, target, mid+1, right);
            }
        }
    }

}
