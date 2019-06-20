package chow.zidane.ojs.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class WaterJugProblemTest {

    @ParameterizedTest
    @CsvSource( {"'2','5','4'", "'34','89','54'", "'22003','31237','1'", "'0','0','0'"})
    void canMeasure(int x, int y, int z) {
        Assertions.assertTrue(WaterJugProblem.canMeasure(x, y, z));
    }

    @ParameterizedTest
    @CsvSource( {"'2','6','5'", "'3','12','5'", "'0','0','1'"})
    void canNotMeasure(int x, int y, int z) {
        Assertions.assertFalse(WaterJugProblem.canMeasure(x, y, z));
    }

}
