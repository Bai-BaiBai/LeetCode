package LeetCode;

/**
 * 21. 合并两个有序链表
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class Solution_21 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode res = new ListNode(-1);// 返回链表的虚拟头节点

        ListNode resCur = res; // 指向返回链表的指针
        ListNode oneCur = l1; // 指向l1链表的指针
        ListNode twoCur = l2; // 指向l2链表的指针

        while (oneCur != null && twoCur != null) {
            if (oneCur.val < twoCur.val) {
                resCur.next = oneCur;
                resCur = resCur.next;
                oneCur = oneCur.next;
            } else {
                resCur.next = twoCur;
                resCur = resCur.next;
                twoCur = twoCur.next;
            }
        }
        while (oneCur != null) {
            resCur.next = oneCur;
            resCur = resCur.next;
            oneCur = oneCur.next;
        }
        while (twoCur != null) {
            resCur.next = twoCur;
            resCur = resCur.next;
            twoCur = twoCur.next;
        }

        return res.next;
    }
}
