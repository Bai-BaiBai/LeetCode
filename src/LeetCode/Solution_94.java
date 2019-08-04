package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的中序遍历
 */
public class Solution_94 {

    public class TreeNode {
        int val;TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // 非递归解法
    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()){
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()){
                root = stack.pop();
                result.add(root.val);
                root = root.right;
            }
        }

        return result;
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
