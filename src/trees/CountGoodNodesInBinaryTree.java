package trees;

public class CountGoodNodesInBinaryTree
{
	static void main()
	{

	}

	private static int goodNodes(TreeNode root)
	{
		int[] count = new int[]{0};
		getCount(root, count, Integer.MIN_VALUE);
		return count[0];
	}

	private static void getCount(TreeNode root, int[] count, int maxValue)
	{
		if (root != null)
		{
			if (root.val >= maxValue)
			{
				maxValue = root.val;
				count[0]++;
			}
			getCount(root.left, count, maxValue);
			getCount(root.right, count, maxValue);
		}
	}
}
