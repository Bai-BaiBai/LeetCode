package LeetCode;

/**
 * 328. 奇偶链表
 *
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 */
public class Solution_328 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode oddEvenList(ListNode head) {

        if (head == null) return null;

        ListNode odd = head;
        ListNode even = head.next;

        ListNode tail = head;
        while (tail.next != null){
            tail = tail.next;
        }

        ListNode node = tail;

        while (odd != node && even != node){
            odd.next = odd.next.next;
            odd = odd.next;
            tail.next = even;
            tail = tail.next;
            even.next = null;
            even = odd.next;
        }

        if (even == node){
            if (even.next != null) {
                odd.next = odd.next.next;
            }
            tail.next = even;
            even.next = null;
        }

        return head;
    }

    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        new Solution_328().oddEvenList(node1);
    }
}
