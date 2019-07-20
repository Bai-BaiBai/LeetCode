package offer;

/**
 * 在O(1)时间内删除链表节点
 */
public class Question_18 {

    /**
     * 平均时间复杂度O(1)
     */
    private class Node{
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    private void deleteNode(Node root, Node toBeDel){

        if (root == null || toBeDel == null) return;

        // 当要删除节点不是尾节点时，直接让下一节点值覆盖，并删除下一节点
        if (toBeDel.next != null){
            Node next = toBeDel.next;
            toBeDel.val = next.val;
            toBeDel.next = next.next;
            next = null;
        }
        // 如果要删除节点是尾节点且等于头节点，也就是链表只有一个节点，全部删除
        else if (root == toBeDel){
            root = null;
            toBeDel = null;
        }
        // 链表有多个节点，并且删除节点是尾节点，此情况只能遍历
        else {
            Node cur = root;
            while (cur.next != toBeDel){
                cur = cur.next;
            }
            cur.next = null;
        }
    }
}
