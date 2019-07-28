package offer;

/**
 * 树的子结构
 */
public class Question_26 {

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

    private static boolean hasSubTree(Node root1, Node root2){

        boolean result = false;
        if (root1 == null || root2 == null) return result;

        // 如果树1的节点和树2的根节点匹配，那么对两个树进行判断是否为子结构
        if (root1.val == root2.val)
            result = checkSubTree(root1, root2);
        // 如果不为子结构，递归遍历树1的所有节点，查看是否和树2的根节点相等
        if (!result)
            result = hasSubTree(root1.left, root2);
        if (!result)
            result = hasSubTree(root1.right, root2);

        return result;
    }

    // 递归检查两个树是否相等
    private static boolean checkSubTree(Node root1, Node root2){

        if (root2 == null) return true;// 如果root2递归到空，说明该节点是相等的
        if (root1 == null) return false; // root1的判断要在root2之后，如果root2不为空，root1为空，说明不想等

        if (root1.val != root2.val) return false;

        return checkSubTree(root1.left, root2.left) && checkSubTree(root1.right, root2.right);
    }
}
