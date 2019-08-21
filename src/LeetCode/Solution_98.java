package LeetCode;

import java.util.ArrayDeque;
import java.util.Queue;
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

    public void inorder(TreeNode root){

        Stack<TreeNode> stack = new Stack<>();
        while (root!= null || !stack.isEmpty()){
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()){
                root = stack.pop();
                System.out.print(root.val + " ");
                root = root.right;
            }
        }
    }

    public void preorder(TreeNode root){

        Stack<TreeNode> stack = new Stack<>();
        if (root != null) stack.push(root);
        while (!stack.isEmpty()){
            root = stack.pop();
            System.out.println(root.val);

            if (root.left != null) stack.push(root.left);
            if (root.right != null) stack.push(root.right);
        }
    }

    public void levelOrder(TreeNode root){

        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root != null) queue.add(root);

        while (!queue.isEmpty()){
            root = queue.remove();
            System.out.println(root.val);

            if (root.left != null) queue.add(root.left);
            if (root.right != null) queue.add(root.right);
        }
    }
}
