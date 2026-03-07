package oneDDP;

public class ClimbingStairs
{
	static void main()
	{
		int n = 44;
		System.out.println(climbingStairs(n));
	}

	private static int climbingStairs(int n)
	{
		int[] steps = new int[n + 1];
		steps[0] = 1;
		int[] descision = new int[]{1, 2};
		return steps(n, descision,steps);
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
}
