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

    public static void main(String[] args) {
        int[] arr = {2,3,1,0,2,5,3};
        ArrayList<Integer> repeat = new Question_3().findRepeat(arr);
        for (int i : repeat){
            System.out.println(i);
        }
    }
}
