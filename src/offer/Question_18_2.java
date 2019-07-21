package offer;

/**
 * 删除链表中重复的节点
 */
public class Question_18_2 {

    private class Node{
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    private Node deleteDuplication(Node root){

        Node dummyHead = new Node(-1);
        dummyHead.next = root;
        Node cur = root;
        while (cur != null){

            if (cur.next != null && cur.val == cur.next.val){
                int val = cur.val;
                Node cur2 = cur;
                while (cur2 != null && cur2.val == val){
                    cur2 = cur2.next;
                }

                if (cur2 != null){
                    cur.val = cur2.val;
                    cur.next = cur2.next;
                }else {
                    Node prev = dummyHead;
                    while (prev.next != cur){
                        prev = prev.next;
                    }
                    prev.next = null;
                    cur = null;
                }
            }else {
                cur = cur.next;
            }

        }
        return dummyHead.next;
    }

    public static void main(String[] args) {

    }
}
