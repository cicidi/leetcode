package sum;

import java.util.*;

/**
 * @author cicidi on 5/26/19
 * lintcode 57. 3Sum
 * https://www.lintcode.com/problem/3sum/note
 */

// 3 sum  就是土办法  先sort 前面两个数， 组合2 sum  根最后一个数走
public class ThreeSum {
    /**
     * @param numbers: Give an array numbers of n integer
     * @return: Find all unique triplets in the array which gives the sum of zero.
     */
    public List<List<Integer>> threeSum(int[] numbers) {
        // write your code here

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(numbers);
        if (numbers == null || numbers.length < 3) {
            return result;
        }
        // notice 方法: 对于任意一个数 进行两端法， 如果连续两个数字有重复的 skip 掉
        for (int i = 0; i < numbers.length - 2; i++) {
            if (i != 0 && numbers[i - 1] == numbers[i]) {
                continue;// 从第二个数开始看
            }
            int low = i + 1;
            int high = numbers.length - 1;
            while (low < high) {
                int sum = numbers[i] + numbers[low] + numbers[high];
                if (sum == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(numbers[i]);
                    list.add(numbers[low]);
                    list.add(numbers[high]);
                    result.add(list);
                    low++;
                    high--;
                    while (numbers[low - 1] == numbers[low] && low < high) {
                        low++;
                    }
                    while (numbers[high] == numbers[high + 1] && low < high) {
                        high--;
                    }

                } else if (sum > 0) {
                    high--;
                } else {
                    low++;
                }
            }
        }
        return result;
    }
}

// 有时间就看看 没时间就算了 leetcode 里面的最快解法
class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        if (len < 3)
            return new ArrayList<List<Integer>>();

        Arrays.sort(nums);  //sort the array first
        List<List<Integer>> res = new ArrayList<>();
        int max = Math.max(nums[len - 1], Math.abs(nums[0])); //to allocate enough space to avoid check in if statement

        byte[] hash = new byte[(max << 1) + 1];
        for (int v : nums) { //hash and count appearing times of every num
            hash[v + max]++;
        }

        int lastNeg = Arrays.binarySearch(nums, 0); //search the position of 0; it also means the position of the last negative number in array
        int firstPos = lastNeg; //the position of the first positive number in array
        if (lastNeg < 0) {    //0 not found
            firstPos = ~lastNeg;
            lastNeg = -lastNeg - 2;//see the Java api
        } else {               //found
            while (lastNeg >= 0 && nums[lastNeg] == 0) //skip all 0
                --lastNeg;
            while (firstPos < len && nums[firstPos] == 0)
                ++firstPos;
            int zeroCount = firstPos - lastNeg - 1;
            if (zeroCount >= 3) { // (0 appears 3 times at least)
                res.add(Arrays.asList(0, 0, 0));
            }
            if (zeroCount > 0) { // (0 appears 1 times at least)
                for (int i = firstPos; i < len; ++i) { //traverse all the positive numbers to see whether there is a negative number whose absolute value equals to the positive number
                    if (i > firstPos && nums[i] == nums[i - 1]) //skip the same elements
                        continue;
                    if (hash[-nums[i] + max] > 0) {
                        res.add(Arrays.asList(0, nums[i], -nums[i]));
                    }
                }
            }
        }

        // one positive number and two negetive numbers
        for (int i = firstPos; i < len; ++i) { //traverse all the positive numbers to find whether there are two negative numbers to make the 3 numbers added up to 0
            if (i > firstPos && nums[i] == nums[i - 1]) //skip the same elements
                continue;
            int half;   //we can traverse only half of the positive numbers
            if (nums[i] % 2 != 0)
                half = -((nums[i] >> 1) + 1);
            else {
                half = -(nums[i] >> 1);
                if (hash[half + max] > 1)
                    res.add(Arrays.asList(nums[i], half, half));
            }
            for (int j = lastNeg; j >= 0 && nums[j] > half; --j) {
                if (j < lastNeg && nums[j] == nums[j + 1])
                    continue;
                if (hash[(-nums[i] - nums[j]) + max] > 0)
                    res.add(Arrays.asList(nums[i], nums[j], -nums[i] - nums[j]));
            }
        }

        // one negative number and two positive numbers
        for (int i = lastNeg; i >= 0; --i) { //traverse all the negative numbers to find whether there are two positive numbers to make the 3 numbers added up to 0
            if (i < lastNeg && nums[i] == nums[i + 1])//skip the same elements
                continue;
            int half; //we can traverse only half of the negative numbers
            if (nums[i] % 2 != 0)
                half = -(nums[i] / 2 - 1);
            else {
                half = -(nums[i] >> 1);
                if (hash[half + max] > 1)
                    res.add(Arrays.asList(nums[i], half, half));
            }
            for (int j = firstPos; j < len && nums[j] < half; ++j) {
                if (j > firstPos && nums[j] == nums[j - 1])
                    continue;
                if (hash[(-nums[i] - nums[j]) + max] > 0)
                    res.add(Arrays.asList(nums[i], nums[j], -nums[i] - nums[j]));
            }
        }
        return res;
    }
}
