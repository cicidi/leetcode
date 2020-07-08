/*
 * @lc app=leetcode id=496 lang=java
 *
 * [496] Next Greater Element I
 *
 * https://leetcode.com/problems/next-greater-element-i/description/
 *
 * algorithms
 * Easy (63.04%)
 * Total Accepted:    147.9K
 * Total Submissions: 234.6K
 * Testcase Example:  '[4,1,2]\n[1,3,4,2]'
 *
 *
 * You are given two arrays (without duplicates) nums1 and nums2 where nums1’s
 * elements are subset of nums2. Find all the next greater numbers for nums1's
 * elements in the corresponding places of nums2.
 *
 *
 *
 * The Next Greater Number of a number x in nums1 is the first greater number
 * to its right in nums2. If it does not exist, output -1 for this number.
 *
 *
 * Example 1:
 *
 * Input: nums1 = [4,1,2], nums2 = [1,3,4,2].
 * Output: [-1,3,-1]
 * Explanation:
 * ⁠   For number 4 in the first array, you cannot find the next greater number
 * for it in the second array, so output -1.
 * ⁠   For number 1 in the first array, the next greater number for it in the
 * second array is 3.
 * ⁠   For number 2 in the first array, there is no next greater number for it
 * in the second array, so output -1.
 *
 *
 *
 * Example 2:
 *
 * Input: nums1 = [2,4], nums2 = [1,2,3,4].
 * Output: [3,-1]
 * Explanation:
 * ⁠   For number 2 in the first array, the next greater number for it in the
 * second array is 3.
 * ⁠   For number 4 in the first array, there is no next greater number for it
 * in the second array, so output -1.
 *
 *
 *
 *
 * Note:
 *
 * All elements in nums1 and nums2 are unique.
 * The length of both nums1 and nums2 would not exceed 1000.
 *
 *
 */

package monotoneStack;

import java.util.*;


class NextGreaterElement {
    // 3,4,2,1,5
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int num : nums2) { // 可以直接保存val,而不是index

            // So to get the nextGreaterElement, actually we are creating a monotone decrease stack, which the next value
            // element is less than previous one, and if a  new element is large then the stack.peek, we will take
            // the stack.peek, and use a hashmap store the nextGreaterElement.
            while (!stack.isEmpty() && stack.peek() < num) {
                map.put(stack.pop(), num);
            }
            stack.add(num);
        }

        for (int i = 0; i < nums1.length; i++) {
            int e = nums1[i];
            nums1[i] = map.getOrDefault(e, -1);// 优化：这里的result 可以直接用nums1
        }
        return nums1;
    }
}

// =============================================================================

/* wrong solution TOTALLY  没有考虑到一个值 可是多个数字的下一个最大值这种情况
  public int[] nextGreaterElement(int[] nums1, int[] nums2) {
       Map<Integer, Integer> map = new HashMap<>();
       for(int i = 0; i < nums1.length; i++){
          map.put(nums1[i],;
       }
       int[] result = new int[nums1.length]; 
       for(int i = 0; i < result.length; i++){
          result[i] = -1;
       }
       Stack<Integer> stack = new Stack<>();
       for(int i = 0; i < nums2.length; ){
          if(stack.isEmpty() || nums2[stack.peek()] < nums2[i]){
             stack.add(i);
             i++;
          }else{
            int tmpIndex = stack.pop();
            if(stack.isEmpty()){
              continue;
            }
            setVal(result, nums1, nums2, stack.peek(), tmpIndex, map); 
          }
       }

       System.out.println(Arrays.toString(stack.toArray()));
       while(!stack.isEmpty()){
         int tmpIndex = stack.pop();
         if(stack.isEmpty()){
           break;
         }
         setVal(result, nums1, nums2, stack.peek(), tmpIndex, map); 
       }
       return result;
    }

    public void setVal(int[]result,int[] nums1, int[] nums2, int i1, int i2, Map<Integer, Integer> map){
      int val=  nums2[i2];
      if(map.containsKey(nums2[i1])){
        System.out.printf("i1: %d, i2: %d, nxtVal: %d \n", i1, i2, val);
        if(result[map.get(nums2[i1])] == -1){
          result[map.get(nums2[i1])] = val; 
        }
      }
    }
*/

