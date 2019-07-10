package offer;

import java.util.Stack;

public class Question_6 {

    private static class Node{
        private int val;
        private Node next;

        public Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    /**
     * 使用栈反向输出
     * @param head
     */
    public void printListRevert(Node head){

        if (head == null) return;

        Stack<Integer> stack = new Stack<>();
        Node cur = head;
        while (cur != null){
            stack.push(cur.val);
            cur = cur.next;
        }

        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }

    /**
     * 使用递归实现，链表越长性能越差
     * @param head
     */
    public void printListRevert2(Node head){

        if (head == null) return;

        if (head.next != null){
            printListRevert2(head.next);
        }
        System.out.println(head.val);
    }

    public static void main(String[] args) {

        Node node = new Node(0);
        Node cur = node;
        for (int i = 1; i < 5; i++) {
            cur.next = new Node(i);
            cur = cur.next;
        }

        new Question_6().printListRevert2(node);

    }
}
