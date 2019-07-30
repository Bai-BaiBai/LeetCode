package LeetCode;

/**
 * 环形链表 II
 *
 * 如果内存充裕，并且没有手动内存管理的话，因为内存连续分配，判断下一个节点堆内存地址大小即可找出环入口
 * 遍历链表，如果下一节点的地址小于当前节点，说明下一节点是环的入口
 */
public class Solution_142 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /*
    // 修改数值方法，只需要一个指针
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
