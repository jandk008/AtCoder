package chow.zidane.ojs.leetcode;

public class KthSmallestInBST {

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
		TreeNode a = new TreeNode(4);
		TreeNode b = new TreeNode(2);
		TreeNode c = new TreeNode(6);
		TreeNode d = new TreeNode(1);
		TreeNode e = new TreeNode(3);
		TreeNode f = new TreeNode(5);
		a.left = b;
		a.right = c;
		b.left = d;
		b.right = e;
		c.left = f;
		System.out.println(kethBst.kthSmallest(a, 5));
	}
}
