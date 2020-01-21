package string;/*
 * @lc app=leetcode id=97 lang=java
 *
 * [97] Interleaving String
 *
 * https://leetcode.com/problems/interleaving-string/description/
 *
 * algorithms
 * Hard (29.04%)
 * Total Accepted:    129.2K
 * Total Submissions: 437.6K
 * Testcase Example:  '"aabcc"\n"dbbca"\n"aadbbcbcac"'
 *
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and
 * s2.
 * 
 * Example 1:
 * 
 * 
 * Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
 * Output: false
 * 
 * 
 */
// This solution passed lintcode but not leetcode ,need to improve.
// char Map<Char, Q<Poition>>.  int index last s1  last s2
// if p
//
// find from Q return c
//        if q.size == emtpy  remove q
// create dictory use dfs create pair of dic, check if the dic == input.       
import java.util.*;
class  InterLeavingString{
    public boolean isInterleave(String s1, String s2, String s3) {
          return search(0, 0, 0, new Pair(), s1, s2, s3); 
    }

    public boolean search(int i1, int i2, int i3, Pair p, String s1, String s2, String s3){
        
        if (i3 >= s3.length()){
            System.out.println("1");
            return match(p, s1, s2);
        }
        if (i1 < s1.length() && s1.charAt(i1) == s3.charAt(i3)){
            System.out.println("2");
            p.w1.append(s1.charAt(i1));
            boolean found = search(i1 + 1, i2, i3 + 1, p, s1, s2, s3);
            if (found){
                return found;
            }
            p.w1.deleteCharAt(p.w1.length() - 1);
        } 
        if (i2 < s2.length() && s2.charAt(i2) == s3.charAt(i3)){
            System.out.println("3");
            p.w2.append(s2.charAt(i2));
            boolean found = search(i1 , i2 + 1, i3 + 1, p, s1, s2, s3);
            if (found) {
                return found;
            }
            p.w2.deleteCharAt(p.w2.length() - 1);
        }
        System.out.println("4");
        return false;
    }

    public boolean match (Pair p , String s1, String s2){
          System.out.println("3");
         boolean found  = (p.w1.toString().equals(s1) && p.w2.toString().equals(s2))
         || (p.w1.toString().equals(s2) && p.w2.toString().equals(s1));
          System.out.println(p.w1.toString());
          System.out.println(p.w2.toString());

         return found;
    }

    public static void main(String[] args){
        InterLeavingString i = new InterLeavingString();
       // boolean found = i.isInterleave("aabcca", "dbbca", "aadbbcbcac");
         boolean found = i.isInterleave("aabcc",  "dbbca",  "aadbbbaccc");
        System.out.println(found);
    }
}

class Pair {
    StringBuilder w1 = new StringBuilder();
    StringBuilder w2 = new StringBuilder();
}
