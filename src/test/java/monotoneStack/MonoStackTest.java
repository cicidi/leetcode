package monotoneStack;

import org.junit.jupiter.api.Assertions;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author walter on 2020-07-06
 * Lintcode
 * url
 */
@RunWith(JUnitPlatform.class)
class MonoStackTest {


    MonoStack monoStack = new MonoStack();
    int[] input1 = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
    int[] input2 = new int[]{8, 7, 6, 5, 4, 3, 2, 1};
    int[] input3 = new int[]{5, 7, 6, 8, 4, 11, 2, 9, 1};


    @org.junit.jupiter.api.Test
    void ascStack() {
        // test case 1
        List<List<Integer>> expectLifeCycle1 = new ArrayList<>();
        List<Integer> stage = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        expectLifeCycle1.add(stage);
        List<List<Integer>> result = monoStack.ascStack(input1);
        for (int i = 0; i < result.size(); i++) {
            Assertions.assertTrue(result.get(i).equals(expectLifeCycle1.get(i)));
        }
        //test case 2
        List<Integer> stage1 = Arrays.asList(8);
        List<Integer> stage2 = Arrays.asList(7);
        List<Integer> stage3 = Arrays.asList(6);
        List<Integer> stage4 = Arrays.asList(5);
        List<Integer> stage5 = Arrays.asList(4);
        List<Integer> stage6 = Arrays.asList(3);
        List<Integer> stage7 = Arrays.asList(2);
        List<Integer> stage8 = Arrays.asList(1);
        List<List<Integer>> expectLifeCycle2 = new ArrayList<>(Arrays.asList(stage1, stage2, stage3, stage4, stage5, stage6, stage7, stage8));
        result = monoStack.ascStack(input2);
        for (int i = 0; i < result.size(); i++) {
            Assertions.assertTrue(result.get(i).equals(expectLifeCycle2.get(i)));
        }

        stage1 = Arrays.asList(7);
        stage2 = Arrays.asList(5, 6, 8);
        stage3 = Arrays.asList(4, 11);
        stage4 = Arrays.asList(2, 9);
        stage5 = Arrays.asList(1);
        List<List<Integer>> expectLifeCycle3 = new ArrayList<>(Arrays.asList(stage1, stage2, stage3, stage4, stage5, stage6, stage7, stage8));
        result = monoStack.ascStack(input3);
        for (int i = 0; i < result.size(); i++) {
            System.out.println("result : " + Arrays.toString(result.get(i).toArray()));
            System.out.println("expect : " + Arrays.toString(expectLifeCycle3.get(i).toArray()));
            Assertions.assertTrue(result.get(i).equals(expectLifeCycle3.get(i)));
        }
    }

    @org.junit.jupiter.api.Test
    void descStack() {
    }
}