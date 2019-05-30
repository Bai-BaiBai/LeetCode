import java.util.*;

/**
 * LeetCode 1号问题--两数之和
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9  所以返回 [0, 1]
 */
public class Solution_1 {

    /**
     * 将每个值放入到Map中，key为值，value为下标
     * 放入之前先检查target-key是不是存在，如果存在则返回这两个下标，不存在则将值放入map
     *
     */
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];
            res[0] = i;
            if (map.containsKey(target-a)){
                res[1] = map.get(target-a);
                return res;
            }else {
                map.put(a, i);
            }
        }
        return res;
    }
}
