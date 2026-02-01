package trees;

public class ValidBinarySearchTree
{
	static void main()
	{
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.right = new TreeNode(6, new TreeNode(3), new TreeNode(7));

		TreeNode root1 = new TreeNode(2, new TreeNode(1), new TreeNode(3));
		TreeNode root2 = new TreeNode(1, new TreeNode(1), null);

		TreeNode root3 = new TreeNode(3, new TreeNode(1), new TreeNode(5));
		root3.left.left = new TreeNode(0);
		root3.left.right = new TreeNode(2);
		root3.right.left = new TreeNode(4);
		root3.right.right = new TreeNode(6);

		System.out.println(isValidBST(root));
		System.out.println(isValidBST(root1));
		System.out.println(isValidBST(root2));
		System.out.println(isValidBST(root3));
	}

	private static boolean isValidBST(TreeNode root) {
		return isValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private static boolean isValid(TreeNode root, int minVal, int maxVal)
	{
		if (root == null)
			return true;
		else
		{
			if (root.val > minVal && root.val < maxVal)
				return isValid(root.left, Math.min(minVal, root.val), Math.min(maxVal, root.val)) && isValid(root.right,
					Math.max(root.val, minVal), Math.max(maxVal, root.val));
			return false;
		}
	}
}
