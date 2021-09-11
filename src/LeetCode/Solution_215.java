package LeetCode;


public class Solution_215 {
    public int findKthLargest(int[] nums, int k) {
        // 找第k个大的，就是找length-k+1个小的，索引再-1；
        int result = findKIndex(nums, 0, nums.length - 1, nums.length - k);
        return nums[nums.length - k];
    }

    private static int findKIndex(int[] nums, int left, int right, int k) {
        int temp = part(nums, left, right);
        if (temp == k) return temp;
        return k > temp ? findKIndex(nums, temp + 1, right, k) : findKIndex(nums, left, temp - 1, k);
    }

    private static int part(int[] nums, int left, int right) {
        if (left == right) {
            return left;
        }
        int pivot = nums[left];// 锚点
        int low = left;
        int high = right;
        while (low < high) {
            while (low < high && nums[high] >= pivot) high--;
            nums[low] = nums[high];
            while (high > low && nums[low] <= pivot) low++;
            nums[high] = nums[low];
//            if (low < high) {
//                swap(nums, low, high);
//            }
        }
        nums[high] = pivot;
        return high;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int nums[] = {2, 1};
        new Solution_215().findKthLargest(nums, 1);
    }
}
