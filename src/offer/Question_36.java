package offer;

/**
 * BST与双向链表
 */
public class Question_36 {

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

    static Node convert(Node root){

        Node lastNode = null;
        convertNode(root, lastNode);
        Node head = lastNode;
        while (head != null && head.left != null){
            head = head.left;
        }
        return head;
    }

    private static void convertNode(Node node, Node lastNode) {

        if (node == null) return;

        if (node.left != null){
            convertNode(node.left, lastNode);
        }
        node.left = lastNode;
        if (lastNode != null){
            lastNode.right = node;
        }
        lastNode = node;
        if (node.right != null){
            convertNode(node.right, lastNode);
        }
    }
}
