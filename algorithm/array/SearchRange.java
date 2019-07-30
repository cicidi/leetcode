package algorithm.array;

/*
 * important
 * notice
 * green
 * url
 * leetcode
 *
 * 分析
 * */

import java.util.Arrays;

public class SearchRange {

    public static void main(String[] args) {
        int[] input = new int[]{
                2, 2, 2
        };
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.searchRange(input, 2)));
    }

    static class Solution {
        public int[] searchRange(int[] nums, int target) {
            if (nums == null || nums.length == 0) {
                return new int[]{-1, -1};
            }
            int l = 0, r = nums.length - 1, m = 0;
            int[] result = new int[]{-1, -1}; // notice 起始 给result一个只 { -1, -1}
            while (l + 1 < r) {
                m = l + (r - l) / 2;
                if (target == nums[m]) {
                    r = m;
                }
                if (target < nums[m]) {
                    r = m;
                }
                if (target > nums[m]) {
                    l = m;
                }
            }
            if (nums[r] == target) {  // important  这个地方和一般的 2分发最后一步不太一样，这里要先check 右边，再check左边
                result[0] = r;
            }
            if (nums[l] == target) {
                result[0] = l;
            }
            l = 0;                  // important 这里要reset l, r 的值
            r = nums.length - 1;
            while (l + 1 < r) {
                m = l + (r - l) / 2;
                if (target == nums[m]) {
                    l = m;
                }
                if (target < nums[m]) {
                    r = m;
                }
                if (target > nums[m]) {
                    l = m;
                }

            }

            if (nums[l] == target) {    // important  这个地方和一般的 2分发最后一步不太一样，这里要先check 左边，再check 右边
                result[1] = l;
            }
            if (nums[r] == target) {
                result[1] = r;
            }
            return result;
        }
    }
}
