/**
 * 88. 合并两个有序数组
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 * 说明:
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 *
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * 输出: [1,2,2,3,5,6]
 */
public class Solution_88 {

    //归并排序中的归并步骤
    // 时间复杂度O(m+n) 空间复杂度O(m)
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int[] nums_1 = new int[m];
        System.arraycopy(nums1, 0, nums_1, 0, m);
        int i = 0;//nums1数组的下标
        int j = 0;//nums2数组的下标

        for (int k = 0; k < m + n; k++) {
            if (i < m && j < n && nums_1[i] < nums2[j]){
                nums1[k] = nums_1[i];
                i++;
            }
            else if (i < m && j < n && nums_1[i] >= nums2[j]){
                nums1[k] = nums2[j];
                j++;
            }
            else if (i >= m && j < n){
                nums1[k] = nums2[j];
                j++;
            }
            else if (i < m && j >= n){
                nums1[k] = nums_1[i];
                i++;
            }
        }
    }

    // 时间复杂度O(m+n) 空间复杂度O(1)
    public void merge2(int[] nums1, int m, int[] nums2, int n){
        int i = m-1;
        int j = n-1;
        for (int k = m+n-1; k >= 0 ; k--) {
            if (i >= 0 && j >= 0 && nums1[i] > nums2[j]){
                nums1[k] = nums1[i];
                i--;
            }
            else if (i >= 0 && j >= 0 && nums2[j] >= nums1[i]){
                nums1[k] = nums2[j];
                j--;
            }
            else if (i >= 0 && j < 0){
                nums1[k] = nums1[i];
                i--;
            }
            else if (j >= 0 && i < 0){
                nums1[k] = nums2[j];
                j--;
            }
        }
    }
}
