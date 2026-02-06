package backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses
{
	static void main()
	{

	}

	private static List<String> generateParentheses(int n)
	{
		List<String> result = new ArrayList<>();
		populateResult(n, 1, 0, "(", result);
		return result;
	}

	private static void populateResult(int n, int open, int close, String res, List<String> result)
	{
		if (res.length() == 2 * n && open == n)
			result.add(res);
		else
		{
			if (open > close)
				populateResult(n, open, close + 1, res + ")", result);
			if (open < n)
				populateResult(n, open + 1, close, res + "(", result);
		}
	}
}
