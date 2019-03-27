package chow.zidane.ojs.leetcode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class BinaryTreePostorderTraversal {

    /**
     * 1. Easy to think up, here I use linked list to keep results because of property of easy add
     * or delete new element. If the root is null, return the list, otherwise add the value into
     * list, followed by preorder traversal of left subtree and right subtree. So it is trivial, but
     * performance is good. T(n) = O(n) , beating 73.57 % submission.
     *
     * @author zichengz
     *
     */
    static class Recursion {
        public List<Integer> postorderTraversal(TreeNode root) {
            LinkedList<Integer> res = new LinkedList<>();
            return postorderTraversal(root, res);
        }

        public LinkedList<Integer> postorderTraversal(TreeNode root, LinkedList<Integer> list) {
            if (null == root) {
                return list;
            }
            list = postorderTraversal(root.left, list);
            list = postorderTraversal(root.right, list);
            list.addLast(root.val);
            return list;
        }

    }

    /**
     * 2. The whole architecture of implementation is close to solution of binary tree preorder
     * traversal, differently building the results from tail to head by using addFirst() instead of
     * addLast() and looping the right subtree instead of left subtree. It is very gracious, I
     * think! T(n) = O(n) , beating 73.01 % submission, pretty good.
     *
     * @author zichengz
     *
     */
    static class Iteration {
        public List<Integer> postorderTraversal(TreeNode root) {
            LinkedList<Integer> res = new LinkedList<>();
            LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
            while (true) {
                while (null != root) {
                    res.addFirst(root.val);
                    stack.addFirst(root);
                    root = root.right;
                }
                if (stack.isEmpty()) {
                    break;
                }
                root = stack.removeFirst();
                root = root.left;
            }
            return res;
        }
    }

    /**
     * 3. This solution is a little tricky and easy to write but hard to think up for me. For each
     * root, print the value and push subtree of both sides into stack, and pop the top and loop the
     * steps. At the end, reverse the results getting the actual result. T(N) = O(2N), beating 7.06
     * % submission, performance down.
     *
     * @author zichengz
     *
     */
    static class DepthFirstSearch {
        public List<Integer> postorderTraversal(TreeNode root) {
            LinkedList<Integer> res = new LinkedList<Integer>();
            LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
            stack.addFirst(root);
            while (!stack.isEmpty()) {
                root = stack.removeFirst();
                if (null != root) {
                    res.addLast(root.val);
                    stack.addFirst(root.left);
                    stack.addFirst(root.right);
                }
            }
            Collections.reverse(res);
            return res;
        }
    }
}
