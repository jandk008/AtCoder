package chow.zidane.ojs.leetcode;

import java.util.LinkedList;
import java.util.List;

public class InorderTraversasl {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public class StackNode {
		TreeNode node;
		boolean left;
		boolean right;
		boolean traveled;

		public StackNode(TreeNode node, boolean left, boolean right,
				boolean traveled) {
			this.node = node;
			this.left = left;
			this.right = right;
			this.traveled = traveled;
		}
	}

	/**
	 * 1. Inorder traversal Iteratively. (2 ms) The whole process is easy to
	 * understand, hard part is how to implement it. The first one is an
	 * original solution, not gracious to read, but meaningful in practice. T(n)
	 * = O(n), beating 3.2 % submission, (the time results of all submission are
	 * clustering, centralized in 2 ms, and it will reduce some cost if using
	 * LinkedList instead of stack.
	 * 
	 * @author ziczhou
	 * 
	 */
	public class OriginalSolution {
		public List<Integer> inorderTraversal(TreeNode root) {
			List<Integer> res = new LinkedList<Integer>();
			if (null == root) {
				return res;
			}
			LinkedList<StackNode> stack = new LinkedList<StackNode>();
			stack.add(new StackNode(root, null == root.left ? true : false,
					null == root.right ? true : false, false));
			while (!stack.isEmpty()) {
				StackNode stackNode = stack.removeLast();
				TreeNode cuNode = stackNode.node;
				// travel to left
				if (!stackNode.left && null != cuNode.left) {
					stackNode.left = true;
					stack.addLast(stackNode);
					cuNode = cuNode.left;
					stackNode = new StackNode(cuNode,
							null == cuNode.left ? true : false,
							null == cuNode.right ? true : false, false);
					stack.addLast(stackNode);
				}
				if (stackNode.left && !stackNode.traveled) {
					res.add(cuNode.val);
					stackNode.traveled = true;
				}
				if (stackNode.left && !stackNode.right && null != cuNode.right) {
					stackNode.right = true;
					cuNode = cuNode.right;
					stackNode = new StackNode(cuNode,
							null == cuNode.left ? true : false,
							null == cuNode.right ? true : false, false);
					stack.addLast(stackNode);
				}
			}
			return res;
		}
	}

	/**
	 * 2. Gracious one. (1 ms) Idea is the same, but the design is gracious,
	 * learned a lot.
	 * T(n) = O(n), beating 60.33 % submission, pretty good.
	 * @author ziczhou
	 * 
	 */
	public class GraciousSolution {
		public List<Integer> inorderTraversal(TreeNode root) {
			List<Integer> res = new LinkedList<Integer>();
			LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
			while (true) {
				while (null != root) {
					stack.addLast(root);
					root = root.left;
				}
				if (stack.isEmpty()) {
					break;
				}
				root = stack.removeLast();
				res.add(root.val);
				root = root.right;
			}
			return res;
		}
	}

	public static void main(String[] args) {
		InorderTraversasl inorderTraversasl = new InorderTraversasl();
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
		System.out.println(inorderTraversasl.new GraciousSolution()
				.inorderTraversal(a));
	}
}
