import java.util.HashMap;

/**
 * 83. 删除排序链表中的重复元素
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 *
 * 输入: 1->1->2
 * 输出: 1->2
 */
public class Solution_83 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode deleteDuplicates(ListNode head) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ListNode prev = new ListNode(-1);
        prev.next = head;
        ListNode cur = head;
        while (cur != null){
            if (map.containsKey(cur.val)){
                prev.next = cur.next;
                cur = cur.next;
            }
            else {
                map.put(cur.val, 0);
                cur = cur.next;
                prev = prev.next;
            }
        }

        return head;
    }
}
