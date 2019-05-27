package algorithm.string;

/**
 * @author cicidi on 5/26/19
 * Lintcode 1045. Partition Labels
 * url https://www.lintcode.com/problem/partition-labels/my-submissions
 * Description
 * 中文
 * English
 * A string S of lowercase letters is given. We want to partition this string into as many parts as possible so that each letter appears in at most one part, and return a list of integers representing the size of these parts.
 * <p>
 * 1.S will have length in range [1, 500].
 * 2.S will consist of lowercase letters ('a' to 'z') only.
 * <p>
 * Have you met this question in a real interview?
 * Example
 * Example 1:
 * Input:  S = "ababcbacadefegdehijhklij"
 * Output:  [9,7,8]
 * <p>
 * Explanation:
 * The partitions are "ababcbaca", "defegde", "hijhklij".
 * A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
 * <p>
 * Example 2:
 * Input: S = "abcab"
 * Output:  [5]
 * <p>
 * Explanation:
 * We can not split it.Related Problems
 */

import java.util.*;

public class PartitionLabels {
    /**
     * @param S: a string
     * @return: a list of integers representing the size of these parts
     */
    public List<Integer> partitionLabels(String S) {
        // Write your code here
        if (S == null || S.length() == 0)
            return null;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < S.length(); i++) {
            Integer count = map.getOrDefault(S.charAt(i), 0);
            count++;
            map.put(S.charAt(i), count);
        }

        List<Integer> list = new ArrayList<Integer>();
        Set<Character> set = new HashSet<Character>();
        int start = 0;
        for (int i = 0; i < S.length(); i++) {
            set.add(S.charAt(i));
            Integer count = map.get(S.charAt(i));
            count--;
            if (count == 0) {
                set.remove(S.charAt(i));
            }
            map.put(S.charAt(i), count);
            if (set.size() == 0) {
                list.add(i + 1 - start);
                start = i + 1;
            }
        }
        return list;
    }
}
