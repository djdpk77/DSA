

/*
 * @lc app=leetcode id=151 lang=java
 *
 * [151] Reverse Words in a String
 * Given an input string s, reverse the order of the words.
 * A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.
 * Return a string of the words in reverse order concatenated by a single space.
 * Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.
 */
// @lc code=start
class Solution {

    public String reverseWords(String s) {
        /* s = s.trim();
        String sentence = removeExtraSpaces(s);
        StringBuilder reversedString = new StringBuilder("");
        String[] words = sentence.split(" ");
        for(int i = words.length-1;i>=0;i--){
            reversedString.append(words[i]).append(" ");
        }
        reversedString.delete(reversedString.length()-1, reversedString.length());

        return reversedString.toString(); */

 /*Built-in function approach
         String words[] = s.trim().split("\\s+");

        StringBuilder reversedString = new StringBuilder("");
        for (int i = words.length-1; i <=0 ; i++) {
            reversedString.append(words[i]);
            if(i!=0){
                reversedString.append(" ");
            }
        }

        return reversedString.toString(); */
        //Deque approach
        /* int left = 0;
        int right = s.length() - 1;

        while (left <= right && s.charAt(left) == ' ') {
            left++;
        }
        while (left <= right && s.charAt(right) == ' ') {
            right--;
        }

        Deque<String> deque = new LinkedList<>();
        StringBuilder word = new StringBuilder();

        while (left <= right) {
            char c = s.charAt(left);

            if ((word.length() != 0) && c == ' ') { //We encountered a space and this indicates the word is complete
                deque.offerFirst(word.toString());
                word.setLength(0);
            }else if (c != ' ') {  //Keep appending non-space characters to the word
                word.append(c);
            }

            left++;
        }

        deque.offerFirst(word.toString());  //Add the last word to the deque

        return String.join(" ", deque); */
        //Two pointer approach
        char[] str = s.toCharArray();

        reverse(str, 0, str.length - 1);

        reverseWords(str);

        return removeExtraSpaces(str);

    }

    private String removeExtraSpaces(char[] str) {
        int start = 0;
        int end = str.length - 1;
        while (start <= end && str[start] == ' ') {
            start++;
        }
        while (start <= end && str[end] == ' ') {
            end--;
        }
        for(int i = start;i<=end;i++){
            if(str[i] == ' ' && str[i+1] == ' '){
                for(int j = i;j<str.length-1;j++){
                    str[j] = str[j+1];
                }
                i--;
                end--;
            }
        }
        return new String(str, start, end - start + 1);
    }

    private void reverseWords(char[] str) {
        int n = str.length;
        int start = 0;
        int end = 0;
        for (; end < n; end++) {
            if (str[end] == ' ') {
                reverse(str, start, end - 1);
                start = end + 1;
            }
        }

        reverse(str, start, n - 1);
    }

    private void reverse(char[] str, int left, int right) {
        while (left < right) {
            char temp = str[left];
            str[left++] = str[right];
            str[right--] = temp;
        }
    }

    private String removeExtraSpaces(String s) {
        StringBuilder sentence = new StringBuilder("");
        int counter = 0;
        for (char c : s.toCharArray()) {
            if (counter == 1 && c != ' ') {
                counter = 0;
            }
            if (counter == 0) {
                sentence.append(c);
            }
            if (counter == 0 && c == ' ') {
                counter = 1;
            }
        }

        return sentence.toString();
    }
}
// @lc code=end

