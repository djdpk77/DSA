/*
 * @lc app=leetcode id=392 lang=java
 *
 * [392] Is Subsequence
 */

// @lc code=start
class Solution {
    public boolean isSubsequence(String s, String t) {
        //Approach using char array - O(n+m) space complexity 
        /* char[] str = t.toCharArray();
        char[] subsequence = s.toCharArray();
        int i=0;
        for(char c : str){
            if(i!=subsequence.length && subsequence[i] == c){
                i++;
            }
            if(i==subsequence.length){
                return true;
            }
        }    
        return (i==subsequence.length);     */

        //2 pointer approach
        /* int i,j;
        for (i = 0, j = 0; i < s.length() && j < t.length(); j++) {
            if(s.charAt(i) == t.charAt(j)){
                i++;
            }
        }
        return i==s.length(); */

        //Approach 3: using Dynamic Programming
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n+1][m+1];
        for(int i=0;i<=m;i++){
            dp[0][i] = 0;
        }
        for(int i=1;i<=n;i++){
            dp[i][0] = 0;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s.charAt(i-1) == t.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n][m]==n;
    }
}
// @lc code=end

