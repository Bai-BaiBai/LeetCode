package LeetCode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 9.回文数
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * 输入: 121
 * 输出: true
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 */
public class Solution_9 {

    /**
     * 例如数字：1221，只需要将数字的后一半取出来，与前一半做比较
     * 每次 half = half*10 + x%10, x/10 取出x的最后一位， 直到half >= x，即取出了一半
     *
     * 负数不可能是回文数，末尾是0的数也不可能是回文数
     */
    public boolean isPalindrome(int x) {
        if (x == 0) return true;
        if (x < 0 || x % 10 == 0) return false;

        int temp = x;
        int half = 0;
        while (half < temp){
            half *= 10;
            half += temp % 10;

            temp /= 10;
        }

        //如果数字位数是单数，如121，中间一位没有用，half/10消去
        return half == temp || half/10 == temp;
    }

    public boolean isPalindrome2(int x) {
        if (x < 0 ) return false;
        Queue<Integer> queue = new ArrayDeque<>();
        int temp = x;
        while (temp != 0){
            queue.add(temp%10);
            temp = temp/10;
        }
        while (!queue.isEmpty()){
            temp *= 10;
            temp += queue.poll();
        }
        return x == temp;
    }
}
