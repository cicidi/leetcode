package array;

/*
 * important
 * notice
 * green
 * url
 * leetcode
 *
    Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
    
    Example:
    
    Input: S = "ADOBECODEBANC", T = "ABC"
    Output: "BANC"
    Note:
    
    If there is no such window in S that covers all characters in T, return the empty string "".
    If there is such window, you are guaranteed that there will always be only one unique minimum window in S.
 * 分析
 * ADOBECODEBANC
 * ^    ^
 *    ^ ^^^^^^
 *      ^^^^^^
 *      ^^^^^^^^
 *          ^^^^
 * 
 *
 *
 * */

/*
 *left      right  matchCount
   0        0         1
            1           
            .         .  
            .         .
            5         3  
================  review ====================
* May 27 2020
*
=============================================
04/30/2020 
1. Need a map to know how many occurance of each character in the target. for example in this case target = "ABC" then the map [A = 1, B = 1, C = 1]
2. Need a match count to know if all the character has been found in the subString 
3. Need a answerLeft index, Whenever matchCounter is 0, and the current lenght is less then minLen, then set answerLeft = currentLeft(left)
4. Need a currentLeft pointer and a right pointer. 
5. When match Counter is 0 , then need to move left to right, 
    if the occuance of the left character change from 0 to 1. Then it means  matchCount should minus 1
 * */


import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubString {

    public static void main(String[] args) {
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
            // important 一开始 minLen = max
            int left = 0, minLen = Integer.MAX_VALUE, matchCount = 0, ansLeft = 0;
            for (int right = 0; right < s.length(); right++) {
                char ch = s.charAt(right);
                // notice 先看当前char 是否是t 里面的， 因为是move fast ，所以如果不是T里面的，可以直接skip 掉了
                if (wordDict.containsKey(ch)) {
                    int count = wordDict.get(ch);
                    count--; // notice count 因为已经找到了一个，所以 还需要找的数量就 -1
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
                        // important 不要忘记把slow 往右走一步
                        if (wordDict.containsKey(leftMost)) {
                            count = wordDict.get(leftMost);
                            count++;
                            //notice 也就是说leftMostCount 从0变到1 了，matchCount 也就少了一个
                            if (count == 1) {
                                matchCount -= 1;
                            }
                            wordDict.put(leftMost, count);
                        }
                        left++;
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

/*
* ========count==========
A B C    	matchCount	1
0 1 1	 	1

A B C 		matchCount	2
0 1 1		1

A B C 		matchCount	3
0 1 1		1

A B C 		matchCount	4
0 0 1		2

A B C 		matchCount	5
0 0 0		2

A B C 		matchCount	6
0 0 0		3

A B C 		matchCount	7
1 0 0		2

A B C 		matchCount	8
1 0 0		3

A B C 		matchCount	9
1 0 0		3

A B C 		matchCount	10
1 -1 0		2

A B C 		matchCount	11
0 -1 0		3

A B C 		matchCount	12
0 0 0		3

A B C 		matchCount	13
0 1 0		2


=========index=========
indexOfArray  	indexOfT 	1
0-0				0
indexOfArray  	indexOfT	2
0-1				1
indexOfArray  	indexOfT	3
0-2				1
indexOfArray  	indexOfT	4
0-3				2
indexOfArray  	indexOfT	5
0-4				2
indexOfArray  	indexOfT	6
0-5				0
indexOfArray  	indexOfT	7
3-7				0
indexOfArray  	indexOfT	8
3-8				0
indexOfArray  	indexOfT	9
3-9				0
indexOfArray  	indexOfT	10
3-10			0
indexOfArray  	indexOfT	11
5-10			1
indexOfArray  	indexOfT	12
5-12			2
indexOfArray  	indexOfT	13
5-12			2
indexOfArray  	indexOfT	14
6-12			2
indexOfArray  	indexOfT	15
9-12			2
indexOfArray  	indexOfT	16
10-12			2


* */
