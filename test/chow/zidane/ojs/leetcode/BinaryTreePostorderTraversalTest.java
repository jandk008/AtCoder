package chow.zidane.ojs.leetcode;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import chow.zidane.ojs.leetcode.BinaryTreePostorderTraversal.DepthFirstSearch;
import chow.zidane.ojs.leetcode.BinaryTreePostorderTraversal.Interation;
import chow.zidane.ojs.leetcode.BinaryTreePostorderTraversal.Recursion;
import chow.zidane.ojs.leetcode.BinaryTreePostorderTraversal.TreeNode;
import org.junit.jupiter.api.Test;

class BinaryTreePostorderTraversalTest {

    @Test
    void testSolution() {
        Integer[] expectedSequence = new Integer[] {4, 5, 2, 6, 3, 1};
        BinaryTreePostorderTraversal binaryTreePostorderTraversal = new BinaryTreePostorderTraversal();
        TreeNode a = binaryTreePostorderTraversal.new TreeNode(1);
        TreeNode b = binaryTreePostorderTraversal.new TreeNode(2);
        TreeNode c = binaryTreePostorderTraversal.new TreeNode(3);
        TreeNode d = binaryTreePostorderTraversal.new TreeNode(4);
        TreeNode e = binaryTreePostorderTraversal.new TreeNode(5);
        TreeNode f = binaryTreePostorderTraversal.new TreeNode(6);
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.right = f;
        Recursion recursion = new Recursion();
        DepthFirstSearch depthFirstSearch = new DepthFirstSearch();
        Interation interation = new Interation();

        assertArrayEquals(expectedSequence, recursion.postorderTraversal(a).toArray(new Integer[expectedSequence.length]));
        assertArrayEquals(expectedSequence, depthFirstSearch.postorderTraversal(a).toArray(new Integer[expectedSequence.length]));
        assertArrayEquals(expectedSequence, interation.postorderTraversal(a).toArray(new Integer[expectedSequence.length]));

    }
}
