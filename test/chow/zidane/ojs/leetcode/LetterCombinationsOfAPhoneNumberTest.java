package chow.zidane.ojs.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import chow.zidane.ojs.leetcode.converter.StringToStringListConverter;
import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class LetterCombinationsOfAPhoneNumberTest {

    @ParameterizedTest
    @CsvSource( {"23, 'ad,ae,af,bd,be,bf,cd,ce,cf'"})
    void test(String n, @ConvertWith(StringToStringListConverter.class) List<String> expected) {
        assertEquals(expected, LetterCombinationsOfAPhoneNumber.find(n));
    }
}
