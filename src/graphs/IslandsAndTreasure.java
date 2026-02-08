package graphs;

public class IslandsAndTreasure
{
	static void main()
	{

	}

	private static void islandsAndTreasure(int[][] grid)
	{
		for (int row = 0; row < grid.length; row++)
		{
			for (int col = 0; col < grid[0].length; col++)
			{
				if (grid[row][col] == 0)
					findTreasure(grid, row, col, 0);
			}
		}
	}

	private static void findTreasure(int[][] grid, int row, int col, int count)
	{
		if (row < 0 || row == grid.length || col < 0 || col == grid[0].length || (count !=0 && (grid[row][col] == 0 || grid[row][col] < count)) || grid[row][col] == -1)
			return;
		else
		{
			grid[row][col] = Math.min(grid[row][col], count);
			count++;
			findTreasure(grid, row + 1, col, count);
			findTreasure(grid, row - 1, col, count);
			findTreasure(grid, row, col + 1, count);
			findTreasure(grid, row, col - 1, count);
		}
	}
}
