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
        int i,j;
        for (i = 0, j = 0; i < s.length() && j < t.length(); j++) {
            if(s.charAt(i) == t.charAt(j)){
                i++;
            }
        }
        return i==s.length();
    }
}
// @lc code=end

