package trees;

import java.util.HashMap;
import java.util.Map;

public class BalancedBinaryTree
{
	static void main()
	{
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(4);

		System.out.println(isBalanced(root));
	}

	private static boolean isBalanced(TreeNode root)
	{
		Map<TreeNode, Integer> nodeToDepthMap = new HashMap<>();
		return isBalanced(root, nodeToDepthMap);
	}

	private static boolean isBalanced(TreeNode root, Map<TreeNode, Integer> nodeToDepthMap)
	{
		if (root == null)
			return true;
		else
		{
			Integer leftDepth = nodeToDepthMap.get(root.left);
			Integer rightDepth = nodeToDepthMap.get(root.right);
			if (leftDepth == null)
				leftDepth = maxDepth(root.left, nodeToDepthMap);
			if (rightDepth == null)
				rightDepth = maxDepth(root.right, nodeToDepthMap);
			if (Math.abs(leftDepth - rightDepth) <= 1)
				return isBalanced(root.left, nodeToDepthMap) && isBalanced(root.right, nodeToDepthMap);
			else
				return false;
		}
	}

	private static int maxDepth(TreeNode root, Map<TreeNode, Integer> nodeToDepthMap)
	{
		if (root == null)
			return 0;
		else
		{
			int leftDepth = nodeToDepthMap.getOrDefault(root.left, -1);
			int rightDepth = nodeToDepthMap.getOrDefault(root.right, -1);
			if (leftDepth == -1)
				leftDepth = maxDepth(root.left, nodeToDepthMap);
			if (rightDepth == -1)
				rightDepth = maxDepth(root.right, nodeToDepthMap);
			nodeToDepthMap.put(root, 1 + Math.max(leftDepth, rightDepth));
			return nodeToDepthMap.get(root);
		}
	}
}
