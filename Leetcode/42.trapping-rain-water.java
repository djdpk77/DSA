/*
 * @lc app=leetcode id=42 lang=java
 *
 * [42] Trapping Rain Water
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
 */

// @lc code=start
class Solution {
    public int trap(int[] height) {
        //Brute-force approach
        int n = height.length;
        int trappedWater = 0;

        for(int i = 0;i < n;i++){
            int leftMax = 0, rightMax = 0;

            for(int j = 0;j <= i;j++){
                leftMax = Math.max(leftMax, height[j]);
            }

            for(int j = i;j < n;j++){
                rightMax = Math.max(rightMax, height[j]);
            }

            trappedWater = trappedWater + Math.min(leftMax, rightMax) - height[i];
        }

        return trappedWater;
    }
}
// @lc code=end

