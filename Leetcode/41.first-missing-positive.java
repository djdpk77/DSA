
import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode id=41 lang=java
 *
 * [41] First Missing Positive
 * Given an unsorted integer array nums. Return the smallest positive integer that is not present in nums.
 * You must implement an algorithm that runs in O(n) time and uses constant extra space.
 */

// @lc code=start
class Solution {
    public int firstMissingPositive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (int i = 1; i <= nums.length+1; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return -1;
    }
}
// @lc code=end

