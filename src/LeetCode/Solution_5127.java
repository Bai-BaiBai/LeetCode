package LeetCode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 5127. 数组的相对排序
 *
 * 给你两个数组，arr1 和 arr2，
 *      arr2 中的元素各不相同
 *      arr2 中的每个元素都出现在 arr1 中
 * 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
 *
 * 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * 输出：[2,2,2,1,4,3,3,9,6,7,19]
 */
public class Solution_5127 {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {

        if (arr1.length <= 0 || arr2.length <= 0) return arr1;

        int[] result = new int[arr1.length];
        int resultIndex = 0;
        int lastIndex = arr1.length-1;

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr1.length; i++) {
            if (!map.containsKey(arr1[i])){
                map.put(arr1[i], 1);
            }else {
                int count = (Integer) map.get(arr1[i]);
                map.put(arr1[i], count+1);
            }
        }

        for (int i = 0; i < arr2.length; i++) {
            if (map.containsKey(arr2[i])){
                int count = map.get(arr2[i]);
                for (int j = 0; j < count; j++) {
                    result[resultIndex++] = arr2[i];
                }
                map.remove(arr2[i]);
            }
        }

        for (int val : map.keySet()){
            int count = map.get(val);
            for (int i = 0; i < count; i++) {
                result[lastIndex--] = val;
            }
        }
        Arrays.sort(result, lastIndex+1, result.length);

        return result;
    }
}
