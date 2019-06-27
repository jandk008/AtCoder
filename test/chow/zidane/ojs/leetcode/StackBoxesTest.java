package chow.zidane.ojs.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import chow.zidane.ojs.leetcode.converter.ToBoxConverter;
import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class StackBoxesTest {

    @ParameterizedTest
    @CsvSource( {"'3,2| 2,3| 1,1| 5,4'"})
    void given4boxes_return9(@ConvertWith(ToBoxConverter.class) final List<Box> boxes) {

        final int height = StackBoxes.findMaxHeight(boxes);
        assertEquals(height, 9);
    }

    @ParameterizedTest
    @CsvSource( {"'2,3| 3,3| 1,1| 1,1'"})
    void given4boxes_return7(@ConvertWith(ToBoxConverter.class) final List<Box> boxes) {

        final int height = StackBoxes.findMaxHeight(boxes);
        assertEquals(height, 7);
    }
}
