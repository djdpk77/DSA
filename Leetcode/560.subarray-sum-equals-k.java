/*
 * @lc app=leetcode id=560 lang=java
 *
 * [560] Subarray Sum Equals K
 * Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
 * A subarray is a contiguous non-empty sequence of elements within an array.
 * 
 */

// @lc code=start
class Solution {
    public int subarraySum(int[] nums, int k) {
        //Brute-force approach
        /* int n = nums.length;
        int sum = 0, count = 0;
        for(int i=0;i<n;i++){
            sum = 0;
            for(int j=i;j<n;j++){
                sum += nums[j];
                if(sum == k){
                    count++;
                }
            }
        }
        return count; */

        //Cumulative sum approach
        /* int count = 0;
        int cumulativeSum[] = new int[nums.length+1];
        cumulativeSum[0] = 0;

        for(int i=1;i<=nums.length;i++){
            cumulativeSum[i] = cumulativeSum[i-1] + nums[i-1];
        }

        for(int start=0;start<nums.length;start++){
            for(int end=start+1;end<=nums.length;end++){
                if(cumulativeSum[end] - cumulativeSum[start] == k){
                    count++;
                }
            }
        }
        return count; */

        //Hashmap approach
        int count = 0;
        int currentSum = 0;
        HashMap<Integer, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0, 1);

        for(int num : nums){
            currentSum += num;
            if(prefixSumCount.containsKey(currentSum - k)){
                count += prefixSumCount.get(currentSum - k);
            }

            prefixSumCount.put(currentSum, prefixSumCount.getOrDefault(currentSum, 0) + 1);
        }

        return count;
    }
}
// @lc code=end

