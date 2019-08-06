package offer;

import java.util.Arrays;

/**
 * BST的后序遍历序列
 */
public class Question_33 {

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

    private static boolean verifyBST(int[] sequence, int length){

        if (sequence.length <= 0 || length <= 0) return false;

        int root = sequence[length-1];

        // 找到左右子树的界限, [0..i)为左子树 [i..length-2]为右子树
        int i = 0;
        for (; i < length - 1; i++) {
            if (sequence[i] > root) break;
        }

        // 判断右子树是否合法
        int j = i;
        for (; j < length-1; j++) {
            if (sequence[j] < root) return false;
        }

        // 递归判断左子树是不是BST
        boolean left = true;
        if (i > 0) left = verifyBST(sequence, i);

        // 递归判断右子树是不是BST
        boolean right = false;
        if (i < length-1){
            int[] rSequencce = Arrays.copyOfRange(sequence, i, length-1);
            right = verifyBST(rSequencce, length-1-i);
        }

        return left&&right;

    }
}
