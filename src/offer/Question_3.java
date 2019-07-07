package offer;

import java.util.ArrayList;

/**
 * 数组中的重复数字
 */
public class Question_3 {

    public ArrayList<Integer> findRepeat(int[] arr){

        if (arr == null || arr.length < 2) {
            return null;
        }

        ArrayList<Integer> res = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {

            int m = arr[i];
            // 如果该数字正好和下标对应，则向后寻找
            // 否则和arr[m]判断是否相等
            if (m != i){
                // 如果该数字和下标为它的位置的数字相等，则找到重复的
                if (m == arr[m]){
                    res.add(m);
                }else {
                    // 如果不相等，则把它放入下标为它的位置
                    arr[i] = arr[m];
                    arr[m] = m;
                }
            }

        }

        return res;
    }

    // 不修改数组找出重复数字
    // 题目要求是 给出n个空间的数组，数字范围为[1..n],找出任意一个重复数字
    public int findRepeat2(int[] arr){

        if (arr == null || arr.length < 2) {
            return -1;
        }

        //  将[1..n]分为两部分，[1...mid],[mid+1..n] 计算在区间[1..mid]之间的数字个数
        // 如果个数大于区间范围(mid-1+1),则说明在[1..mid]之间存在重复数字
        // 继续对该区间划分，反之，左界限设置为mid+1 对另一部分划分
        int n = arr.length;
        int start = 1;
        int end = n-1;
        while (start <= end) {
            int mid = (end-start)/2 + start;
            int count = countRange(arr, n, start, mid);

            if (start == end && count > 1) return start;

            if (start == end) break;

            if (count > mid-start+1){
                end = mid;
            }else {
                start = mid+1;
            }
        }

        return -1;
    }

    // 计算数组中的数组 在区间[start, end]范围内的个数
    private int countRange(int[] arr, int n, int start, int end) {

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] >= start && arr[i] <= end){
                count ++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {2,3,1,4,6,5,6};
        ArrayList<Integer> repeat = new Question_3().findRepeat(arr);
        for (int i : repeat){
            System.out.println(i);
        }
        System.out.println("-------------------");
        System.out.println(new Question_3().findRepeat2(arr));
    }
}
