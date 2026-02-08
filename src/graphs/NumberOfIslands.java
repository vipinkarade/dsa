package graphs;

public class NumberOfIslands
{
	static void main()
	{

	}

	private static int numOfIslands(char[][] grid)
	{
		int count = 0;
		for (int row = 0; row < grid.length; row++)
		{
			for (int col = 0; col < grid[0].length; col++)
			{
				if (isIsland(grid, row, col))
					count++;
			}
		}
		return count;
	}

	private static boolean isIsland(char[][] grid, int row, int col)
	{
		if (row < 0 || row == grid.length ||  col < 0 || col == grid[0].length || grid[row][col] != '1')
			return false;
		else
		{
			grid[row][col] = '/';
			isIsland(grid, row + 1, col);
			isIsland(grid, row - 1, col);
			isIsland(grid, row, col + 1);
			isIsland(grid, row, col - 1);
			return true;
		}
	}
}
