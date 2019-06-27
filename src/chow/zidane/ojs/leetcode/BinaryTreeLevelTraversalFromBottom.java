package chow.zidane.ojs.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class BinaryTreeLevelTraversalFromBottom {

    static List<List<Integer>> traversal(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        Deque<TreeNode> queue = new ArrayDeque<>();
        LinkedList<List<Integer>> lists = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            while(size-- > 0) {
                root = queue.poll();
                if (root != null) {
                    list.add(root.val);
                    if (root.left != null) queue.add(root.left);
                    if (root.right != null) queue.add(root.right);
                }
            }
            if (!list.isEmpty()) lists.addFirst(list);
        }
        return lists;
    }
}
