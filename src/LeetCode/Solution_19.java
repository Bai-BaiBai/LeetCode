package LeetCode;

/**
 * 删除链表的倒数第N个节点
 */
public class Solution_19 {

     public class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
     }

    public ListNode removeNthFromEnd(ListNode head, int n) {

         if (head == null) return null;
         ListNode fast = head;
         while (n > 0){
             if (fast == null) return null;
             fast = fast.next;
             n--;
         }

         ListNode dummyHead = new ListNode(-1);
         dummyHead.next = head;
         ListNode prev = dummyHead;
         ListNode res = head;
         while (fast != null){
             res = res.next;
             fast = fast.next;
             prev = prev.next;
         }

         prev.next = res.next;
         res.next = null;
         res = null;

         return dummyHead.next;

    }
}
