package trees;

public class BinaryTreeMaximumPathSum
{
	static void main()
	{

	}

	private static int maxPathSum(TreeNode root)
	{
		int[] max = new int[]{Integer.MIN_VALUE};
		int maxForRoot = populateMax(root, max);
		return Math.max(max[0], maxForRoot);
	}

	public static int populateMax(TreeNode root, int[] max)
	{
		if (root == null)
			return 0;
		else
		{
			int left = Math.max(populateMax(root.left, max), 0);
			int right = Math.max(populateMax(root.right, max), 0);
			int sum = root.val + left + right;
			max[0] = Math.max(max[0], sum);
			return root.val + Math.max(left, right);
		}
	}
}
