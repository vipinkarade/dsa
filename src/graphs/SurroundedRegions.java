package graphs;

import java.util.HashSet;
import java.util.Set;

public class SurroundedRegions
{
	static void main()
	{

	}

	private static void solve(char[][] board)
	{
		Set<String> nonOs = new HashSet<>();

		//traversing over the row
		for (int i = 1; i < board[0].length - 1; i++)
		{
			if (board[0][i] == 'O')
				populateMap(board, 0, i, nonOs);
			if (board[board.length - 1][i] == 'O')
				populateMap(board, board.length - 1, i, nonOs);
		}
		//traversing over the row
		for (int i = 1; i < board.length - 1; i++)
		{
			if (board[i][0] == 'O')
				populateMap(board, i, 0, nonOs);
			if (board[i][board[0].length - 1] == 'O')
				populateMap(board, i, board[0].length - 1, nonOs);
		}

		for (int row = 1; row < board.length - 1; row++)
		{
			for (int col = 1; col < board[0].length - 1; col++)
			{
				if (board[row][col] == 'O' && !nonOs.contains(row + "," + col))
					board[row][col] = 'X';
			}
		}
	}

	private static void populateMap(char[][] board, int row, int col, Set<String> set)
	{
		String key = row + "," + col;
		if (!(row < 0 || row == board.length || col < 0 || col == board[0].length) && !set.contains(key) && board[row][col] == 'O')
		{
			set.add(key);
			populateMap(board, row + 1, col, set);
			populateMap(board, row - 1, col, set);
			populateMap(board, row, col + 1, set);
			populateMap(board, row, col - 1, set);
		}

	}
}
