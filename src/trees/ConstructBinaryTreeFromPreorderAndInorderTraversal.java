package trees;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal
{
	static void main()
	{

	}

	private static TreeNode buildTree(int[] preorder, int[] inorder)
	{
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < inorder.length; i++)
		{
			map.put(inorder[i], i);
		}

		return generateTree(preorder, map, 0, -1, preorder.length);
	}

	private static TreeNode generateTree(int[] preorder, Map<Integer, Integer> map, int curr, int from, int to)
	{
		if (to - from < 2)
			return null;
		else
		{
			return new TreeNode(preorder[curr],
				generateTree(preorder, map, curr + 1, from, map.get(preorder[curr])),
				generateTree(preorder, map, curr + map.get(preorder[curr]) - from, map.get(preorder[curr]), to));
		}
	}
}
