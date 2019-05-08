package chow.zidane.ojs.leetcode;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import chow.zidane.ojs.leetcode.converter.StringToStringArrayConverter;
import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class DistinctStringPermutationTest {
    @ParameterizedTest
    @CsvSource({"'abc', 'abc,acb,bac,bca,cab,cba'", "'ab','ab,ba'", "'a','a'"})
    void permutation(String s, @ConvertWith(StringToStringArrayConverter.class) List<String> expect) {
        assertIterableEquals(expect, DistinctStringPermutation.recursion(s));
    }
}
