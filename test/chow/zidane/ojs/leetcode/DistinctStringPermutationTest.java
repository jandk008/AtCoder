package chow.zidane.ojs.leetcode;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import chow.zidane.ojs.leetcode.converter.StringToStringArrayConverter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class DistinctStringPermutationTest {

    @ParameterizedTest
    @CsvSource( {"'abc,acb,bac,bca,cab,cba','abc'", "'ab,ba','ab'", "'a','a'"})
    void permutation(@ConvertWith(StringToStringArrayConverter.class) List<String> expect, String s) {
        assertIterableEquals(expect, DistinctStringPermutation.recursionWithString(s));
    }

    @Test
    void permutationWthIntArray() {
        int[] input = new int[] {1, 2, 3};
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(Arrays.asList(1, 2, 3));
        expected.add(Arrays.asList(1, 3, 2));
        expected.add(Arrays.asList(2, 1, 3));
        expected.add(Arrays.asList(2, 3, 1));
        expected.add(Arrays.asList(3, 2, 1));
        expected.add(Arrays.asList(3, 1, 2));
        assertIterableEquals(expected, DistinctStringPermutation.recursionWithIntegerArray(input));
    }
}
