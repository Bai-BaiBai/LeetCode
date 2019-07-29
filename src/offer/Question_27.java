package offer;

/**
 * 二叉树的镜像
 */
public class Question_27 {

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

    private static Node mirrorTree(Node root){

        if (root == null) return null;

        root.left = mirrorTree(root.left);
        root.right = mirrorTree(root.right);

        if (root.left != null || root.right != null) {
            Node left = root.left;
            root.left = root.right;
            root.right = left;
        }

        return root;
    }

    public static void main(String[] args) {

        Node root = new Node(1);
        Node left = new Node(2);
        Node right = new Node(3);
        root.left = left;
        root.right = right;

        mirrorTree(root);
        System.out.println(root.right.val);
    }
}
