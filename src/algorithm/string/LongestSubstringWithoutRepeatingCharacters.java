package algorithm.string;

import java.util.HashSet;
import java.util.Set;

/**
 * @author cicidi on 5/26/19
 * Lintcode 384. Longest Substring Without Repeating Characters
 * url https://www.lintcode.com/problem/longest-substring-without-repeating-characters/my-submissions
 */
public class LongestSubstringWithoutRepeatingCharacters {
    /**
     * @param s: a string
     * @return: an integer
     */
    public int lengthOfLongestSubstring(String s) {
        int[] map = new int[256];
        int max = 0; // notice max start 0;
        for (int i = 0, j = 0; i < s.length(); i++) {  //notice j should start from 0 not 1, because i, j is not
            // notice  :  a range, it is old index, will future apperance index.
            while (j < s.length() && map[s.charAt(j)] == 0) {
                map[s.charAt(j)] = 1;
                max = Math.max(max, j - i + 1);
                j++;
            }
            map[s.charAt(i)] = 0; // notice  should reset to 0, and check another substring
            //notice  use 'i' here, because if use j, might get out of index
        }
        return max;
    }
}
