package string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cicidi on 2020-01-20
 * Lintcode
 * url
 */
public class TestJustification {

    public List<String> fullJustify(String[] words, int maxWidth) {
        int start = 0;
        int len = words.length;
        int total = 0; // notice total doesn't include space size
        List<String> result = new ArrayList<>();
        for (int current = 0; current <= len; current++) {
            // important
            //  if current == len  current reach edge, total still < max
            //  this statement not easy to write.
            if (current == len || total + (current - start) + words[current].length() > maxWidth) { //
                // important because current is one more that valida index.
                int slot = (current - 1) - start;
                int spaceCount = maxWidth - total; // notice total space count in the line
                StringBuilder sb = new StringBuilder();
                if (slot == 0 || current == len) { // notice when only one word or last line
                    for (int j = start; j < current; j++) { // notice from start to currnet pointer
                        //  add word and if j not the last element, keep add space 1
                        sb.append(words[j]);
                        if (j != current - 1) {
                            appendSpace(sb, 1);
                        }
                    }
                    appendSpace(sb, maxWidth - sb.length()); // notice add all the to ther spaces.
                } else {
                    int avg = spaceCount / slot;  // notice calculate avg
                    int extra = spaceCount % slot; // notice extra is the index to here a extra 1 space is needed.
                    for (int j = start; j < current; j++) {
                        sb.append(words[j]);
                        if (j != current - 1) {
                            appendSpace(sb, avg + (j - start < extra ? 1 : 0));
                        }// if j is not the last word
                    }

                }
                result.add(sb.toString()); // notice add string to result;
                start = current; // notice start is current now;
                total = 0; // notice reset total
            }
            if (current < len) {
                total += words[current].length();
            }
        }
        return result;
    }

    public String appendSpace(StringBuilder sb, int size) {
        for (int i = 0; i < size; i++) {
            sb.append(" ");
        }
        return sb.toString();
    }
}
