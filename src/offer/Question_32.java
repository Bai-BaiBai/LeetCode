package offer;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 从上到下打印二叉树
 */
public class Question_32 {

    private static class Node{
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    private static void printTree(Node root){

        if (root == null) return;

        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()){
            Node node = queue.remove();
            System.out.print(node.val + " ");
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
    }
}
