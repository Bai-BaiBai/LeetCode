package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 448. 找到所有数组中消失的数字
 */
public class Solution_448 {

    public List<Integer> findDisappearedNumbers(int[] nums) {

        List<Integer> res = new ArrayList<>();
        if (nums.length < 1) return res;

        for (int i = 0; i < nums.length;) {
            if (nums[i] == i+1 || nums[i] == nums[nums[i]]){
                i++;
            }else {
                int temp = nums[nums[i]-1];
                nums[nums[i]-1] = nums[i];
                nums[i] = temp;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i+1){
                res.add(i+1);
            }
        }

        return res;
    }


}
