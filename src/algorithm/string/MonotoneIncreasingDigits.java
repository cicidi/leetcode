package algorithm.string;

/**
 * @author cicidi on 5/26/19
 * Lintcode 743. Monotone Increasing Digits
 * url https://www.lintcode.com/problem/monotone-increasing-digits/description
 */
public class MonotoneIncreasingDigits {
    /**
     * @param num: a non-negative integer N
     * @return: the largest number that is less than or equal to N with monotone increasing digits.
     */
    public int monotoneDigits(int num) {
        // write your code here

        int count = 0;
        int[] A = new int[10];
        while (num != 0) {
            A[count++] = num % 10;
            num /= 10;
        }

        int position = -1;
        for (int i = 1; i < count; i++) {
            if (A[i] > A[i - 1]) {
                A[i]--;
                position = i;
            }
        }

        for (int i = position - 1; i >= 0; i--) {
            A[i] = 9;
        }

        int number = 0;

        for (int i = count - 1; i >= 0; i--) {
            number = number * 10 + A[i];
        }
        return number;
    }


}
