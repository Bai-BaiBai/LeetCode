package LeetCode;

/**
 * 66.加一
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 */
public class Solution_66 {

    public int[] plusOne(int[] digits) {

        int index = digits.length-1;
        digits[index] ++;
        boolean flag = false;//进位标志位
        while (index >= 0){
            if (flag){
                digits[index]++;
                flag = false;
            }

            if (digits[index] > 9){
                flag = true;
                digits[index] %= 10;
            }
            index--;
        }

        if (flag){
            int[] result = new int[digits.length+1];
            result[0] = 1;
            for (int i = 0; i < digits.length; i++) {
                result[i+1] = digits[i];
            }
            return result;
        }
        return digits;
    }

    //如果最后一位没有进位直接返回即可，以此类推。如果digits[0]也为0,说明需要扩展一位
    public int[] plusOne2(int[] digits){
        for (int i = digits.length-1; i >= 0 ; i--) {
            digits[i]++;
            digits[i] %= 10;
            if (digits[i] != 0) return digits;
        }
        digits = new int[digits.length+1];
        digits[0] = 1;//这种情况下，只可能是..999+1,第一位是1，后面全是0
        return digits;
    }
}
