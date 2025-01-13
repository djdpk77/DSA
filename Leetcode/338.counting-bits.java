/*
 * @lc app=leetcode id=338 lang=java
 *
 * [338] Counting Bits
 * Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.
 */

// @lc code=start
class Solution {
    public int[] countBits(int n) {
        //Naive-approach - O(n * log(n))
        /* int[] res = new int[n + 1];
        for(int i=0;i<=n;i++){
            int count = 0;
            int num = i;
            while(num > 0){
                count = count + (num % 2);
                num = num / 2;
            }
            res[i] = count;
            
        }

        return res; */

        int[] res = new int[n + 1];
        res[0] = 0;
        for(int i=1;i<=n;i++){
            res[i] = res[i / 2] + (i % 2);
        }
        return res;

    }
}
// @lc code=end

