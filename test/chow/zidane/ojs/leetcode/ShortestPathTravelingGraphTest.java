package chow.zidane.ojs.leetcode;

import chow.zidane.ojs.leetcode.converters.ToIntegerArrayConverter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class ShortestPathTravelingGraphTest {

    @ParameterizedTest
    @CsvSource( {"'1,2,3|0|0|0','4'",
            "'1,2,3,4,5,6,7,8,9,10,11|0, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11|0, 1, 3, 4, 5, 6, 7, 8, 9, 10, 11|0, 1, 2, 4, 5, 6, 7, 8, 9, 10, "
                    + "11|0, 1, 2, 3, 5, 6, 7, 8, 9, 10, 11|0, 1, 2, 3, 4, 6, 7, 8, 9, 10, 11|0, 1, 2, 3, 4, 5, 7, 8, 9, 10, 11|0, 1, 2, "
                    + "3, 4, 5, 6, 8, 9, 10, 11|0, 1, 2, 3, 4, 5, 6, 7, 9, 10, 11|0, 1, 2, 3, 4, 5, 6, 7, 8, 10, 11|0, 1, 2, 3, 4, 5, 6, "
                    + "7, 8, 9, 11|0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10','11'"})
    void test(@ConvertWith(ToIntegerArrayConverter.class) int[][] graph, int shortestPath) {
        Assertions.assertEquals(shortestPath, ShortestPathTravelingGraph.find(graph));
    }
}
