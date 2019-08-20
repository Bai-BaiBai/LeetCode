package LeetCode;

import java.util.Stack;

/**
 * 98. 验证二叉搜索树
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 */
public class Solution_98 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * BST中序遍历为升序序列，inorder每次存储一个值，只要要存储的节点值大于inorder就说明不是BST
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();
        double inorder = - Double.MAX_VALUE;

        while (root != null || !stack.isEmpty()){
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()){
                root = stack.pop();
                if (inorder >= root.val) return false;
                inorder = root.val;
                root = root.right;
            }
        }

        return true;
    }
}
