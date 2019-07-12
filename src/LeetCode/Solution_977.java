package LeetCode;

/**
 * 977. 有序数组的平方
 * 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
 * <p>
 * 输入：[-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * <p>
 * 输入：[-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 */
public class Solution_977 {

    // 按归并排序的思想，两个子数组一个是倒序一个是正序
    // 时间复杂度O(2n) 空间复杂度O(n)
    public int[] sortedSquares(int[] A) {
        if (A[0] >= 0) {//全是正数，直接平方返回
            for (int i = 0; i < A.length; i++) {
                A[i] *= A[i];
            }
            return A;
        }
        if (A[A.length - 1] <= 0) {//全是负数
            int[] B = new int[A.length];
            System.arraycopy(A, 0, B, 0, A.length);
            for (int i = 0; i < A.length; i++) {
                B[i] = A[A.length-1-i] * A[A.length-1-i];
            }
            return B;
        }

        int mid = 0;// [0...mid) 都是负数，[mid...n]都是正数
        while (A[mid] < 0) mid++;
        for (int i = 0; i < A.length; i++) {
            A[i] *= A[i];
        }
        //此时[0...mid)部分是从大到小排序，[mid...]部分是从小到大排序
        int[] result = new int[A.length];
        int i = 0;//负数下标
        int j = A.length - 1;//整数下标
        for (int k = A.length - 1; k >= 0; k--) {
            if (i < mid && j >= mid && A[i] > A[j]) {
                result[k] = A[i];
                i++;
            } else if (i < mid && j >= mid && A[i] <= A[j]) {
                result[k] = A[j];
                j--;
            } else if (i < mid && j < mid) {
                result[k] = A[i];
                i++;
            } else if (i >= mid && j >= mid) {
                result[k] = A[j];
                j--;
            }
        }

        return result;
    }
}
