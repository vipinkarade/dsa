package trees;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TreeNode
{
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode()
	{

	}

	TreeNode(int val)
	{
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right)
	{
		this.val = val;
		this.left = left;
		this.right = right;
	}

	public List<Integer> getTreeNode()
	{
		List<Integer> result = new ArrayList<>();
		List<Integer> leftResult = new ArrayList<>();
		List<Integer> rightResult = new ArrayList<>();
		result.add(val);

		if (left != null)
			leftResult = left.getTreeNode();

		if (right != null)
			rightResult = right.getTreeNode();

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
}
