/**
 * 11. 盛最多水的容器
 *
 * 链接：https://leetcode-cn.com/problems/container-with-most-water/
 */
public class Solution_11 {

    //双指针，每次移动短的那个线段，计算每一步的面积，直到指针重合
    public int maxArea(int[] height) {

        int i = 0;
        int j = height.length-1;
        int maxArea = 0;
        while (i < j){
            int area = (j-i) * Math.min(height[i], height[j]);
            if (area > maxArea) maxArea = area;
            if (height[i] < height[j]) i++;
            else j--;
        }

        return maxArea;
    }
}
