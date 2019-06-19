package chow.zidane.ojs.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class BinaryTreePath {

    static List<String> print(final TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<String> list = new ArrayList<>();
        printEach(root, "", list);
        return list;
    }

    private static void printEach(TreeNode root, final String prefix, List<String> list) {
        if (root.left == null && root.right == null) {
            list.add(prefix + root.val);
            return;
        }
        if (root.left != null) {
            printEach(root.left, prefix + root.val + "->", list);
        }
        if (root.right != null) {
            printEach(root.right, prefix + root.val + "->", list);
        }
    }
}
