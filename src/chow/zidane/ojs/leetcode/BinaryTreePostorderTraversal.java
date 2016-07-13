package chow.zidane.ojs.leetcode;

import java.util.LinkedList;
import java.util.List;

public class BinaryTreePostorderTraversal {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public List<Integer> postorderTraversal(TreeNode root) {
		LinkedList<Integer> res = new LinkedList<Integer>();
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
		while (true) {
			while(null != root){
				res.addFirst(root.val);
				stack.addLast(root);
				root = root.right;
			}
			if(stack.isEmpty()){
				break;
			}
			root = stack.removeLast();
			root = root.left;
		}
		return res;
	}

	public static void main(String[] args) {
		BinaryTreePostorderTraversal inorderTraversasl = new BinaryTreePostorderTraversal();
		TreeNode a = inorderTraversasl.new TreeNode(1);
		TreeNode b = inorderTraversasl.new TreeNode(2);
		TreeNode c = inorderTraversasl.new TreeNode(3);
		TreeNode d = inorderTraversasl.new TreeNode(4);
		TreeNode e = inorderTraversasl.new TreeNode(5);
		TreeNode f = inorderTraversasl.new TreeNode(6);
		a.left = b;
		a.right = c;
		b.left = d;
		b.right = e;
		c.left = f;
		System.out.println(inorderTraversasl.postorderTraversal(a));
	}
}
