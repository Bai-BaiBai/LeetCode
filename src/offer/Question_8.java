package offer;

public class Question_8 {

    private static class Node{
        char val;
        Node parent;
        Node left, right;

        public Node(char val, Node parent) {
            this.val = val;
            this.parent = parent;
            this.left = null;
            this.right = null;
        }
    }

    public static Node findNext(Node node){

        if (node == null) return null;

        if (node.right != null){
            Node rightNode = node.right;
            while (rightNode.left != null){
                rightNode = rightNode.left;
            }
            return rightNode;
        } else if (node.parent != null){
            Node cur = node;
            Node parentNode = node.parent;
            while (parentNode != null && cur == parentNode.right){
                cur = parentNode;
                parentNode = parentNode.parent;
            }
            return parentNode;
        }

        /*
        else if (node.parent != null){
            Node parentNode = node.parent;
            if (parentNode.left == node){
                return parentNode;
            } else {
                // parentNode.right = node
                while (parentNode.parent != null){
                    if (parentNode == parentNode.parent.left) break;
                    parentNode = parentNode.parent;
                }
                return parentNode.parent;
            }
        }
         */

        return null;
    }

    public static void main(String[] args) {

        Node head = new Node('a', null);
        head.left = new Node('b', head);
        head.right = new Node('c', head);
        head.left.left = new Node('d', head.left);
        head.left.right = new Node('e', head.left);
        head.right.left = new Node('f',head.right);
        head.right.right = new Node('g',head.right);
        head.left.right.left = new Node('h',head.left.right);
        head.left.right.right = new Node('i',head.left.right);

//                              a
//                            /  \
//                          b    c
//                        / \   / \
//                       d  e  f  g
//                         / \
//                        h  i
        // inOrder : d b h e i a f c g
        System.out.println(findNext(head.right.right).val);
    }
}
