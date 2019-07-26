package offer;

/**
 * 反转链表
 */
public class Question_24 {

    private class Node{
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    private static Node reverseList(Node head) {

        Node prev = null;
        Node cur = head;
        Node reverserHead = null;

        // 暂存当前节点的后一个节点，之后让当前节点的next指向它的前一个节点，cur = next
        while (cur != null) {
            Node next = cur.next;
            if (next == null) reverserHead = cur;// 如果next节点为空，说明当前节点是尾节点，即反转之后的头节点
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        return reverserHead;
    }
}
