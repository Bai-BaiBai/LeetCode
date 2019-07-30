package LeetCode;

/**
 * 环形链表 II
 */
public class Solution_142 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /*
    // 修改数值方法
    public ListNode detectCycle(ListNode head) {

        if (head == null) return null;

        ListNode cur = head;
        while (true){
            if (cur == null) return null;
            if (cur.val == Integer.MAX_VALUE) return cur;
            cur.val = Integer.MAX_VALUE;
            cur = cur.next;
        }
    }

     */

    // 快慢指针
    public ListNode detectCycle(ListNode head) {

        if (head == null) return null;

        ListNode fast = head.next;
        ListNode low = head;

        while (fast != low){
            if (fast == null) return null;
            fast = fast.next;
            if (fast == null) return null;
            fast = fast.next;
            low = low.next;
        }

        int count = 1;
        fast = fast.next;
        while (fast != low){
            count ++;
            fast = fast.next;
        }
        low = head;
        fast = head;
        for (int i = 0; i < count; i++) {
            fast = fast.next;
        }
        while (fast != low){
            fast = fast.next;
            low = low.next;
        }

        return fast;
    }
}
