package offer;

/**
 * 对称的二叉树
 */
public class Question_28 {

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

    private static void prevOrderLeft(Node root, StringBuilder str){

        if (root == null){
            str.append("null");
            return;
        }

        str.append(root.val);
        prevOrderLeft(root.left, str);
        prevOrderLeft(root.right, str);
    }

    private static void prevOrderRight(Node root, StringBuilder str){

        if (root == null){
            str.append("null");
            return;
        }

        str.append(root.val);
        prevOrderRight(root.right, str);
        prevOrderRight(root.left, str);
    }

    public static void main(String[] args) {

        Node node1 = new Node(8);
        Node node2 = new Node(6);
        Node node3 = new Node(6);
        Node node4 = new Node(5);
        Node node5 = new Node(7);
        Node node6 = new Node(7);
        Node node7 = new Node(5);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;

        StringBuilder str1 = new StringBuilder();
        StringBuilder str2 = new StringBuilder();
        prevOrderLeft(node1, str1);
        prevOrderRight(node1, str2);

        System.out.println(str1.toString());
        System.out.println(str2.toString());
    }
}
