package trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class BinaryTreeRightSideView
{
	static void main()
	{
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
//		root.left.left = new TreeNode(4);
//		root.left.right = new TreeNode(5);
//		root.right.left = new TreeNode(6);
//		root.right.right = new TreeNode(7);
		System.out.println(rightSideView(root));
	}

	private static List<Integer> rightSideView(TreeNode root)
	{
		List<Integer> result = new ArrayList<>();
		if (root == null)
			return result;

		Map<TreeNode, Integer> nodeToDepthMap = new HashMap<>();
		populateDepth(root, nodeToDepthMap);
		Queue<TreeNode> queue = new ArrayDeque<>();
		queue.add(root);
		TreeNode node;
		int size = 0;
		while (!queue.isEmpty())
		{
			node = queue.peek();
			result.add(node.val);

			size = queue.size();
			for (int i = 0; i < size; i++)
			{
				node = queue.poll();
				int leftDepth = nodeToDepthMap.getOrDefault(node.left, 0);
				int rightDepth = nodeToDepthMap.getOrDefault(node.right, 0);
				if (rightDepth > 0)
					queue.add(node.right);
				else if (leftDepth > 0)
					queue.add(node.left);

				if (leftDepth > rightDepth && rightDepth > 0)
					queue.add(node.left);
			}
		}
		return result;
	}

	private static int populateDepth(TreeNode root, Map<TreeNode, Integer> map)
	{
		if (root == null)
			return 0;
		else
		{
			map.put(root, 1 + Math.max(populateDepth(root.left, map), populateDepth(root.right, map)));
			return map.get(root);
		}
	}

	private static List<Integer> rightSideView1(TreeNode root)
	{
		List<Integer> result = new ArrayList<>();
		int depth = 0;

		populateResult(root, result, depth);
		return result;
	}

	private static void populateResult(TreeNode root, List<Integer> result, int depth)
	{
		if (root == null)
			return;

		if (result.size() == depth)
			result.add(root.val);

		populateResult(root.right, result, depth + 1);
		populateResult(root.left, result, depth + 1);
	}
}
