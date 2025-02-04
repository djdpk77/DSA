/*
 * @lc app=leetcode id=15 lang=java
 *
 * [15] 3Sum
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //Brute force approach
        List<List<Integer>> result = new ArrayList<>();

        for(int i = 0;i < nums.length - 2;i++){
            for(int j = i+1;j < nums.length - 1;j++){
                for(int k = j+1;k < nums.length;k++){
                    if(nums[i] + nums[j] + nums[k] == 0){
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        Collections.sort(list);
                        if(!result.contains(list)){
                            result.add(list);
                        }
                    }
                }
            }
        }

        return result;
    }
}
// @lc code=end

