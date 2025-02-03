/*
 * @lc app=leetcode id=11 lang=java
 *
 * [11] Container With Most Water
 * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i])
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 * Return the maximum amount of water a container can store.
 * 
 * Notice that you may not slant the container.
 * 
 */

// @lc code=start
class Solution {
    public int maxArea(int[] height) {
        int left =0,right=height.length-1;
        int area=0,maxArea=0;
        while(left<right){
            area = Math.min(height[left],height[right])*(right-left);
            if(area>maxArea){
                maxArea = area;
            }
            
            if(height[left]<height[right]){
                left++;
            }else{
                right--;
            }
        }

        return maxArea;
    }
}
// @lc code=end

