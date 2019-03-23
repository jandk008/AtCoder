package chow.zidane.ojs.leetcode;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;
import org.junit.jupiter.params.provider.CsvSource;

class ValidSudokuTest {

    @ParameterizedTest
    @CsvSource( {"'53..7....,6..195...,.98....6.,8...6...3,4..8.3..1,7...2...6,.6....28.,...419..5,....8..79'"})
    void testTrueCase(@ConvertWith(StringToCharArrayConverter.class) Character[][] board) {
        assertTrue(ValidSudoku.validate(board));
    }

    private static class StringToCharArrayConverter extends SimpleArgumentConverter {
        @Override
        protected Character[][] convert(final Object o, final Class<?> aClass) throws ArgumentConversionException {
            return Arrays.stream(((String) o).split(","))
                    .map(s -> s.chars().mapToObj(c -> (char) c).toArray(Character[]::new))
                    .toArray(Character[][]::new);
        }
    }

}
