package algorithm;

/*
 * important
 * notice
 * green
 * url
 * leetcode
 *
 * 分析

 76. Minimum Window Substring
Hard

2350

159

Favorite

Share
Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

Example:

Input: S = "ADOBECODEBANC", T = "ABC"
Output: "BANC"
Note:

If there is no such window in S that covers all characters in T, return the empty string "".
If there is such window, you are guaranteed that there will always be only one unique minimum window in S.
 * */

   /*ADOBECODEBANC
     [A,0]
     [B,-1]
     [C,]

      word 		ADOBECODEBANC
      slow 		^
      fast		^
      current 	A
      match		1  2 3
      minLength      6    8
      start
   */

public class MinimumWindowSubstring {

    public static void main(String[] args) {
//        String[] input = new String[]{
//                "wrt", "wrf", "er", "ett", "rftt"
//        };
        Solution s = new Solution();


        System.out.println();
    }

    /*ADOBECODEBANC
     [A,0]
    */

    static class Solution {

    	public String minWindow(String s, String t){
    		int slow = 0;
    		int fast = 0;
    		Map<Character, Integer> map = new HashMap<>();
    		for (char c: s.toCharArray()){
    			Integer count = map.getOrDefault(c,0);
    			map.put(c,count+1);
    		}
    		int min = Math.max(Integer.MAX_VALUE);
    		StringBuilder sb = new StringBuilder();
    		int match=0;
    		while (fast<s.length()){
    			if (map.containsKey(s.charAt(fast))){
    				map.get(s.charAt(fast))-1;
    				sb.append(s.charAt(fast));
    				if(++match==3){
    					String  = trimString(s,slow,fast);
    				}
    			}
    		}
    	}
 
    

    }
}
