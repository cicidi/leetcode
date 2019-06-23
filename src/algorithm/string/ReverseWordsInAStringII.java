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

    // yellow 这道题的重点在于 有没有space， 没有没有space 直接开心的reverse 整个string
    // notice 如果有space 那么记录space 比如end， 那么start 到end-1 之间要swap，  important 之后start的位置变成了end+1  ，end 等于 start 再加一 // 这个地方比较巧妙
    public char[] reverseWords(char[] str) {
        // write your code here'

        if (str.length == 0) {
            return str;
        }
        int start = 0, end = 1;
        boolean hasSpace = false;
        int length = str.length;
        for (; end < str.length; ) {
            if (end == length - 1 && hasSpace) {//notice 要check一下有没有space  如果不 check forloop 外面也有一个reverset
                //  notice 就reverse 回来了
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
