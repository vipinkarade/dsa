package trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal
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
		System.out.println(levelOrder(root));
		System.out.println(levelOrder2(root));
	}

	private static List<List<Integer>> levelOrder(TreeNode root)
	{
		List<Integer> subResult = getTreeNode(root);
		List<List<Integer>> result = new ArrayList<>();
		int power = 0;
		int count = 0;

		for (int i = 0; i< subResult.size(); i++)
		{
			if (count == 0)
			{
				result.add(new ArrayList<>());
			}
			Integer e = subResult.get(i);
			if (e != null)
				result.get(power).add(e);
			count++;

			if (count == Math.pow(2, power))
			{
				count = 0;
				power++;
			}
		}
		return result;
	}

	private static List<Integer> getTreeNode(TreeNode root)
	{
		List<Integer> result = new ArrayList<>();
		if (root == null)
			return result;
		List<Integer> leftResult = new ArrayList<>();
		List<Integer> rightResult = new ArrayList<>();
		result.add(root.val);

		if (root.left != null)
			leftResult = getTreeNode(root.left);

		if (root.right != null)
			rightResult = getTreeNode(root.right);

		int count = 1;

		while (count <= leftResult.size() || count <= rightResult.size())
		{
			for (int i = count - 1; i < 2*count - 1; i++)
			{
				if (leftResult.size() > i)
					result.add(leftResult.get(i));
				else
					result.add(null);
			}

			for (int i = count - 1; i < 2*count - 1; i++)
			{
				if (rightResult.size() > i)
					result.add(rightResult.get(i));
				else
					result.add(null);
			}

			count *= 2;
		}

		return result;
	}

	private static List<List<Integer>> levelOrder1(TreeNode root)
	{
		Queue<TreeNode> queue = new ArrayDeque<>();

		List<List<Integer>> result = new ArrayList<>();
		if (root == null)
			return result;

		queue.add(root);
		TreeNode node;
		List<TreeNode> nodes = new ArrayList<>();
		while (!queue.isEmpty())
		{
			result.add(new ArrayList<>());
			int size = queue.size();
			for(int i = 0; i < size; i++)
			{
				node = queue.poll();
				nodes.add(node);
				result.get(result.size() - 1).add(node.val);
			}

			for(TreeNode remNode : nodes)
			{
				if (remNode.left != null)
					queue.add(remNode.left);
				if (remNode.right != null)
					queue.add(remNode.right);
			}
			nodes = new ArrayList<>();
		}
		return result;
	}

	private static List<List<Integer>> levelOrder2(TreeNode root)
	{
		Queue<TreeNode> queue = new ArrayDeque<>();

		List<List<Integer>> result = new ArrayList<>();
		if (root == null)
			return result;

		queue.add(root);
		TreeNode newLayerNode = root;
		TreeNode node;
		while (!queue.isEmpty())
		{
			node = queue.poll();
			if (node.equals(newLayerNode))
			{
				result.add(new ArrayList<>());
				newLayerNode = null;
			}

			result.get(result.size() - 1).add(node.val);

			if (node.left != null)
			{
				queue.add(node.left);
				if (newLayerNode == null)
					newLayerNode = node.left;
			}

			if (node.right != null)
			{
				queue.add(node.right);
				if (newLayerNode == null)
					newLayerNode = node.right;
			}
		}

		return result;
	}

}
