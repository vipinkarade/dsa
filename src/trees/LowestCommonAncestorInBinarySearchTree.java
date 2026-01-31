package trees;

import java.util.HashSet;
import java.util.Set;

public class LowestCommonAncestorInBinarySearchTree
{
	static void main()
	{
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(1, null, new TreeNode(2));
		root.left.right = new TreeNode(4);
		root.right.left = new TreeNode(7);
		root.right.right = new TreeNode(9);

		System.out.println(lowestCommonAncestor(root, new TreeNode(3), new TreeNode(4)).val);
	}

	private static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q)
	{
		Set<TreeNode> nodesOfP = new HashSet<>();
		Set<TreeNode> nodesOfQ = new HashSet<>();
		nodesOfP.add(root);
		nodesOfQ.add(root);
		searchForNodes(root, p, nodesOfP);
		searchForNodes(root, q, nodesOfQ);

		TreeNode result = root;

		while(nodesOfP.contains(result) && nodesOfQ.contains(result))
		{
			if (result.val == p.val || result.val == q.val)
				return result;
			else if (nodesOfP.contains(result.left))
			{
				if (nodesOfQ.contains(result.right))
					return result;
				else
					result = result.left;
			}
			else if (nodesOfP.contains(result.right))
			{
				if (nodesOfQ.contains(result.left))
					return result;
				else
					result = result.right;
			}
		}
		return result;
	}

	private static boolean searchForNodes(TreeNode root, TreeNode p, Set<TreeNode> nodesOfP)
	{
		if (root == null)
			return false;
		else if (root.val == p.val)
		{
			nodesOfP.add(root);
			return true;
		}
		else
		{
			if (searchForNodes(root.left, p, nodesOfP))
			{
				nodesOfP.add(root.left);
				return true;
			}

			if (searchForNodes(root.right, p, nodesOfP))
			{
				nodesOfP.add(root.right);
				return true;
			}

			return false;
		}

	}
}
