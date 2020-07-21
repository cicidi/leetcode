package graph;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author walter on 2020-07-20
 * Lintcode
 * url
 */
@RunWith(JUnitPlatform.class)
class FindEventualSafeStatesTest {

    @Test
    void eventualSafeNodes() {
        FindEventualSafeStates f = new FindEventualSafeStates();
        int[][] graph = new int[][]{{1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}};
        Assertions.assertEquals(Arrays.toString(new int[]{2, 4, 5, 6}), Arrays.toString(f.eventualSafeNodes(graph).toArray()));
    }
}