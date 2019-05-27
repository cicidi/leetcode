package algorithm.string;

/**
 * @author cicidi on 5/26/19
 * Lintcode 927. Reverse Words in a String II
 * url https://www.lintcode.com/problem/reverse-words-in-a-string-ii/description
 */

public class ReverseWordsInAStringII {
    /**
     * @param str: a string
     * @return: return a string
     */
    public char[] reverseWords(char[] str) {
        // write your code here'

        if (str.length == 0) {
            return str;
        }
        int start = 0, end = 1;
        boolean hasSpace = false;
        int length = str.length;
        for (; end < str.length; ) {
            if (end == length - 1 && hasSpace) {
                reverse(str, start, end);
            }
            if (str[end] == ' ') {
                reverse(str, start, end - 1);
                start = end + 1;
                end = start + 1;
                hasSpace = true;
            } else {
                end++;
            }
        }
        reverse(str, 0, length - 1);
        return str;
    }

    public void reverse(char[] str, int start, int end) {
        for (; start < end; start++, end--) {
            char tmp = str[start];
            str[start] = str[end];
            str[end] = tmp;
        }
    }
}
