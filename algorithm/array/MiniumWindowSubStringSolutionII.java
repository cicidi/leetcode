package array;

/*
 * important
 * notice
 * green
 * url
 * leetcode
 *
 * 分析
 * */

import java.util.HashMap;
import java.util.Map;

public class MiniumWindowSubString {

    public static void main(String[] args) {
//        String[] input = new String[]{
//                "wrt", "wrf", "er", "ett", "rftt"
//        };
        String s = "ADOBECODEBANC";
        String t = "ABC";
        Solution soultion = new Solution();
        System.out.println(soultion.minWindow(s, t));
    }

    static class Solution {
        String minWindow(String s, String t) {
            if (s == null || t == null || s.length() < t.length()) {
                return "";
            }

            Map<Character, Integer> wordDict = this.convertToMap(t);
            int left = 0, minLen = Integer.MAX_VALUE, matchCount = 0, ansLeft = 0;  // important 一开始 minLen = max
            for (int right = 0; right < s.length(); right++) {
                char ch = s.charAt(right);
                if (wordDict.containsKey(ch)) {   // notice 先看当前char 是否是t 里面的， 因为是move fast ，所以如果不是T里面的，可以直接skip 掉了
                    int count = wordDict.get(ch);
                    count -= 1; // notice count 因为已经找到了一个，所以 还需要找的数量就 -1
                    wordDict.put(ch, count);
                    // notice 如果 当前count == 0 就说明 这个一个char 已经完全match完毕了
                    if (count == 0) {
                        matchCount++;
                    }
                    //notice  从左开始收缩
                    while (matchCount == wordDict.size()) {
                        // notice 先取 最小minLen
                        if (right - left + 1 < minLen) {
                            minLen = right - left + 1;
                            ansLeft = left;
                        }
                        //
                        char leftMost = s.charAt(left); // notice 先看看最左边是谁
                        left += 1; // important 不要忘记把slow 往右走一步
                        if (wordDict.containsKey(leftMost)) {
                            int leftMostCount = wordDict.get(leftMost);
                            leftMostCount++;
                            //notice 也就是说leftMostCount 从0变到1 了，matchCount 也就少了一个
                            if (leftMostCount == 1) {
                                matchCount -= 1;
                            }
                            wordDict.put(leftMost, leftMostCount);
                        }
                    }
                }
            }
            return minLen == Integer.MAX_VALUE ? "" : s.substring(ansLeft, ansLeft + minLen);
        }

        Map<Character, Integer> convertToMap(String target) {
            Map<Character, Integer> map = new HashMap<>();
            for (char c : target.toCharArray()) {
                Integer count = map.getOrDefault(c, 0);
                map.put(c, count + 1);
            }
            return map;
        }
    }
}
