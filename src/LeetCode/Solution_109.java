package LeetCode;

/**
 * 109.有序链表转换二叉搜索树
 */
public class Solution_109 {

     public class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
     }

    public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }

    public TreeNode sortedListToBST(ListNode head) {

         if (head == null) return null;

         if (head.next == null) return new TreeNode(head.val);

         ListNode pre = head;
         ListNode slow = pre.next;
         ListNode fast = slow.next;

         while (fast != null && fast.next != null){
             pre = pre.next;
             slow = pre.next;
             fast = fast.next.next;
         }
         pre.next = null;
         TreeNode node = new TreeNode(slow.val);
         node.left = sortedListToBST(head);
         node.right = sortedListToBST(slow.next);
         return node;
    }

    private ListNode node;

    public TreeNode sortedListToBST2(ListNode head) {
        int n = 0;
        node = head;
        while(head != null){
            head = head.next;
            n++;
        }
        return toBST(0, n);
    }
    private TreeNode toBST(int start, int end){
        if(start == end) return null;
        int mid = (start + end) / 2;
        //遍历左子树并且将根节点返回
        TreeNode left = toBST(start, mid);
        //遍历当前根节点并进行赋值
        TreeNode root = new TreeNode(node.val);
        node = node.next; //指针后移，进行下一次的赋值
        root.left = left;
        //遍历右子树并且将根节点返回
        root.right = toBST(mid+1, end);
        return root;
    }

    private void test(){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        sortedListToBST2(node1);
    }

    public static void main(String[] args) {

        Solution_109 solution_109 = new Solution_109();

        solution_109.test();
    }

}
