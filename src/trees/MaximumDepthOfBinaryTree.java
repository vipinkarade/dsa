package trees;

public class MaximumDepthOfBinaryTree
{
	static void main()
	{
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);

		System.out.println(maxDepth(root));
	}

	private static int maxDepth(TreeNode root)
	{
		if (root == null)
			return 0;
		else if (root.left == null && root.right == null)
			return 1;
		else
			return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
	}
}
