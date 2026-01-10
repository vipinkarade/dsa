package stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class ValidParentheses
{
	static void main()
	{
//		String s = "{[]}";
		String s = "{[()]]}";
		System.out.println(isValid(s));
	}

	private static boolean isValid(String s)
	{
		Map<Character, Character> refMap = new HashMap<>();
		refMap.put(')', '(');
		refMap.put('}', '{');
		refMap.put(']', '[');

		Set<Character> closingVal = refMap.keySet();

		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < s.length(); i++)
		{
			Character curr = s.charAt(i);

			if (stack.size() == 0)
			{
				if (closingVal.contains(curr))
					return false;
				else
					stack.push(curr);
			}
			else
			{
				if (closingVal.contains(curr))
				{
					if (stack.get(stack.size() - 1) == refMap.get(curr))
						stack.pop();
					else
						return false;
				}
				else
					stack.push(curr);
			}

		}
		return stack.isEmpty();
	}
}
