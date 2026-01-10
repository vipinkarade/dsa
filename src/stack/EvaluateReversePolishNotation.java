package stack;

import java.util.Set;
import java.util.Stack;

public class EvaluateReversePolishNotation
{
	static void main()
	{
//		String[] tokens = {"4","13","5","/","+"};
		String[] tokens = {"2","1","+","3","*"};
		System.out.println(evalPRN1(tokens));
	}

	private static int evalPRN(String[] tokens)
	{
		Set<String> operators = Set.of("+", "-", "*", "/");
		Stack<String> backStack = new Stack<>();
		Stack<Integer> remainStack = new Stack<>();

		for (int i = tokens.length - 1; i >= 0; i--)
		{
			backStack.push(tokens[i]);
		}

		while(!backStack.isEmpty())
		{
			String val = backStack.pop();
			if (operators.contains(val))
			{
				int secondNum = remainStack.pop();
				int firstNum = remainStack.pop();
				int subResult = 0;
				if (val.equals("+"))
					subResult = firstNum + secondNum;
				else if (val.equals("-"))
					subResult = firstNum - secondNum;
				else if (val.equals("*"))
					subResult = firstNum * secondNum;
				else if (val.equals("/"))
					subResult = firstNum / secondNum;
				remainStack.push(subResult);
			}
			else
				remainStack.push(Integer.parseInt(val));
		}

		return remainStack.peek();
	}

	private static int evalPRN1(String[] tokens)
	{
		Stack<Integer> stack = new Stack<>();
		for (String val : tokens)
		{
			if (("+-*/").contains(val))
			{
				int secNum = stack.pop();
				int firNum = stack.pop();
				if (val.equals("+"))
					stack.push(firNum + secNum);
				else if (val.equals("-"))
					stack.push(firNum - secNum);
				else if (val.equals("*"))
					stack.push(firNum * secNum);
				else if (val.equals("/"))
					stack.push(firNum / secNum);
			}
			else
				stack.push(Integer.parseInt(val));
		}

		return stack.peek();
	}
}
