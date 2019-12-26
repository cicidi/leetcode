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
 * 
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
class TestJustification{
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < words.length;){
            int start = i;
            int end = i; 
            int size = 0;
            int space = 0;
            int aSpace = 0;
            int lastSpace = 0;
            while (i < words.length && total + words[i] <= maxWidth){
               end = i;
               total += words[i].length();
               i++;
            }
            i -- ;
            space = maxWidth - total;
            if (i != word.length -1){
                lastSpace = total % (end - i);
                aSpace = total / (start - end - 1);
            }else{
                aSpace = total / (start - end);
            }
            result.add(createString(words, start, end,aSpace,lastSpace));
        }
        return result;
    }
    public String createString(String[] words, int start, int end, int aSpace, int lastSpace){
        StringBuilder sb = new StringBuilder();
        for (int i = start; i < end; i++){
            sb.append(words[i]);
            if (i = end - 2){
                sb.append(createSpace(lastSpace));
            }else if (i < end - 2 ){
                sb.append(createSpace(aSpace));
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
    }
}
