package offer;

import java.util.Queue;

/**
 * 序列化二叉树
 */
public class Question_37 {

    private static class Node{
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    private static void serialize(Node root, StringBuilder str){

        if (root == null) {
            str.append('$');
            return;
        }

        str.append(root.val);
        serialize(root.left, str);
        serialize(root.right, str);
    }

    private static void deSerialize(Node newRoot, Queue<Character> str){

        char c;
        if ((c = str.remove()) != '$'){
            newRoot = new Node((int)c);
            newRoot.left = null;
            newRoot.right = null;

            deSerialize(newRoot.left, str);
            deSerialize(newRoot.right, str);
        }

    }
}
