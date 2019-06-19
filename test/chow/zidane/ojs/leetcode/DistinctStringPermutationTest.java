package chow.zidane.ojs.leetcode;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import chow.zidane.ojs.leetcode.converter.StringToIntArrayConverter;
import chow.zidane.ojs.leetcode.converter.StringToIntegerListsConverter;
import chow.zidane.ojs.leetcode.converter.StringToStringListConverter;
import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class DistinctStringPermutationTest {

    @ParameterizedTest
    @CsvSource( {"'abc,acb,bac,bca,cab,cba','abc'", "'ab,ba','ab'", "'a','a'"})
    void permutation(@ConvertWith(StringToStringListConverter.class) List<String> expected, String s) {
        assertIterableEquals(expected, DistinctStringPermutation.recursionWithString(s));
    }

    @ParameterizedTest
    @CsvSource( {"'1,2,3','1,2,3|1,3,2|2,1,3|2,3,1|3,2,1|3,1,2'"})
    void permutationWthIntArray(
            @ConvertWith(StringToIntArrayConverter.class) int[] nums,
            @ConvertWith(StringToIntegerListsConverter.class) List<List<Integer>> expected) {
        assertIterableEquals(expected, DistinctStringPermutation.recursionWithIntegerArray(nums));
    }
}
