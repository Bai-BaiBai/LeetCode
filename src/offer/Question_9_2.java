package offer;

import java.util.ArrayDeque;
import java.util.Queue;

public class Question_9_2 {

    private Queue<Integer> queue1;
    private Queue<Integer> queue2;

    public Question_9_2() {
        this.queue1 = new ArrayDeque<>();
        this.queue2 = new ArrayDeque<>();
    }

    public void add(int val){

        // 两个队列均为空
        if (queue1.isEmpty() && queue2.isEmpty()){
            queue1.add(val);
            return;
        }
        // 其中一个为空，将val放入不为空的队列中
        if (queue1.size() > 0){
            queue1.add(val);
        } else {
            queue2.add(val);
        }
    }

    public int remove() throws Exception {

        if (queue2.isEmpty() && !queue1.isEmpty()){

            while (queue1.size() != 1){
                queue2.add(queue1.remove());
            }
            return queue1.remove();

        } else if (queue1.isEmpty() && !queue2.isEmpty()){

            while (queue2.size() != 1){
                queue1.add(queue2.remove());
            }
            return queue2.remove();
        } else {
            throw new Exception("栈为空");
        }
    }

    public static void main(String[] args) {
        Question_9_2 stack = new Question_9_2();
        try {
            stack.add(1);
            stack.add(2);
            stack.add(3);
            System.out.println(stack.remove());
            System.out.println(stack.remove());
            stack.add(4);
            stack.add(5);
            System.out.println(stack.remove());
            System.out.println(stack.remove());
            System.out.println(stack.remove());
            System.out.println(stack.remove());

        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
