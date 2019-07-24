package offer;

/**
 * 链表中的倒数第 k 个节点
 *
 * 从 1 开始计数
 */
public class Question_22 {

    private static class Node{

        int val;
        Node next;

        public Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    // 需要注意 k < 0 、 节点数少于k个 等情况
    private static int findKth(Node head, int k){

        if (head == null || k < 1) return -1;

        int count = 1;
        Node Kth = head;
        Node cur = head;

        while (count < k){
            if (Kth == null) {
                return -1;
            }
            Kth = Kth.next;
            count ++;
        }

        while (Kth != null){
            Kth = Kth.next;
            cur = cur.next;
        }

        return cur.val;
    }

}
