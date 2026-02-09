package graphs;

import java.util.Arrays;

public class RottingFruit
{
	static void main()
	{
//		int[][] grid = new int[][]{
//			{1,1,0},
//			{0,1,1},
//			{0,1,2}
//		};
		int[][] grid = new int[][]{
			{2,1,1},
			{1,1,1},
			{0,1,2}
		};
		System.out.println(orangesRotting(grid));
		System.out.println(Arrays.toString(grid[2]));
	}

	private static int orangesRotting(int[][] grid)
	{
		for (int row = 0; row < grid.length; row++)
		{
			for (int col = 0; col < grid[0].length; col++)
			{
				if (grid[row][col] == 2)
					populateTime(grid, row, col, 0);
			}
		}
		int max = 0;
		for (int row = 0; row < grid.length; row++)
		{
			for (int col = 0; col < grid[0].length; col++)
			{
				if (grid[row][col] == 1)
					return -1;
				else if (grid[row][col] < 0)
					max = Math.max(max, -1 * grid[row][col]);
			}
		}
		return max;
	}

	private static void populateTime(int[][] grid, int row, int col, int count)
	{
		if (row < 0 || row == grid.length || col < 0 || col == grid[0].length || (grid[row][col] == 2 && count != 0) || grid[row][col] == 0 || (grid[row][col] < 0 && grid[row][col] > (-1 * count)))
			return;

		grid[row][col] = grid[row][col] == 1 ? (-1 * count) : Math.max(grid[row][col], (-1 * count));
		count++;
		populateTime(grid, row + 1, col, count);
		populateTime(grid, row - 1, col, count);
		populateTime(grid, row, col + 1, count);
		populateTime(grid, row, col - 1, count);
	}
}
