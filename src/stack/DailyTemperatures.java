package stack;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures
{
	static void main()
	{
		int[] temperatures = {30,38,30,36,35,40,28};
		System.out.println(Arrays.toString(dailyTemperatures1(temperatures)));
	}

	private static int[] dailyTemperatures(int[] temperatures)
	{
		int[] result = new int[temperatures.length];
		Stack<Integer> stack = new Stack<>();

		int index = temperatures.length - 1;
		for (int i = temperatures.length - 1; i >=0; i--)
		{
			int curr = temperatures[i];

			if (stack.isEmpty())
			{
				result[index--] = 0;
				stack.push(i);
			}
			else
			{
				while (!stack.isEmpty() && curr >= temperatures[stack.peek()])
				{
					stack.pop();
				}
				result[index--] = stack.isEmpty() ? 0 : stack.peek() - i;
				stack.push(i);
			}
		}
		return result;
	}

	private static int[] dailyTemperatures1(int[] temperatures)
	{
		int[] result = new int[temperatures.length];

		int index = temperatures.length - 2;

		for (int i = temperatures.length - 2; i >=0; i--)
		{
			int currTemp = temperatures[i];
			int tempIndex = i + 1;
			while(index == i)
			{
				if (currTemp < temperatures[tempIndex])
					result[index--] = tempIndex - i;
				else if (result[tempIndex] == 0)
					index--;
				else
				{
					tempIndex = tempIndex + result[tempIndex];
				}
			}
		}

		return result;
	}
}
