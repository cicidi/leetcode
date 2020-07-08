package monotoneStack;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import java.util.Arrays;

/**
 * @author walter on 2020-07-02
 * Lintcode
 * url
 */
@RunWith(JUnitPlatform.class)
class NextGreaterElementTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void nextGreaterElement() {
        int[] input1 = new int[]{4, 1, 2};
        int[] input2 = new int[]{1, 3, 4, 2};
        NextGreaterElement element = new NextGreaterElement();
        int[] result = element.nextGreaterElement(input1, input2);
        Assertions.assertTrue(Arrays.equals(result, new int[]{-1, 3, -1}));

        input1 = new int[]{3, 1, 5, 7, 9, 2, 6};
        input2 = new int[]{1, 2, 3, 5, 6, 7, 9, 11};
        result = element.nextGreaterElement(input1, input2);
        Assertions.assertTrue(Arrays.equals(result, new int[]{5, 2, 6, 9, 11, 3, 7}));
    }
}