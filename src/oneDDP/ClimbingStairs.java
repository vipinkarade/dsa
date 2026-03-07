package oneDDP;

public class ClimbingStairs
{
	static void main()
	{
		int n = 5;
		long start = System.currentTimeMillis();
		System.out.println(climbingStairs(n));
		long start1 = System.currentTimeMillis();
		System.out.println(climbingStairs1(n));
		long end = System.currentTimeMillis();
		long x = start1 - start;
		System.out.println(x);
		long x1 = end - start1;
		System.out.println(x1);
	}

	// Brute Force and memoization
	private static int climbingStairs(int n)
	{
		int[] steps = new int[n + 1];
		steps[0] = 1;
		int[] decisions = new int[]{1, 2};
		return steps(n, decisions,steps);
	}

	private static int steps(int n, int[] decisions, int[] steps)
	{
		if (n < 0)
			return 0;
		else if (steps[n] != 0)
			return steps[n];

		int total = 0;

		for (int decision : decisions)
		{
			total += steps(n - decision, decisions, steps);
		}
		steps[n] = total;
		return total;
	}

	// Fibonacci
	private static int climbingStairs1(int n)
	{
		int first = 1, second = 1;
		int temp;
		for (int i = 0; i < n - 1; i++)
		{
			temp = first;
			first += second;
			second = temp;
		}
		return first;
	}
}
