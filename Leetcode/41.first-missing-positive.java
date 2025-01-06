
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
        //Brute force approach
        /* int n = nums.length;
        for (int i = 1; i <= n + 1; i++) {
            boolean found = false;

            for (int num : nums) {
                if (num == i) {
                    found = true;
                    break;
                }
            }

            if (!found) return i;
        }
        return -1;  */

        // Hashset approach
/*         Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (int i = 1; i <= nums.length+1; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return -1; */

        //Inplace approach
        int n = nums.length;
        int temp;
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[i]!= (i+1) && nums[i]!=nums[nums[i]-1]) {
                temp = nums[nums[i]-1];
                nums[nums[i]-1] = nums[i];
                nums[i] = temp;
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] != i+1) {
                return i+1;
            }
        }
        return n+1;
    }
}
// @lc code=end

