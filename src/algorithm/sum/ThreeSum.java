package algorithm.sum;

import java.util.*;

/**
 * @author cicidi on 5/26/19
 * lintcode 57. 3Sum
 * https://www.lintcode.com/problem/3sum/note
 */
public class ThreeSum {
    /**
     * @param numbers: Give an array numbers of n integer
     * @return: Find all unique triplets in the array which gives the sum of zero.
     */
    public List<List<Integer>> threeSum(int[] numbers) {
        // write your code here

        Arrays.sort(numbers);
        Set<List<Integer>> result = new HashSet<>();
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                int twoSum = numbers[i] + numbers[j];
                for (int k = numbers.length - 1; k > j; k--) {
                    if (numbers[k] == (0 - twoSum)) {
                        List<Integer> list = new ArrayList<>();
                        list.add(numbers[i]);
                        list.add(numbers[j]);
                        list.add(numbers[k]);
                        result.add(list);
                    }
                }
            }
        }
        List<List<Integer>> finalResult = new ArrayList<>();
        for (List<Integer> list : result) {
            finalResult.add(list);
        }
        return finalResult;
    }
}
