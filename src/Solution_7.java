/**
 * 7.整数反转
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 输入: 123
 * 输出: 321
 * 输入: -123
 * 输出: -321
 * 输入: 120
 * 输出: 21
 *
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 */
public class Solution_7 {

    /**
     * 用一个变量存储过程结果，每次将暂存结果/10与上一步结果比较，如果不等则发生了溢出
     */
    public int reverse(int x) {
        int res = 0;
        while (x != 0){
            int temp = res * 10 + x % 10;
            if (res != temp/10){
                return 0;
            }
            res = temp;
            x = x / 10;
        }
        return res;
    }

    /**
     * 使用StringBuilder的reverse函数反转
     *
     */
    public int reverse2(int x){

        if (x == 0) return 0;
        int flag = x > 0 ? 1 : -1;
        String a = String.valueOf(Math.abs(x));
        a = new StringBuilder(a).reverse().toString();
        try {
            return flag * Integer.valueOf(a);
        }catch (Exception e){
            return 0;
        }

    }
}
