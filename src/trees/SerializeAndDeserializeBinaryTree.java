package trees;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

public class SerializeAndDeserializeBinaryTree
{
	static void main()
	{
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.right.right = new TreeNode(4, null, new TreeNode(5));

		SerializeAndDeserializeBinaryTree a = new SerializeAndDeserializeBinaryTree();
		String serialize = a.serialize(root);
		System.out.println(serialize);
		System.out.println(a.deserialize(serialize).getTreeNode());
	}

	public String serialize(TreeNode root)
	{
		if (root == null)
			return null;
		StringBuilder sb = new StringBuilder();
		Queue<TreeNode> queue = new ArrayDeque<>();
		queue.add(root);
		TreeNode emptyNode = new TreeNode();
		while (!queue.isEmpty())
		{
			TreeNode currNode = queue.poll();
			if (currNode.equals(emptyNode))
				sb.append("null").append(",");
			else
			{
				sb.append(currNode.val).append(",");

				if (currNode.left != null)
					queue.add(currNode.left);
				else
					queue.add(emptyNode);

				if (currNode.right != null)
					queue.add(currNode.right);
				else
					queue.add(emptyNode);
			}

		}
		String result = sb.toString();
		while (result.endsWith("null,"))
		{
			result = result.substring(0, result.length() - ("null,").length());
		}
		return result.substring(0, result.length() - 1);
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data)
	{
		if (data == null || ("").equals(data))
			return null;

		String[] elements = data.split(",");
		TreeNode root = new TreeNode(Integer.parseInt(elements[0]));
		Queue<TreeNode> queue = new ArrayDeque<>();
		queue.add(root);
		for (int i = 1; i < elements.length; i += 2)
		{
			TreeNode currNode = queue.poll();
			if (!elements[i].equals("null"))
			{
				currNode.left = new TreeNode(Integer.parseInt(elements[i]));
				queue.add(currNode.left);
			}

			if ((i + 1 < elements.length) && !elements[i + 1].equals("null"))
			{
				currNode.right = new TreeNode(Integer.parseInt(elements[i + 1]));
				queue.add(currNode.right);
			}
		}

		return root;
	}
}
