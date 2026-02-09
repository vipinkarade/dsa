package graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PacificAtlanticWaterFlow
{
	static void main()
	{
//		int[][] grid = new int[][]{
//			{4,2,7,3,4},
//			{7,4,6,4,7},
//			{6,3,5,3,6}
//		};
		int[][] grid = new int[][]{
			{1,2,7,3,4},
			{3,2,3,4,4},
			{2,4,5,3,1},
			{6,7,1,4,5},
			{5,1,1,2,4}
		};
//		int[][] grid = new int[][]{
//			{1,2,3},
//			{8,9,4},
//			{7,6,5}
//		};
		System.out.println(pacificAtlantic(grid));
	}

	private static List<List<Integer>> pacificAtlantic(int[][] heights)
	{
		Set<List<Integer>> pacificSet = new HashSet<>();
		Set<List<Integer>> atlanticSet = new HashSet<>();

		// traverse over row 0
		for (int i = 0; i < heights[0].length; i++)
		{
			populatePacificSet(heights, 0, i, pacificSet);
		}

		// traverse over col 0
		for (int i = 0; i < heights.length; i++)
		{
			populatePacificSet(heights, i, 0, pacificSet);
		}

		// traverse over last row
		for (int i = 0; i < heights[0].length; i++)
		{
			populateAtlanticSet(heights, heights.length - 1, i, atlanticSet);
		}

		// traverse over last col
		for (int i = 0; i < heights.length; i++)
		{
			populateAtlanticSet(heights, i, heights[0].length - 1, atlanticSet);
		}

		return pacificSet.stream().filter(atlanticSet::contains).toList();
	}

	private static void populatePacificSet(int[][] heights, int row, int col, Set<List<Integer>> pacificSet)
	{
		List<Integer> subArray = new ArrayList<>();
		subArray.add(row);
		subArray.add(col);
		if (pacificSet.contains(subArray))
			return;
		pacificSet.add(subArray);

		if (row != heights.length - 1 && heights[row][col] <= heights[row + 1][col])
			populatePacificSet(heights, row  + 1, col, pacificSet);

		if (col != heights[0].length - 1 && heights[row][col] <= heights[row][col + 1])
			populatePacificSet(heights, row, col + 1, pacificSet);

		if (col != 0 && heights[row][col] <= heights[row][col - 1])
			populatePacificSet(heights, row, col - 1, pacificSet);
	}

	private static void populateAtlanticSet(int[][] heights, int row, int col, Set<List<Integer>> atlanticSet)
	{
		List<Integer> subArray = new ArrayList<>();
		subArray.add(row);
		subArray.add(col);
		if (atlanticSet.contains(subArray))
			return;
		atlanticSet.add(subArray);

		if (row != 0 && heights[row][col] <= heights[row - 1][col])
			populateAtlanticSet(heights, row  - 1, col, atlanticSet);

		if (col != 0 && heights[row][col] <= heights[row][col - 1])
			populateAtlanticSet(heights, row, col - 1, atlanticSet);

		if (col != heights[0].length - 1 && heights[row][col] <= heights[row][col + 1])
			populateAtlanticSet(heights, row, col + 1, atlanticSet);
	}
}