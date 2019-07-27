package offer;

/**
 * 合并两个排序链表
 */
public class Question_25 {

    private static class Node{
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    private static Node mergeSortedLink(Node head1, Node head2){

        if (head1 == null) return head2;
        if (head2 == null) return head1;

        Node mergedHead = null;
        if (head1.val <= head2.val){
            mergedHead = head1;
            mergedHead.next = mergeSortedLink(head1.next, head2);
        }else {
            mergedHead = head2;
            mergedHead.next = mergeSortedLink(head1, head2.next);
        }
        return mergedHead;
    }
}
