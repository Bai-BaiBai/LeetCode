package offer;

/**
 * 复杂链表的复制
 */
public class Question_35 {

    private static class Node{
        int val;
        Node next;
        Node sibling;

        Node(int val) {
            this.val = val;
            this.next = null;
            this.sibling = null;
        }
    }

    private static Node clone(Node root){

        cloneNodes(root);
        connectSiblingNode(root);
        return reconnectClonedNode(root);
    }

    // 1.将克隆节点接在原节点的后面
    // A -> B -> C   变成   A -> A' -> B -> B' -> C -> C'
    private static void cloneNodes(Node root){

        Node cur = root;
        while (cur != null){
            Node cloneNode = new Node(cur.val);
            cloneNode.next = cur.next;
            cloneNode.sibling = null;
            cur.next = cloneNode;
            cur = cloneNode.next;
        }
    }

    // 2.连接克隆节点的sibling， 克隆节点的sibling即为原节点sibling的next节点
    private static void connectSiblingNode(Node root){

        Node cur = root;
        while (cur != null){
            Node cloneNode = cur.next;
            if (cur.sibling != null){
                cloneNode.sibling = cur.sibling.next;
            }
            cur = cloneNode.next;
        }
    }

    // 3.将克隆节点脱离出来
    private static Node reconnectClonedNode(Node root){

        Node clonedHead = null;
        Node cur = root;
        Node clonedNode = null;

        if (cur != null){
            clonedHead = cur.next;
            clonedNode = cur.next;
            cur.next = clonedNode.next;
            cur = cur.next;
        }

        while (cur != null){
            clonedNode.next = cur.next;
            clonedNode = clonedNode.next;
            cur.next = clonedNode.next;
            cur = cur.next;
        }

        return clonedHead;
    }
}
