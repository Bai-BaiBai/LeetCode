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

    // 模拟系统栈实现
    // 定义一个枚举类 用来标明指令
    private enum Action{
        // GO 表示递归处理
        // ADDRESULT 表示添加到结果集中
        GO, ADDRESULT
    }

    private class Command{
        private Action action;
        private TreeNode node;

        Command(Action action, TreeNode node){
            this.action = action;
            this.node = node;
        }
    }

    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        // 栈保存节点的同时还保存对它的指令
        Stack<Command> stack = new Stack<>();
        stack.push(new Command(Action.GO, root));

        while (!stack.isEmpty()){
            Command command = stack.pop();
            switch (command.action){
                case ADDRESULT:
                    result.add(command.node.val);
                    break;
                case GO:
                    // 因为是先进后出，所以要先放右节点后放左节点
                    if (command.node.right != null) stack.push(new Command(Action.GO, command.node.right));
                    stack.push(new Command(Action.ADDRESULT, command.node));
                    if (command.node.left != null) stack.push(new Command(Action.GO, command.node.left));
            }
        }

        return result;
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
