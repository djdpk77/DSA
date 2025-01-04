
/* @lcpp=leetcode id=1 lang=java

[1] Two Sum
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

 

Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]
 */

import java.util.HashMap;
import java.util.Map;

// @lc code=start
class Solution {

    public int[] twoSum(int[] nums, int target) {
        // Brute force
        // for (int i = 0; i < nums.length; i++) {
        //     for (int j = i+1; j < nums.length; j++) {
        //         //if(i == j) 
        //         //    continue;
        //         if(nums[i] + nums[j] == target) {
        //             return new int[] {i, j};
        //         }
        //     }
        // }

        // Better solution hashing
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (map.containsKey(diff)) {
                return new int[]{map.get(diff), i};
            }
            map.put(nums[i], i);
        }

        //2 pointer approach - doesn't work for unsorted array
        // int left = 0;
        // int right = nums.length - 1;
        // Arrays.sort(nums);
        // while (left != right) {
        //     if (nums[left] + nums[right] == target) {
        //         return new int[]{left, right};
        //     } else if (nums[left] + nums[right] < target) {
        //         left++;
        //     } else {
        //         right--;
        //     }
        // }
        return new int[]{-1, -1};
    }
}
// @lc code=end

