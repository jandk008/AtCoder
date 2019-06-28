package chow.zidane.ojs.leetcode;

import chow.zidane.ojs.leetcode.converters.ToIntegerArrayConverter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class RotateImageTest {

    @ParameterizedTest
    @CsvSource( {"'1,2,3|1,2,3|1,2,3','1,1,1|2,2,2|3,3,3'", "'1,1,1,1|2,2,2,2|3,3,3,3|4,4,4,4','4,3,2,1|4,3,2,1|4,3,2,1|4,3,2,1'"})
    void testWithSwapping(
            @ConvertWith(ToIntegerArrayConverter.class) int[][] matrix,
            @ConvertWith(ToIntegerArrayConverter.class) int[][] expected) {
        RotateImage.rotateWithSwapping(matrix);
        Assertions.assertArrayEquals(expected, matrix);
    }

    @ParameterizedTest
    @CsvSource( {"'1,2,3|1,2,3|1,2,3','1,1,1|2,2,2|3,3,3'", "'1,1,1,1|2,2,2,2|3,3,3,3|4,4,4,4','4,3,2,1|4,3,2,1|4,3,2,1|4,3,2,1'"})
    void testWithFlipping(
            @ConvertWith(ToIntegerArrayConverter.class) int[][] matrix,
            @ConvertWith(ToIntegerArrayConverter.class) int[][] expected) {
        RotateImage.rotateWithFlipping(matrix);
        Assertions.assertArrayEquals(expected, matrix);
    }
}
