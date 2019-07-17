package offer;

/**
 * 剪绳子
 * 把一根长度为n的绳子剪成m段，使每段长度的乘积最大
 */
public class Question_14 {

    // 动态规划
    public int maxCutting(int length){

        if (length < 2) return 0;
        if (length == 2) return 1;
        if (length == 3) return 2;

        int[] res = new int[length+1];// 最终存储长度为i时的最优解
        // 先赋值为初始长度， 之后通过循环存入最优解
        // 当length<=3时已经直接返回最优解了
        res[0] = 0;
        res[1] = 1;
        res[2] = 2;
        res[3] = 3;

        int max = 0;
        for (int i = 4; i <= length; i++) {
            max = 0;
            for (int j = 1; j <= i / 2; j++) {
                int product = res[j] * res[i-j];
                if (product > max){
                    max = product;
                }
                res[i] = max;
            }
        }

        return res[length];
    }

    // 贪心算法
    public int findMaxResult(int length){

        if (length < 2) return 0;
        if (length == 2) return 1;
        if (length == 3) return 2;

        // 尽可能多的剪成长度为3的，timesOf3表示剪的长度为3的绳子数
        int timesOf3 = length/3;

        // 如果成立，说明只剪长度为3的绳子后最后剩余了 1个长度为1的绳子，
        // 此时策略是少剪一段长度为3的绳子，最后剩的长度是4，剪成2*2的
        if (length - 3 * timesOf3 == 1) timesOf3 --;

        int timesOf2 = (length - timesOf3*3)/2;

        return (int) (Math.pow(3, timesOf3) * Math.pow(2, timesOf2));
    }
}
