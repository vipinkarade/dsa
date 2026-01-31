package trees;

public class SubtreeOfAnotherTree
{
	static void main()
	{
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(1);

		TreeNode subRoot = new TreeNode(1);

		System.out.println(isSubtree1(root, subRoot));
	}

	private static boolean isSubtree(TreeNode root, TreeNode subRoot)
	{
		if (root == null)
			return false;
		else
		{
			return isSameTree(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
		}
	}

	private static boolean isSameTree(TreeNode root, TreeNode subRoot)
	{
		if (root == null && subRoot == null)
			return true;
		else if ((root == null || subRoot == null) || root.val != subRoot.val)
			return false;
		else
			return isSameTree(root.left, subRoot.left) && isSameTree(root.right, subRoot.right);

	}

	private static boolean isSubtree1(TreeNode root, TreeNode subRoot)
	{
		StringBuilder sb = new StringBuilder();
		serialize(root, sb);
		String rootStr = sb.toString();
		sb = new StringBuilder();
		serialize(subRoot, sb);
		String subRootStr = sb.toString();
		return contains(rootStr, subRootStr);
	}

	private static boolean contains(String a, String b)
	{
		int aLen = a.length();
		int bLen = b.length();
		int l = 0, r = a.length() - 1;
		int firstOfB = b.charAt(0);
		int lastOfB = b.charAt(bLen - 1);

		while (l + bLen <= aLen)
		{
			if (a.charAt(l) == firstOfB && a.substring(l, l + bLen).equals(b))
				return true;
			else
				l++;

			if (a.charAt(r) == lastOfB && a.substring(r - bLen + 1, r + 1).equals(b))
				return true;
			else
				r--;
		}

		return aLen == bLen && a.equals(b);
	}

	private static void serialize(TreeNode root, StringBuilder sb)
	{
		if (root == null)
			sb.append("$#");
		else
		{
			sb.append("$").append(root.val);
			serialize(root.left, sb);
			serialize(root.right, sb);
		}
	}

	public static int[] z_function(String s) {
		int[] z = new int[s.length()];
		int l = 0, r = 0, n = s.length();
		for (int i = 1; i < n; i++) {
			if (i <= r) {
				z[i] = Math.min(r - i + 1, z[i - l]);
			}
			while (i + z[i] < n && s.charAt(z[i]) == s.charAt(i + z[i])) {
				z[i]++;
			}
			if (i + z[i] - 1 > r) {
				l = i;
				r = i + z[i] - 1;
			}
		}
		return z;
	}
}
