/*
 * @lc app=leetcode id=1 lang=java
 *
 * [1] Two Sum
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
            if(map.containsKey(diff)) {
                return new int[] {map.get(diff), i};
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

