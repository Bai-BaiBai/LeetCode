package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的中序遍历
 */
public class Solution_94 {

    public class TreeNode {
        int val;TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // 递归解法
    public List<Integer> inorderTraversal2(TreeNode root) {

        if (root == null) return null;

        List<Integer> result = new ArrayList<>();
        inorderTraversal(root, result);

        return result;
    }

    private void inorderTraversal(TreeNode root, List<Integer> result) {

        if (root == null) return;

        inorderTraversal(root.left, result);
        result.add(root.val);
        inorderTraversal(root.right, result);
    }
}
