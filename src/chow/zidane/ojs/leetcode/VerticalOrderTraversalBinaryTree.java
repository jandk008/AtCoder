package chow.zidane.ojs.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class VerticalOrderTraversalBinaryTree {

    static List<List<Integer>> traverse(final TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        List<Coordinate> list = new ArrayList<>();
        helper(root, 0, 0, list);
        Collections.sort(list);

        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> values = new ArrayList<>();

        int currentX = list.get(0).x;
        for (Coordinate coordinate : list) {
            if (coordinate.x != currentX) {
                lists.add(new ArrayList<>(values));
                values = new ArrayList<>();
                currentX = coordinate.x;
            }
            values.add(coordinate.val);
        }
        lists.add(values);

        return lists;
    }

    private static void helper(TreeNode root, int x, int y, List<Coordinate> list) {
        if (root == null) {
            return;
        }
        list.add(new Coordinate(root.val, x, y));

        helper(root.left, x - 1, y - 1, list);
        helper(root.right, x + 1, y - 1, list);
    }

    private static class Coordinate implements Comparable<Coordinate> {

        int val;
        int x;
        int y;

        private Coordinate(final int val, final int x, final int y) {
            this.val = val;
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(final Coordinate o) {
            if (x != o.x) {
                return Integer.compare(x, o.x);
            } else if (y != o.y) {
                return Integer.compare(o.y, y);
            } else {
                return Integer.compare(val, o.val);
            }
        }
    }
}
