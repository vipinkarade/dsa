package trees;

import java.util.Stack;

public class DiameterOfBinaryTree
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

		System.out.println(diameterOfBinaryTree(root));
	}

	private static int diameterOfBinaryTree(TreeNode root)
	{
		if (root == null || (root.left == null && root.right == null))
			return 0;
		else
		{
			int maxLengthFromRoot = maxDepth(root.left) + maxDepth(root.right);
			maxLengthFromRoot = Math.max(maxLengthFromRoot, Math.max(diameterOfBinaryTree(root.right),
				diameterOfBinaryTree(root.left)));
			return maxLengthFromRoot;
		}
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

	private static int diameterOfBinaryTree1(TreeNode root)
	{
		int[] res = new int[1];
		dfs(root, res);
		return res[0];
	}

	private static int dfs(TreeNode root, int[] res) {
		if (root == null) {
			return 0;
		}
		int left = dfs(root.left, res);
		int right = dfs(root.right, res);
		res[0] = Math.max(res[0], left + right);
		return 1 + Math.max(left, right);
	}
}
