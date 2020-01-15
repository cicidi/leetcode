/*
 * @lc app=leetcode id=93 lang=java
 *
 * [93] Restore IP Addresses
 *
 * https://leetcode.com/problems/restore-ip-addresses/description/
 *
 * algorithms
 * Medium (32.55%)
 * Total Accepted:    160.2K
 * Total Submissions: 485.5K
 * Testcase Example:  '"25525511135"'
 *
 * Given a string containing only digits, restore it by returning all possible
 * valid IP address combinations.
 * 
 * Example:
 * 
 * 
 * Input: "25525511135"
 * Output: ["255.255.11.135", "255.255.111.35"]
 * 
 * 
 */
class Solution {
    public List<String> restoreIpAddresses(String s) {
        return this.search("", -1, -1, 0, s, new HashSet<String>()); 
    }

    public void search(String prev, int i, int j, int p, String s, Set <String> result){
        if (p > 4){
            result.add(prev)
            return 
        }
        if(dig(i,j) > 255){
            return
        }
        String cur = prev + String.valueOf(dig) + ".";
        for (int m = 0; m < 3, m ++){
            search(prev, j + 1, m, p + 1, s);
        }
        return result;

    }
    // cover 0  this is a edge case
   public  String dig(int i, int j, String s){
        if (i < 0 || j < 0) return "";
        int num = 0;
    
        for (; i <= j; i++){
            nums += Math.power(10, j - i) * s.substring(i);
        }
        return String.valueOf(num);
   }
}
