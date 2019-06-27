package chow.zidane.ojs.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class BinaryTreeLevelAverage {

    static List<Double> calculate(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        List<Double> list = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            double sum = 0.0;
            int count = size;
            while (size-- > 0) {
                root = queue.poll();
                if (root != null) {
                    sum += root.val;
                    if (root.left != null) {
                        queue.add(root.left);
                    }
                    if (root.right != null) {
                        queue.add(root.right);
                    }
                }
            }
            list.add(sum / count);
        }
        return list;
    }
}
