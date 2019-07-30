package string;

import java.util.*;

/**
 * @author cicidi on 5/26/19
 * Lintcode 425. Letter Combinations of a Phone Number
 * url https://www.lintcode.com/problem/letter-combinations-of-a-phone-number/description
 */

public class LetterCombinationsOfAPhoneNumber {
    /**
     * @param digits: A digital string
     * @return: all posible letter combinations
     */
    static Map<Character, char[]> map;

    static {
        map = createMapping();
    }

    public List<String> letterCombinations(String digits) {
        // write your code here
        List<String> list = new ArrayList<String>();
        if (digits == null || digits.length() == 0)
            return list;
        int length = digits.length();
        dfs(digits, 0, list, new StringBuilder());
        return list;
    }

    public void dfs(String digits, int index, List<String> result, StringBuilder sb) {
        if (index == digits.length()) {
            result.add(sb.toString());
            System.out.printf("result %s \n", sb.toString());
            return;
        }
        char[] arr = map.get(digits.charAt(index));
        for (char c : arr) {
            sb.append(c);
            dfs(digits, index + 1, result, sb);
            sb.deleteCharAt(index);
        }
    }

    public static Map<Character, char[]> createMapping() {

        Map<Character, char[]> map = new HashMap<Character, char[]>();
        map.put('2', new char[]{'a', 'b', 'c'});
        map.put('3', new char[]{'d', 'e', 'f'});
        map.put('4', new char[]{'g', 'h', 'i'});
        map.put('5', new char[]{'j', 'k', 'l'});
        map.put('6', new char[]{'m', 'n', 'o'});
        map.put('7', new char[]{'p', 'q', 'r', 's'});
        map.put('8', new char[]{'t', 'u', 'v'});
        map.put('9', new char[]{'w', 'x', 'y', 'z'});

        return map;

    }
}
