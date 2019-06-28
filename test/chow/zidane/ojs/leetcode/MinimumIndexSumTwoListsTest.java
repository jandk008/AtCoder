package chow.zidane.ojs.leetcode;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import chow.zidane.ojs.leetcode.converters.ToStringArrayConverter;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class MinimumIndexSumTwoListsTest {

    @ParameterizedTest
    @CsvSource( {"'Shogun,Tapioca Express,Burger King,KFC','Piatti,The Grill at Torrey Pines,Hungry Hunter Steakhouse,Shogun','Shogun'",
            "'Shogun,Tapioca Express,Burger King,KFC','KFC,Shogun,Burger King','Shogun'", "'ab,bc,kfc','bc,ab,kfc','bc,ab'", "'','',''"})
    void test(
            @ConvertWith(ToStringArrayConverter.class) String[] list1,
            @ConvertWith(ToStringArrayConverter.class) String[] list2,
            @ConvertWith(ToStringArrayConverter.class) String[] expected) {
        assertArrayEquals(expected, MinimumIndexSumTwoLists.find(list1, list2));
    }
}
