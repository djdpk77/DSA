/*
 * @lc app=leetcode id=238 lang=java
 *
 * [238] Product of Array Except Self
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 * You must write an algorithm that runs in O(n) time and without using the division operation.
 */

// @lc code=start
class Solution {
    public int[] productExceptSelf(int[] nums) {
        //Brute force approach
        /* int output[] = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            output[i] = 1;
            for (int j = 0; j < nums.length; j++) {
                if (i != j) {
                    output[i] *= nums[j];
                }
            }
        }
        return output; */

        //Prefix and Suffix product approach
        /* int output[] = new int[nums.length];
        int prefix[] = new int[nums.length];
        int suffix[] = new int[nums.length];

        prefix[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i-1] * nums[i-1];           
        }

        suffix[nums.length-1] = 1;
        for (int i = nums.length-2; i >= 0; i--) {
            suffix[i] = suffix[i+1] * nums[i+1];
        }

        for (int i = 0; i < nums.length; i++) {
            output[i] = prefix[i] * suffix[i];
        }
        return output; */

        //Optimized approach
        int output[] = new int[nums.length];

        output[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            output[i] = output[i-1] * nums[i-1];
        }

        int suffix = 1;
        for (int i = nums.length-1; i >= 0; i--) {
            output[i] = output[i] * suffix;
            suffix *= nums[i];
        }
        return output;
    }
}
// @lc code=end

