package offer;

import java.util.Stack;

/**
 * 寻找两条链表的公共节点
 */
public class Question_52 {

    private static class Node{
        int val;
        Node next;
        public Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    /**
     * 方案1，利用两个栈，同时遍历两个链表，将节点放入栈中，之后从后向前出栈，寻找第一个相同的节点
     * @param root1
     * @param root2
     * @return
     */
    static Node findFirstCommonNode1(Node root1, Node root2){

        if (root1 == null || root2 == null) return null;

        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();

        while (root1 !=null || root2!= null){

            if (root1 != null){
                stack1.push(root1);
                root1 = root1.next;
            }
            if (root2 != null){
                stack2.push(root2);
                root2 = root2.next;
            }
        }

        root1 = stack1.pop();
        root2 = stack2.pop();
        while (root1 == root2){
            root1 = stack1.pop();
            root2 = stack2.pop();
        }

        return root1.next;
    }

    /**
     * 方案2，先计算两个链表的长度，长链表先走n步，之后和短链表同步遍历，判断两个节点是否相等
     * @param root1
     * @param root2
     * @return
     */
    static Node findFirstCommonNode2(Node root1, Node root2){

        int length1 = 0;
        int length2 = 0;
        Node cur = root1;
        while (cur != null){
            length1++;
            cur = cur.next;
        }
        cur = root2;
        while (cur != null){
            length2++;
            cur = cur.next;
        }

        int count = length1-length2;
        Node longhead = null;
        Node shorthead = null;
        if (count >= 0){
            longhead = root1;
            shorthead = root2;
        }else {
            longhead = root2;
            shorthead = root1;
        }
        for (int i = 0; i < Math.abs(count); i++) {
            longhead = longhead.next;
        }

        while (longhead != shorthead){
            longhead = longhead.next;
            shorthead = shorthead.next;
        }

        return longhead;
    }
}
