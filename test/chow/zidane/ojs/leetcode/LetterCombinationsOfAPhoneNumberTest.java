package chow.zidane.ojs.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;
import org.junit.jupiter.params.provider.CsvSource;

class LetterCombinationsOfAPhoneNumberTest {

    @ParameterizedTest
    @CsvSource( {"23, 'ad,ae,af,bd,be,bf,cd,ce,cf'"})
    void test(String n, @ConvertWith(StringToStringArrayConverter.class) List<String> expected) {
        assertEquals(LetterCombinationsOfAPhoneNumber.find(n), expected);
    }

    private static class StringToStringArrayConverter extends SimpleArgumentConverter {

        @Override
        protected List<String> convert(final Object o, final Class<?> aClass) throws ArgumentConversionException {
            return o instanceof String && List.class.isAssignableFrom(aClass) ? Arrays.asList(((String) o).split("\\s*,\\s*")) : null;
        }
    }
}
