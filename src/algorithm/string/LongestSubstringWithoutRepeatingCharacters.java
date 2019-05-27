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
        // write your code here
        if (s == null || s.length() == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < s.length(); i++) {
            // Map<Character,Integer> map=new HashMap<Character,Integer>();
            Set<Character> set = new HashSet<Character>();
            int j = i;
            while (j < s.length()) {
                if (!set.contains(s.charAt(j))) {
                    set.add(s.charAt(j));
                    if (j - i + 1 > max) {
                        max = j - i + 1;
                        System.out.printf(" j %d i %d", j, i);
                    }
                    j++;
                } else {
                    break;
                }
            }
        }
        return max;
    }
}
