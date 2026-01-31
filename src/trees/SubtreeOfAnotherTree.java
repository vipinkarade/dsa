package trees;

public class SubtreeOfAnotherTree
{
	static void main()
	{

	}

	private static boolean isSubtree(TreeNode root, TreeNode subRoot)
	{
		if (root == null)
			return false;
		else
		{
			return isSameTree(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
		}
	}

	private static boolean isSameTree(TreeNode root, TreeNode subRoot)
	{
		if (root == null && subRoot == null)
			return true;
		else if ((root == null || subRoot == null) || root.val != subRoot.val)
			return false;
		else
			return isSameTree(root.left, subRoot.left) && isSameTree(root.right, subRoot.right);

	}
}
