package chow.zidane.ojs.leetcode;

import chow.zidane.ojs.leetcode.converters.ToListNodeConverter;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

public class IntersectionTwoLinkedListsTest {

    @ParameterizedTest
    @CsvSource( {"'1,2,3,4,5','8,7,4,5','4,5'"})
    void test(
            @ConvertWith(ToListNodeConverter.class) ListNode A,
            @ConvertWith(ToListNodeConverter.class) ListNode B,
            @ConvertWith(ToListNodeConverter.class) ListNode expected) {


    }

}
