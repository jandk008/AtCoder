package chow.zidane.ojs.leetcode;

import static org.junit.jupiter.api.Assertions.assertTrue;

import chow.zidane.ojs.leetcode.converters.ToCharArrayConverter;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class ValidSudokuTest {

    @ParameterizedTest
    @CsvSource( {"'53..7....,6..195...,.98....6.,8...6...3,4..8.3..1,7...2...6,.6....28.,...419..5,....8..79'"})
    void testTrueCase(@ConvertWith(ToCharArrayConverter.class) Character[][] board) {
        assertTrue(ValidSudoku.validate(board));
    }

}
