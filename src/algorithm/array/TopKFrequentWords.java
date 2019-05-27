package algorithm.array;

import java.util.*;

/**
 * @author cicidi on 5/26/19
 * Lintcode 471. Top K Frequent Words
 * url https://www.lintcode.com/problem/top-k-frequent-words/description
 */
public class TopKFrequentWords {
    /**
     * @param words: an array of string
     * @param k:     An integer
     * @return: an array of string
     */
    public String[] topKFrequentWords(String[] words, int k) {
        // write your code here

        if (words == null || words.length == 0 || k == 0) {
            return new String[0];
        }
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (String word : words) {
            Integer count = map.get(word);
            if (count == null) {
                count = 0;
            }
            count++;
            map.put(word, count);
        }
        System.out.printf("map size: %d \n", map.size());
        PriorityQueue<Map.Entry<String, Integer>> queue = new PriorityQueue<Map.Entry<String, Integer>>((x, y) ->
        {
            if (y.getValue() == x.getValue()) {
                return x.getKey().compareTo(y.getKey());
            } else {
                return y.getValue() - x.getValue();
            }
        }
        );

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            queue.add(entry);
            System.out.printf("map k v : %s %d \n", entry.getKey(), entry.getValue());
            // if(queue.size()>k){
            //     Map.Entry<String,Integer> removed = queue.removeLast();
            //     System.out.printf("remove k v : %s %d \n", removed.getKey(),removed.getValue());
            // }
        }

        String[] arr = new String[k];
        int indexOfQ = 0;
        int index = 0;
        while (!queue.isEmpty() && index < k) {
            if (indexOfQ >= queue.size() - k) {
                arr[index] = queue.remove().getKey();
                index++;
            }
            indexOfQ++;
        }
        return arr;
    }
}
