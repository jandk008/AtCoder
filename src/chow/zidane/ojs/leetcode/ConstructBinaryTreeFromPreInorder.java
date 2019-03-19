package chow.zidane.ojs.leetcode;

import java.util.LinkedList;

public class ConstructBinaryTreeFromPreInorder {

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    static class ListNode {

        TreeNode node;
        int index;
        int left;
        int right;

        ListNode(TreeNode node, int index, int left, int right) {
            this.node = node;
            this.index = index; // position in preorder
            this.left = left; // position in inorder
            this.right = right; // position in inorder
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        // linkedlist stores index of each non-leaf node in preorder
        LinkedList<ListNode> list = new LinkedList<ListNode>();
        TreeNode res = new TreeNode(preorder[0]);
        list.addLast(new ListNode(res, 0, 0, inorder.length - 1));
        while (!list.isEmpty()) {
            // root in preorder
            ListNode node = list.removeFirst();
            TreeNode root = node.node;
            int i = node.index;
            // root in inorder
            int j = 0;
            int l = 0; // index of left child node in pre
            int r = 0; // index of right child node in pre
            int m = node.left;
            int n = node.right; // whole size of current tree, n - m + 1
            TreeNode leftChild;
            TreeNode rightChild;
            while (inorder[j] != preorder[i]) {
                j++;
            }
            int leftChildSize = j - m;
            int rightChildSize = n - j;
            // int treeSize = leftChildSize + rightChildSize + 1;
            boolean hasLeft = leftChildSize > 0;
            if (hasLeft) {
                l = i + 1;
                leftChild = new TreeNode(preorder[l]);
                root.left = leftChild;
                // it means left child is a tree not a leaf
                if (leftChildSize > 1) {
                    list.addLast(new ListNode(leftChild, l, m, j - 1));
                }
            }
            boolean hasRight = rightChildSize > 0;
            if (hasRight) {
                r = i + leftChildSize + 1;
                rightChild = new TreeNode(preorder[r]);
                root.right = rightChild;
                // it means right child is a tree not a leaf
                if (rightChildSize > 1) {
                    list.addLast(new ListNode(rightChild, r, j + 1, n));
                }
            }
        }
        return res;
    }

    static class Recursion2 {

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            return buildTree(preorder, 0, inorder, inorder.length - 1, 0);
        }

        private TreeNode buildTree(
                int[] preorder, int idx, int[] inorder,
                int end, int start) {
            if (idx >= preorder.length || start > end) {
                return null;
            }
            TreeNode root = new TreeNode(preorder[idx]);
            int i;
            for (i = end; i >= start; i--) {
                if (preorder[idx] == inorder[i]) {
                    break;
                }
            }
            root.left = buildTree(preorder, idx + 1, inorder, i - 1, start);
            root.right = buildTree(preorder, idx + i - start + 1, inorder, end,
                    i + 1);
            return root;
        }

    }

    public static void main(String[] args) {
        new ConstructBinaryTreeFromPreInorder().buildTree(new int[] {1, 2, 4,
                5, 3, 6}, new int[] {4, 2, 5, 1, 6, 3});
    }
}
