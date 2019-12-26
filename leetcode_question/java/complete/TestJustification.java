/*
 * @lc app=leetcode id=68 lang=java
 *
 * [68] Text Justification
 *
 * https://leetcode.com/problems/text-justification/description/
 *
 * algorithms
 * Hard (24.52%)
 * Total Accepted:    112.2K
 * Total Submissions: 448K
 * Testcase Example:  '["This", "is", "an", "example", "of", "text", "justification."]\n16'
 *
 * Given an array of words and a width maxWidth, format the text such that each
 * line has exactly maxWidth characters and is fully (left and right)
 * justified.
 * 
 * You should pack your words in a greedy approach; that is, pack as many words
 * as you can in each line. Pad extra spaces ' ' when necessary so that each
 * line has exactly maxWidth characters.
 * 
 * Extra spaces between words should be distributed as evenly as possible. If
 * the number of spaces on a line do not divide evenly between words, the empty
 * slots on the left will be assigned more spaces than the slots on the right.
 * 
 * For the last line of text, it should be left justified and no extra space is
 * inserted between words.
 * 
 * Note:
 * 
 * 
 * A word is defined as a character sequence consisting of non-space characters
 * only.
 * Each word's length is guaranteed to be greater than 0 and not exceed
 * maxWidth.
 * The input array words contains at least one word.
 * 
 * 
 * Example 1:
 * This    is    an, example  of  text
 * 
 * Input:
 * words = ["This", "is", "an", "example", "of", "text", "justification."]
 * maxWidth = 16
 * Output:
 * [
 * "This    is    an",
 * "example  of text",
 * "justification.  "
 * ]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input:
 * words = ["What","must","be","acknowledgment","shall","be"]
 * maxWidth = 16
 * Output:
 * [
 * "What   must   be",
 * "acknowledgment  ",
 * "shall be        "
 * ]
 * Explanation: Note that the last line is "shall be    " instead of "shall
 * be",
 * because the last line must be left-justified instead of fully-justified.
 * ⁠            Note that the second line is also left-justified becase it
 * contains only one word.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input:
 * words =
 * ["science","is","what","we","understand","well","enough","to","explain",
 * "to","a","computer.","art","is","everything","else","we","do"]
 * maxWidth = 20
 * Output:
 * [
 * "Science  is  what we",
 * ⁠ "understand      well",
 * "enough to explain to",
 * "a  computer.  Art is",
 * "everything  else  we",
 * "do                  "
 * ]
 * 
 * 
 */

import java.util.*;
public class TestJustification{
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < words.length;){
            int start = i;
            int end = i; 
            int total = 0;
            System.out.println("for loop " + total + " "+ words[i].length());
            int wordPick = 0;
            // length = candidate word . length  - 1 +  
            while (i < words.length && total + words[i].length() + wordPick <= maxWidth){
               end = i;
               total += words[i].length();
               i++;
               wordPick++;
               System.out.println("i " + i);
            }
            System.out.println("total" + total);
            // if i is the last word 
            // then there is lastSpace 
            boolean isLastLine = i == words.length;
            int[] arr = calculateSpace(maxWidth - total, start, end, isLastLine);
            result.add(createString(words, start, end, arr[0], arr[1], arr[2]));
        }
        return result;
    }
    public String createString(String[] words, int start, int end, int p1, int p2, int p3){
        StringBuilder sb = new StringBuilder();
        for (int i = start; i <= end; i++){
            System.out.println("xxxxxxxx" + start + " end " + end + " i " + i);
            if (start == end) {
                sb.append(words[i]);
                sb.append(createSpace(p3));
                continue;
            }
            if (i == start){
                sb.append(words[i]);
                continue;
            }
            if (i < end){
                sb.append(createSpace(p1));
                sb.append(words[i]);
                continue;
            }
            if (i == end) {
                sb.append(createSpace(p2));
                sb.append(words[i]);
                sb.append(createSpace(p3));
                continue;
            }
        }
        return sb.toString();
    }

    public String createSpace(int n){
        StringBuilder sb = new StringBuilder(); 
        for (int i = 0; i < n; i++){
            sb.append(" ");
        }
        return sb.toString(); 
    
    }
 
    public static void main(String[] args){
       String[] arr = new String[]{"This", "is", "an", "example", "of", "text", "justification."};
       //String[] arr = new String[]{"science","is","what","we","understand","well","enough","to","explain","to","a","computer.","art","is","everything","else","we","do"};
        TestJustification tj = new TestJustification();
        System.out.println(tj.fullJustify(arr, 16));
    }

    // Cases
    // even space 
    //      total space should be end - start , no need add 1
    //      support total space = 8 
    //      size of space in the slot should be
    //      8 / (3-1) = 4
    // not even space
    //      suppose total space = 9
    //      size of even space in the slot should be 
    //      9  / (3-1) = 4+1
    //      last slot is 4
    //      the last slot has uneven number of spaces
    // last line
    //      last line with 1 work
    //      last line with mutiple words
    public int[] calculateSpace(int total, int start, int end, boolean isLastLine){
        System.out.println("total " + total + " start " + start + " end " + end + " isLastLine " + isLastLine);
        int size = end - start;
        // if (size == 0){
        //     if (isLastLine){
        //         return new int[]{0, 0};
        //     }
        //     return new int[]{0, total};
        // }
        int p1 = 0;
        int p2 = 0;
        int p3 = 0;
        if (size == 0){
            p1 = 0;
            p2 = 0;
            p3 = total;
        }else {
            if (isLastLine){
                p1 = 1;
                p2 = 1;
                p3 = total - size;
            }else{
                p3 = 0;
                if (total % size == 0){
                    p1 = total / size;
                    p2 = p1;
                }else {
                    p1 = total / size + 1;
                    p2 = total % size;
                }
            }
        }
        //if (!isLastLine){
        //    if (size == 0){
        //        p1 = 0;
        //        p2 = 0;
        //        lastSpace = 0;
        //    }else {
        //        if (total % size == 0){
        //            aSpace = total / size;
        //            lastSpace = aSpace;
        //        }else{
        //            aSpace = total / size + 1;
        //            lastSpace = total % size; 
        //        }
        //    }
        //}else{
        //    aSpace = 1;
        //    lastSpace = total;
        //}
        System.out.println("p1 " + p1 + " p2 " + p2 + " p3 " + p3);
        return new int[]{p1, p2, p3};
    }
}
