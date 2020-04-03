package greedy;

import java.util.ArrayList;
import java.util.List;

/*
 * important
 * notice
 * green
 * lintcode
 * leetcode https://leetcode.com/problems/text-justification/
 * jiuzhang https://www.jiuzhang.com/solution/text-justification/
 * 分析
 * 1. 看有多少个单词  然后标记当前的长度，标记上一行走到那个单词了
 * 2. for 循环，important  在i==wordcount 的时候结束  因为后面j 遍历到i， 遍历的时候不断往current 加，如果
 * curent 加上预测的空格数大于L 那么就进入插孔环节， 否则继续遍历
 * 3. 下面判断当前行是否只有一个单词，如果只有一个单词那么单词之后
 * 全部加space ， 否则 在单词之间加
 * 4 创建space count 和space slot  通过space slot 如果space slot = i-lastI==0 那么当前行之后一个单词,否则有两个单词
 * 5 如果每行添加，那么先保证每行能够平均 ，然后还有余数的，往档次里面插入查完为止
 * 6. 如果这行插入完单词了就可以加到结果集里面去了
 * */

public class TextJustify {

    public static void main(String[] args) {
        Solution s = new Solution();
        String[] input = new String[]{
//                "This", "is", "an", "example", "of", "text", "justification."
                "What", "must", "be", "acknowledgment", "shall", "be"
//                "Science", "is", "what", "we", "understand", "well", "enough", "to", "explain", "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"
//                "wrt", "wrf", "er", "ett", "rftt"
        };
        List<String> list = s.fullJustify(input, 16);
//        List<String> list = s.fullJustify(input, 20);
        for (String str : list) {
            System.out.println(str);
        }
    }

    static class Solution {

        public ArrayList<String> fullJustify(String[] words, int L) {
            int wordsCount = words.length; //获取单次数量
            ArrayList<String> result = new ArrayList<String>();  //统计答案
            int curLen = 0;
            int lastI = 0;
            for (int i = 0; i <= wordsCount; i++) {
                int spaceSzie = i - lastI;
                if (i == wordsCount || curLen + words[i].length() + spaceSzie > L) {
                    //notice 判断单行是否允许再放一个单词
                    //notice 当总长度小于L 时候，走71行的if
                    //notice 直到满足大于L的时候 才进入这个大的if
                    //notice 并且这时候的最后一个但是也不应该被记录到当前行
                    StringBuffer buf = new StringBuffer();
                    int spaceCount = L - curLen;
                    int spaceSlots = i - lastI - 1;
                    if (spaceSlots == 0 || i == wordsCount) {
                        //notice 当这一行只有一个单词的时候 或者i 已经到了最后就差收尾了
                        for (int j = lastI; j < i; j++) {
                            //notice 因为这个是append 到i之前，所以前面wordcount 要loop 到word count
                            buf.append(words[j]);
                            if (j != i - 1)
                                appendSpace(buf, 1);  //如果不是每一行最后一个单词， 就一直要加在单词中间加上空格
                        }
                        appendSpace(buf, L - buf.length());
                    } else {
                        // 这一行不止一个单词也不是最后的收尾
                        int spaceEach = spaceCount / spaceSlots; //如果不能，计算空格的数量和位置
                        int spaceExtra = spaceCount % spaceSlots;
                        for (int j = lastI; j < i; j++) {
                            buf.append(words[j]);
                            if (j != i - 1)
                                // 如果space 不平等 这个地方具体分几个呢 大概就是平均每个人都等分带spaceEach
                                // 剩下的先到先得
                                appendSpace(buf, spaceEach + (j - lastI < spaceExtra ? 1 : 0));
                        }
                    }
                    result.add(buf.toString());
                    lastI = i;
                    curLen = 0;
                }
                if (i < wordsCount)
                    curLen += words[i].length();
            }
            return result;
        }

        private void appendSpace(StringBuffer sb, int count) {
            for (int i = 0; i < count; i++)
                sb.append(' ');
        }
    }
}