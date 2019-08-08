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

        Node cur = node;
        if (cur.left != null){
            convertNode(cur.left, lastNode);
        }
        cur.left = lastNode;
        if (lastNode != null){
            lastNode.right = cur;
        }
        lastNode = cur;
        if (cur.right != null){
            convertNode(cur.right, lastNode);
        }
    }
}
