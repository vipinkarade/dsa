package heapAndPriorityQueue;

public class TaskScheduler
{
	static void main()
	{

	}

	private static int leastInterval(char[] tasks, int n)
	{
		int[] count = new int[26];
		for (char task : tasks)
		{
			count[task - 'A']++;
		}

		int max = 0;
		int countOfMax = 0;
		for (int i = 0; i < 26; i++)
		{
			if (count[i] > max)
			{
				max = count[i];
				countOfMax = 1;
			}
			else if (count[i] == max)
				countOfMax++;
		}

		return Math.max(max + ((max - 1) * n) + countOfMax - 1, tasks.length);
	}
}
