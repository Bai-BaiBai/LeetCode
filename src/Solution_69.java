/**
 * 69. x 的平方根
 * 实现 int sqrt(int x) 函数。
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 *      由于返回类型是整数，小数部分将被舍去。
 */
public class Solution_69 {

    // 使用牛顿法
    // 随便猜一个s，不断令s = (s+x/s)/2
    public int mySqrt(int x) {

        int s = x;
        if (x == 0) return 0;
        return (int) sqrt(x, s);
    }

    public double sqrt(double x, double s){
        double res = (x + s/x)/2;
        if (res == x){
            return x;
        }else {
            return sqrt(res, s);
        }
    }
}
