package LeetCode;

/**
 * 61. 旋转链表
 *
 * 本质上就是寻找倒数第k个节点作为头节点
 */
public class Solution_61 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode rotateRight(ListNode head, int k) {

        if (head == null) return null;

        if (k == 0) return head;

        int count = 0;
        ListNode cur = head;
        while (cur != null){
            count++;
            cur = cur.next;
        }
        k = k % count;

        // 用快指针先走k步
        ListNode fast = head;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }

        // 如果快指针指向头节点，说明不用旋转
        if (fast == head) return head;

        // 找到倒数第k个节点的前一个节点
        ListNode low = head;
        while (fast.next != null){
            low = low.next;
            fast = fast.next;
        }
        // 将该节点断开，倒数第k个节点作为newHead，再将尾节点接上原先的头节点
        ListNode newHead = low.next;
        low.next = null;
        fast.next = head;

        return newHead;
    }
}
