package offer;

import java.util.Stack;

public class Question_9 {

    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public Question_9() {
        this.stack1 = new Stack<>();
        this.stack2 = new Stack<>();
    }

    public void appendTail(int val){

        stack1.push(val);
    }

    public int deleteHead() throws Exception {

        if (stack2.empty()){
            while (!stack1.empty()){
                stack2.push(stack1.pop());
            }
        }
        if (stack2.empty()){
            throw new Exception("队列为空");
        }

        return stack2.pop();
    }

    public static void main(String[] args) {

        try {
            Question_9 queue = new Question_9();
            queue.appendTail(1);
            queue.appendTail(2);
            queue.appendTail(3);
            System.out.println(queue.deleteHead());
            queue.appendTail(4);
            queue.appendTail(5);
            System.out.println(queue.deleteHead());
            System.out.println(queue.deleteHead());
            System.out.println(queue.deleteHead());
            System.out.println(queue.deleteHead());
            System.out.println(queue.deleteHead());

        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
