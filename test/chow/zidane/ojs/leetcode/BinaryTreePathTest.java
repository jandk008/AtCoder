package chow.zidane.ojs.leetcode;

import chow.zidane.ojs.leetcode.converters.ToBinaryTreeConverter;
import chow.zidane.ojs.leetcode.converters.ToStringArrayConverter;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class BinaryTreePathTest {

    @ParameterizedTest
    @CsvSource( {"'1,2,3,*,5','1->2->5,1->3'", "'*', ''", "'1,2,*,3,*,4','1->2->3->4'",
            "'1,2,3,4,5,6,7','1->2->4,1->2->5,1->3->6,1->3->7'"})
    void test(
            @ConvertWith(ToBinaryTreeConverter.class) TreeNode root,
            @ConvertWith(ToStringArrayConverter.class) List<String> expected) {
        Assertions.assertIterableEquals(expected, BinaryTreePath.print(root));
    }
}
