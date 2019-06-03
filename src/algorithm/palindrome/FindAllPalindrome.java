package algorithm.palindrome;

import java.util.Collections;
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
        Set<String> strings = new HashSet<String>();
        for (int i = 0; i < str.length(); i++) {
            scan(str, i, strings);
        }

        for (CharSequence string : printAllPalindromes(str)) {
            System.out.println(string);
        }
        System.out.println();
        for (String string : strings) {
            System.out.println(string);
        }

        System.out.println();
        allPalindromicSubStrings(str);
    }

    //this is wrong answer
    public static Set<CharSequence> printAllPalindromes(String input) {
        if (input.length() <= 2) {
            return Collections.emptySet();
        }
        Set<CharSequence> out = new HashSet<CharSequence>();
        int length = input.length();
        for (int i = 1; i <= length; i++) {
            for (int j = i - 1, k = i; j >= 0 && k < length; j--, k++) {
                if (input.charAt(j) == input.charAt(k)) {
                    out.add(input.subSequence(j, k + 1));
                } else {
                    break;
                }
            }
        }
        return out;
    }

    //this is wrong answer
    public static void scan(String str, int current, Set<String> results) {
        int start = current;
        int end = current;
        int length = str.length();
        for (; start >= 0 && end < length; ) {
            if (start == end && end + 1 < length && str.charAt(start) == str.charAt(end + 1)) {
                end++;
                continue;
            }
            if (start - 1 >= 0 && end + 1 < length && str.charAt(start - 1) == str.charAt(end + 1)) {
                start--;
                end++;
                continue;
            }
            break;
        }
        results.add(str.substring(start, end + 1));
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





