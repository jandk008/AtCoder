package chow.zidane.ojs.leetcode;

import chow.zidane.ojs.leetcode.converter.StringToBinaryTreeConverter;
import chow.zidane.ojs.leetcode.converter.StringToIntArrayConverter;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class VerticalOrderTraversalBinaryTreeTest {

    @ParameterizedTest
    @CsvSource( {"'1','1'", "'1,2,3,*,*,4,5,*,1','2|1,4|3,1|5'", "'*',''", "'1,2,*,3,*,4','4|3|2|1'",
            "'0,8,1,*,*,3,2,*,4,5,*,*,7,6','8|0,3,6|1,4,5|2,7'","'0,5,1,9,*,2,*,*,*,*,3,4,8,6,*,*,*,7','9,7|5,6|0,2,4|1,3|8'"})
    void test(
            @ConvertWith(StringToBinaryTreeConverter.class) TreeNode root,
            @ConvertWith(StringToIntArrayConverter.class) int[][] expects) {

        int[][] results = VerticalOrderTraversalBinaryTree.traverse(root).stream()
                .map(list -> list.stream()
                        .mapToInt(Integer::new)
                        .toArray())
                .toArray(int[][]::new);

        Assertions.assertEquals(expects.length, results.length);
        for (int i = 0; i < expects.length; i++) {
            Assertions.assertArrayEquals(expects[i], results[i]);
        }
    }
}
