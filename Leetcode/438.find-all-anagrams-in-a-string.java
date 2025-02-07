/*
 * @lc app=leetcode id=438 lang=java
 *
 * [438] Find All Anagrams in a String
 * Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.
 */

// @lc code=start

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        //Sliding window approach with hashmap
        List<Integer> result = new ArrayList<>();
        if(s.length() < p.length()) 
            return result;

        Map<Character, Integer> pCount = new HashMap<>();
        for(char c: p.toCharArray()){
            pCount.put(c, pCount.getOrDefault(c, 0) + 1);
        }

        int windowSize = p.length();
        Map<Character, Integer> sCount = new HashMap<>();

        for(int i = 0; i < windowSize; i++){
            sCount.put(s.charAt(i), sCount.getOrDefault(s.charAt(i), 0) + 1);
        }

        for(int i = 0; i < s.length() - windowSize + 1; i++){
            if(pCount.equals(sCount)){
                result.add(i);
            }

            //Move the window and Remove the old character going out of window
            char oldChar = s.charAt(i);
            sCount.put(oldChar, sCount.get(oldChar) - 1);
            if(sCount.get(oldChar)==0){
                sCount.remove(oldChar);
            }

            //Add new character coming into window
            if(i + windowSize < s.length()){
                char newChar = s.charAt(i + windowSize);
                sCount.put(newChar, sCount.getOrDefault(newChar, 0) + 1);
            }
        }

        return result;
    }
}
// @lc code=end

