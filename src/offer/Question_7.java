package offer;

import java.util.Arrays;

public class Question_7 {

    private static class Node{

        private int val;
        private Node left;
        private Node right;

        private Node(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    private static Node transToTree(int[] preOrder, int[] inOrder, int length){

        if (inOrder.length == 0 || preOrder.length != inOrder.length) return null;

        if (length == 1) return new Node(preOrder[0]);

        Node root = null;
        for (int i = 0; i < length; i++) {
            if (inOrder[i] == preOrder[0]){
                root = new Node(preOrder[0]);

                root.left = transToTree(Arrays.copyOfRange(preOrder, 1, i+1),
                                        Arrays.copyOfRange(inOrder, 0, i), i);
                root.right = transToTree(Arrays.copyOfRange(preOrder, i+1, length),
                                        Arrays.copyOfRange(inOrder, i+1, length), length-1-i);
                break;
            }
        }

        return root;
    }

    private static void preOrder(Node head){

        if (head == null) return;

        System.out.print(head.val + ' ');
        preOrder(head.left);
        preOrder(head.right);
    }

    public static void main(String[] args) {

        int[] preOrder = {1,2,4,7,3,5,6,8};
        int[] inOrder = {4,7,2,5,3,8,6,1};

        Node head = Question_7.transToTree(preOrder, inOrder, 8);

        Question_7.preOrder(head);
    }

}
