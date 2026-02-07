package backtracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning
{
	static void main()
	{

	}

	private static List<List<String>> partition(String s)
	{
		List<List<String>> result = new ArrayList<>();
		populateResult(result, s, 0, new ArrayList<>());
		return result;
	}

	private static void populateResult(List<List<String>> result, String s, int index, List<String> subResult)
	{
		if (index == s.length())
			result.add(new ArrayList<>(subResult));
		else
		{
			for (int i = index; i < s.length(); i++)
			{
				if (isPalindrome(s, index, i))
				{
					subResult.add(s.substring(index, i + 1));
					populateResult(result, s, i + 1, subResult);
					subResult.remove(subResult.size() - 1);
				}
			}
		}
	}

	private static boolean isPalindrome(String s, int start, int end)
	{
		if (start == end && start < s.length())
			return true;
		else if (start < 0 || end >= s.length())
			return false;
		else
		{
			int l = start, r = end;
			while (l < r)
			{
				if (s.charAt(l) != s.charAt(r))
					return false;
				l++;
				r--;
			}
			return true;
		}
	}
}
