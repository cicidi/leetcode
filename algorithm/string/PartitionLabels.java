package string;

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

    // notice 用了几个技巧， 第一 先把所有char都计算出来出现次数
    // notice 第二用一个set 记录每次发生一次添加一个char 就给他记录进来
    // notice 当然同时在map 里面把他的count 给-1
    // notice 最后如果set 里面没有当前这个char 了  就可以切割了，记录切割时候的index
    // notice 启动位置用start 记录，因为这道题求的是每一段的长度
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
