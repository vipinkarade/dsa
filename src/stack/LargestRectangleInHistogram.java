package stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class LargestRectangleInHistogram
{
	static void main()
	{
		int[] heights = {7,1,7,2,2,4};
		System.out.println(largestRectangleArea(heights));
	}

	private static int largestRectangleArea(int[] heights)
	{
		Stack<Integer> stack = new Stack<>();
		int maxArea = 0;

		for (int i = 0; i <= heights.length; i++)
		{
			while (!stack.isEmpty() && (i == heights.length || heights[i] < heights[stack.peek()]))
			{
				int height = heights[stack.pop()];
				int width = stack.isEmpty() ? i : i - stack.peek() -1;
				maxArea = Math.max(maxArea, height * width);
			}
			stack.push(i);
		}

		return maxArea;
	}
}
