package trees;

import java.util.HashMap;
import java.util.Map;

public class KthSmallestIntegerInBST
{
	static void main()
	{

	}

	private static int kthSmallest(TreeNode root, int k)
	{
		Map<TreeNode, Integer> map = new HashMap<>();
		populateMap(root, map);

		int elements = k;
		TreeNode result = root;
		while (elements > 0)
		{
			if ((result.left != null && map.get(result.left) + 1 == elements) || (result.left == null && elements == 1))
				return result.val;
			if (result.left != null && map.get(result.left) >= elements)
				result = result.left;
			else if (result.left != null && map.get(result.left) < elements)
			{
				elements = elements - map.get(result.left) - 1;
				result = result.right;
			}
			else if (result.left == null)
			{
				result = result.right;
				elements--;
			}

		}
		return result.val;
	}

	private static int populateMap(TreeNode root, Map<TreeNode, Integer> map)
	{
		if (root == null)
			return 0;
		else if (root.left == null && root.right == null)
		{
			map.put(root, 1);
			return 1;
		}
		else
		{
			map.put(root, 1 + populateMap(root.left, map) + populateMap(root.right, map));
			return map.get(root);
		}
	}
}
