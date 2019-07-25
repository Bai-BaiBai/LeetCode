package offer;

/**
 * 寻找链表中环的入口
 */
public class Question_23 {

    private static class Node{
        int val;
        Node next;
        Node(int val){
            this.val = val;
            this.next = null;
        }
    }

    private static int findEnter(Node head){

        if (head == null) return -1;

        // 设置快慢指针，如果两个指针相遇则说明存在环，且相遇的位置一定是在环内
        Node fast = head;
        Node low = head;
        while (true){
            low = low.next;
            fast = fast.next.next;
            if (low == fast) break;
            if (fast == null) return -1;// 如果快指针指向null 说明不存在环
        }

        // 让一个指针向后走，并计数，计算环的大小count
        int count = 1;
        fast = fast.next;
        while (fast != low){
            count++;
            fast = fast.next;
        }

        // 快慢指针，快指针先走count步，之后两个指针以相同速度走，相遇时即是环的入口位置
        low = head;
        fast = head;
        for (int i = 0; i < count; i++) {
            fast = fast.next;
        }
        while (low != fast){
            low = low.next;
            fast = fast.next;
        }
        return low.val;
    }

    public static void main(String[] args) {

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node3;

        System.out.println(findEnter(node1));
    }
}
