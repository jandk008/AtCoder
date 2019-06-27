package chow.zidane.ojs.leetcode;

import chow.zidane.ojs.leetcode.converter.ToBinaryTreeConverter;
import chow.zidane.ojs.leetcode.converter.ToIntegerListsConverter;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class VerticalOrderTraversalBinaryTreeTest {

    @ParameterizedTest
    @CsvSource( {"'1','1'", "'1,2,3,*,*,4,5,*,1','2|1,4|3,1|5'", "'*',''", "'1,2,*,3,*,4','4|3|2|1'",
            "'0,8,1,*,*,3,2,*,4,5,*,*,7,6','8|0,3,6|1,4,5|2,7'","'0,5,1,9,*,2,*,*,*,*,3,4,8,6,*,*,*,7','9,7|5,6|0,2,4|1,3|8'"})
    void test(
            @ConvertWith(ToBinaryTreeConverter.class) TreeNode root,
            @ConvertWith(ToIntegerListsConverter.class) List<List<Integer>> expects) {
        Assertions.assertIterableEquals(expects, VerticalOrderTraversalBinaryTree.traverse(root));
    }
}
