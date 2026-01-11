package stack;

import java.util.Stack;

public class CarFleet
{
	static void main()
	{
		int[] position = {4,1,0,7};
		int[] speed = {2,2,1,1};
		int target = 10;
		System.out.println(carFleet(target, position, speed));

	}

	private static int carFleet(int target, int[] position, int[] speed)
	{
		Stack<int[]> stack = new Stack<>();
		for (int i = 0; i < position.length; i++)
		{
			int[] car ={position[i], speed[i]};
			stack.push(car);
		}

		stack.sort((a, b) -> Integer.compare(a[0], b[0]));
		double time = Integer.MIN_VALUE;
		int result = 0;

		while (!stack.isEmpty())
		{
			int[] car = stack.pop();
			double distance = target - car[0];
			if (time < distance / car[1])
			{
				time = distance / car[1];
				result++;
			}

		}
		return result;
	}
}
