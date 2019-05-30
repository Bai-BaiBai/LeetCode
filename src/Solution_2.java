/**
 * 2.两数相加
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class Solution_2 {


    public static class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
    }

    /**
     * 设置一个进位标志flag，两个数相加大于9时flag=true进位
     * 同时遍历两个链表，先检查是否进位，进位逻辑后再判断是否需要再次进位，其中任何一个链表指向null即终止循环
     * 再判断哪个链表还不为空，继续向返回链表追加，这里注意要判断是否有进位
     * 可能两个链表都遍历结束，但是还存在进位
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);//虚拟头节点
        ListNode cur = dummy;//指针指向虚拟头
        boolean flag = false;
        while (l1 != null && l2 != null){
            int val = l1.val + l2.val;
            if (flag){ //检查前一次操作是否有进位
                val += 1;
                flag = false;
            }
            if (val > 9){//检查当前的数是否是两位数
                flag = true;
                val = val % 10;
            }
            cur.next = new ListNode(val);
            cur = cur.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null){
            int val = l1.val;
            if (flag){
                val ++;
                flag = false;
                if (val > 9){//检查当前的数是否是两位数
                    flag = true;
                    val = val % 10;
                }
                cur.next = new ListNode(val);
                cur = cur.next;
                l1 = l1.next;
                continue;
            }
            cur.next = new ListNode(val);
            cur = cur.next;
            l1 = l1.next;
        }
        while (l2 != null){
            int val = l2.val;
            if (flag){
                val ++;
                flag = false;
                if (val > 9){
                    flag = true;
                    val = val % 10;
                }
                cur.next = new ListNode(val);
                cur = cur.next;
                l2 = l2.next;
                continue;
            }
            cur.next = new ListNode(val);
            cur = cur.next;
            l2 = l2.next;
        }

        if (flag){
            cur.next = new ListNode(1);
        }

        return dummy.next;
    }
}
