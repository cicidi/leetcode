package palindrome;

import java.util.HashSet;
import java.util.Set;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

////aaaabbaaccgddcdcccddcc
//aabbaa
//cdc
//ccddcc

class FindAllPalindrome {
    public static void main(String[] args) {

        String str = "aaaabbaaccgddcdcccddcc";
        if (str == null || str.isEmpty()) {
            return;
        }
        allPalindromicSubStrings(str);
    }

    //important 这个答案是对的
    public static void expand(String str, int low, int high, Set<String> set) {
        // run till str[low.high] is a palindrome
        while (low >= 0 && high < str.length()
                && str.charAt(low) == str.charAt(high)) {
            // push all palindromes into the set
            set.add(str.substring(low, high + 1));

            // expand in both directions
            low--;
            high++;
        }
    }

    // Function to find all unique palindromic substrings of given String
    // notice 遍历这里面每一个字母
    // notice 然后由中间向两边扩展
    public static void allPalindromicSubStrings(String str) {
        // create an empty set to store all unique palindromic substrings
        Set<String> set = new HashSet<>();

        for (int i = 0; i < str.length(); i++) {
            // find all odd length palindrome with str[i] as mid point
            expand(str, i, i, set);

            // find all even length palindrome with str[i] and str[i+1]
            // as its mid points
            expand(str, i, i + 1, set);
        }

        // print all unique palindromic substrings
        System.out.print(set);
    }


}





