/*
 * @lc app=leetcode id=647 lang=java
 *
 * [647] Palindromic Substrings
 * Given a string s, return the number of palindromic substrings in it.
 * A string is a palindrome when it reads the same backward as forward.
 * A substring is a contiguous sequence of characters within the string.
 */

// @lc code=start
class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        for(int i=0; i<s.length(); i++) {
            count += countPalindromes(s, i, i);
            count += countPalindromes(s, i, i+1);
        }
        return count;
    }

    public int countPalindromes(String s, int left, int right) {
        int count = 0;
        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)) {
            count++;
            left--;
            right++;
        }
        return count;
    }
}
// @lc code=end

