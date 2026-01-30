package trees;

public class InvertBinaryTree
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

		System.out.println(invertTree(root).getTreeNode());
	}

	private static TreeNode invertTree(TreeNode root)
	{
		if (root == null || (root.left == null && root.right == null))
			return root;
		else
		{
			TreeNode temp = root.left;
			root.left = invertTree(root.right);
			root.right = invertTree(temp);
			return root;
		}
	}
}
