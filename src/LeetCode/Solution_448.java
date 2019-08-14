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

    /**
     * 遍历数组，将数组中各个数字绝对值作为下标，将该下标中的数字置为负值
     * 第二遍遍历，数组中不为负数的位置即为消失的数字
     * @param nums
     * @return
     */
    public List<Integer> findDisappearedNumbers2(int[] nums) {

        List<Integer> res = new ArrayList<>();
        if (nums.length < 1) return res;

        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i])-1;
            nums[index] = 0-Math.abs(nums[index]);
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0){
                res.add(i+1);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,3,2,1};
        new Solution_448().findDisappearedNumbers2(nums);
    }
}
