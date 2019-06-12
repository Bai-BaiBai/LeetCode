/**
 * 82. 删除排序链表中的重复元素 II
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 * <p>
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 */
public class Solution_82 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummyhead = new ListNode(-1);//虚拟头节点
        dummyhead.next = head;
        ListNode prev = dummyhead;//当前节点的前一个节点的指针
        ListNode cur = head;//当前节点指针

        // 当cur节点和cur.next节点的值不同时，prev.next才指向cur
        // 否则暂存cur.val cur=cur.next 直到value!=cur.val为止
        // 此时回到第二层while循环，再对cur.val和cur.next.val 判断是否相等，如果相等，重复第二步
        while (prev != null && prev.next != null){
            //当前节点的值和后续节点相同时,暂存值，逐个向后比较
            while (cur != null && cur.next != null && cur.val == cur.next.val){
                int value = cur.val;
                while (cur != null && value == cur.val){
                    cur = cur.next;
                }
            }
            prev.next = cur;
            if (cur == null) break;//说明此时已经遍历完成
            cur = cur.next;
            prev = prev.next;
        }

        return dummyhead.next;
    }

    // 递归解决
    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null) return null;

        if (head.next != null && head.val == head.next.val){
            while (head.next != null && head.val == head.next.val){
                head = head.next;
            }
            return deleteDuplicates2(head.next);
        }
        head.next = deleteDuplicates2(head.next);
        return head;
    }

}
