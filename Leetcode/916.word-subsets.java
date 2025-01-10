/*
 * @lc app=leetcode id=916 lang=java
 *
 * [916] Word Subsets
 * You are given two string arrays words1 and words2
 * A string b is a subset of string a if every letter in b occurs in a including multiplicity
 * For example, "wrr" is a subset of "warrior" but is not a subset of "world"
 * A string a from words1 is universal if for every string b in words2, b is a subset of a
 * Return an array of all the universal strings in words1. You may return the answer in any order 
 */

// @lc code=start

import java.util.*;

class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> universalStrings = new ArrayList<>();
        
        int words2MaxFreq[] = new int[26];
        for(String word: words2){
            int freq[] = createFrequencyArray(word);
            for(int i=0;i<26;i++){
                words2MaxFreq[i] = Math.max(words2MaxFreq[i], freq[i]);
            }
        }

        for(String word: words1){
            int freq[] = createFrequencyArray(word);
            boolean isUniversal = true;
            for(int i=0;i<26;i++){
                if(freq[i] < words2MaxFreq[i]){
                    isUniversal = false;
                    break;
                }
            }
            if(isUniversal){
                universalStrings.add(word);
            }
        }

        return universalStrings;
    }
    
    public int[] createFrequencyArray(String word){
        int freq[] = new int[26];
        for(char c: word.toCharArray()){
            freq[c-'a']++;
        }
        return freq;
    }
                
}
// @lc code=end

