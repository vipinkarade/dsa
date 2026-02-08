package graphs;

public class MaxAreaOfIsland
{
	static void main()
	{

	}

	private static int maxAreaOfIsland(int[][] grid)
	{
		int max = 0;
		for (int row = 0; row < grid.length; row++)
		{
			for (int col = 0; col < grid[0].length; col++)
			{
				max = Math.max(max, areaOfIsland(grid, row, col));
			}
		}
		return max;
	}

	private static int areaOfIsland(int[][] grid, int row, int col)
	{
		if (row < 0 || row == grid.length || col < 0 || col == grid[0].length || grid[row][col] != 1)
			return 0;
		else
		{
			grid[row][col] = 0;
			return 1 + areaOfIsland(grid, row - 1, col) + areaOfIsland(grid, row + 1, col) + areaOfIsland(grid, row, col - 1) + areaOfIsland(grid, row, col + 1);
		}
	}
}
