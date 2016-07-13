package chow.zidane.ojs.leetcode;


public class KthSmallestInBST {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	int c = 0;
    int res = Integer.MIN_VALUE;
    
	public int kthSmallest(TreeNode root, int k) {
		
        return inOrder(root, k);
    }
    public int inOrder(TreeNode root,int k){
    	 if(null != root){
             if( c < k){
                 inOrder(root.left, k);
                 c++;
                 if (c == k){
                     res = root.val;
                     return res;
                 }
                 inOrder(root.right, k);
             }
         }
         return res;
    }
    
    public static void main(String[] args) {
    	KthSmallestInBST kethBst = new KthSmallestInBST();
		TreeNode a = kethBst.new TreeNode(4);
		TreeNode b = kethBst.new TreeNode(2);
		TreeNode c = kethBst.new TreeNode(6);
		TreeNode d = kethBst.new TreeNode(1);
		TreeNode e = kethBst.new TreeNode(3);
		TreeNode f = kethBst.new TreeNode(5);
		a.left = b;
		a.right = c;
		b.left = d;
		b.right = e;
		c.left = f;
		System.out.println(kethBst.kthSmallest(a, 5));
	}
}
