/*
 * @lc app=leetcode id=49 lang=java
 *
 * [49] Group Anagrams
 * Given an array of strings, group anagrams together.
 */

// @lc code=start

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //Approach 1: Sorting approach
        /* Map<String, List<String>> anagramMap = new HashMap<>();

        for(String word : strs){
            char[] charArray = word.toCharArray();

            Arrays.sort(charArray);

            String sortedWord = new String(charArray);

            if(!anagramMap.containsKey(sortedWord)){
                anagramMap.put(sortedWord, new ArrayList<>());
            }

            anagramMap.get(sortedWord).add(word);
        }

        return new ArrayList<>(anagramMap.values()); */

        //Approach 2: Counting approach
        Map<String, List<String>> anagramMap = new HashMap<>();

        for(String word : strs){
            int[] charCount = new int[26];

            for(char c : word.toCharArray()){
                charCount[c - 'a']++;
            }

            StringBuilder sb = new StringBuilder();
            for(int count: charCount){
                sb.append(count);
                sb.append("#");
            }
            String key = sb.toString();

            if(!anagramMap.containsKey(key)){
                anagramMap.put(key, new ArrayList<>());
            }

            anagramMap.get(key).add(word);
        }

        return new ArrayList<>(anagramMap.values());
    }
}
// @lc code=end

