package LeetCode;

/**
 * 108. 将有序数组转换为二叉搜索树
 */
public class Solution_108 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode sortedArrayToBST(int[] nums) {

        return sortedArrayToBST(nums, 0, nums.length-1);
    }

    private TreeNode sortedArrayToBST(int[] nums, int left, int right) {

        if (right < left) return null;

        int mid = (right-left)/2 + left;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = sortedArrayToBST(nums, left, mid-1);
        node.right = sortedArrayToBST(nums, mid+1, right);
        return node;
    }
}
