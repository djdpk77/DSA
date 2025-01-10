/*
 * @lc app=leetcode id=2185 lang=java
 *
 * [2185] Counting Words With a Given Prefix
 */

// @lc code=start


class Solution {
    public int prefixCount(String[] words, String pref) {
        // int length = pref.length();
        // int count = 0;
        // for(int i=0;i<words.length;i++){
        //     if(words[i].length()>=length && words[i].substring(0,length).equals(pref)){
        //         count++;
        //     }
        // }
        // return count;

        // int count = 0;
        // for(String word : words) {
        //     if(word.startsWith(pref)){
        //         count++;
        //     }
        // }
        // return count;

        int count = 0;
        Trie trie = new Trie();

        for(String word : words){
            trie.addWord(word);
        }


        return trie.countPrefix(pref);
        
    }

    private class Trie
    {

        class Node
        {

            Node[] links;
            int count; //Number of strings having prefix till this node 

            Node(){
                links = new Node[26];
                count = 0;
            }
        }

        Node root;

        Trie(){
            root = new Node();
        }

        public void addWord(String word){
            Node curr = root;
            for(int i =0; i < word.length(); i++) {
                char c = word.charAt(i);
                if(curr.links[c - 'a'] == null){
                    curr.links[c - 'a'] = new Node();
                }
                curr = curr.links[c - 'a'];
                curr.count++;
            }
        }

        public int countPrefix(String pref) {
            Node curr = root;
            for(int i = 0; i < pref.length(); i++) {
                char c = pref.charAt(i);
                if(curr.links[c - 'a'] == null){
                    return 0;
                }
                curr = curr.links[c - 'a'];
            }
            return curr.count;
        }

    }
}
// @lc code=end

