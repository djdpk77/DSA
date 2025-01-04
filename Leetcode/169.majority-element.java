/*
 * @lc app=leetcode id=169 lang=java
 *
 * [169] Majority Element
 * Given an array nums of size n, return the majority element.
 * The majority element is the element that appears more than ⌊n / 2⌋ times.
 * You may assume that the majority element always exists in the array.
 */

// @lc code=start
import java.util.Arrays;

class Solution {

    public int majorityElement(int[] nums) {
        //Brute force method
        /* for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
            }
            if (count > nums.length / 2) {
                return nums[i];
            }
        }
        return -1; */

        /* Map<Integer, Integer> map = new HashMap<>();
        for(int n: nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
            if(map.get(n) > nums.length/2) {
                return n;
            }
        }
        return -1; */

        //Sorting method
        /* Arrays.sort(nums);
        return nums[nums.length/2]; */

        //Boyer-Moore Voting Algorithm
        int count = 0;
        int candidate = 0;
        for (int n : nums) {
            if (count == 0) {
                candidate = n;
            }
            count += (n == candidate) ? 1 : -1;
        }
        return candidate;
    }
}
// @lc code=end

