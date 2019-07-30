package LeetCode;

/**
 * 环形链表
 */
public class Solution_141 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public boolean hasCycle(ListNode head) {

        if (head == null) return false;

        ListNode fast = head.next;
        ListNode low = head;

        while (true){
            if (fast == null) return false;
            if (fast == low) return true;
            fast = fast.next;
            if (fast == null) return false;
            fast = fast.next;
            low = low.next;
        }
    }
}
