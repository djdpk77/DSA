/*
 * @lc app=leetcode id=260 lang=java
 *
 * [260] Single Number III
 * Given an integer array nums, in which exactly two elements appear only once and all the other elements appear exactly twice. 
 * Find the two elements that appear only once. You can return the answer in any order.
 * You must write an algorithm that runs in linear runtime complexity and uses only constant extra space.
 */

// @lc code=start

import java.util.HashMap;
class Solution {
    public int[] singleNumber(int[] nums) {
        //Using Hashmap
        /* HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        int[] res = new int[2];
        int index = 0;
        for(int num : nums) {
            if(map.get(num)==1) {
                res[index++] = num;
            }
        }

        return res; */

        //Concept of buckets
        int xorr = 0;
        for (int num : nums) {
            xorr = xorr ^ num;
        }

        int rightmostSetBit = xorr & -xorr;

        int b1 = 0, b2 = 0;
        for(int num : nums) {
            if((num & rightmostSetBit)==0) {
                b1 = b1 ^ num;
            } else {
                b2 = b2 ^ num;
            }
        }
        return new int[]{b1,b2};
    }
}
// @lc code=end

