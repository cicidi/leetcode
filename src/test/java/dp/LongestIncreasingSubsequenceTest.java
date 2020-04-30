package dp;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

/**
 * @author walter on 2020-04-30
 * Lintcode
 * url
 */
@RunWith(JUnitPlatform.class)
class LongestIncreasingSubsequenceTest {


    @Test
    void testLongestIncreasingSubsequence() {
        LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
        int[] input_1 = new int[]{5, 4, 1, 2, 3};
        int[] input_2 = new int[]{4, 2, 4, 5, 3, 7};
        Assertions.assertEquals(3, lis.longestIncreasingSubsequence(input_1));
        Assertions.assertEquals(4, lis.longestIncreasingSubsequence(input_2));
    }
}