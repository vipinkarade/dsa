package backtracking;

import java.util.HashSet;

public class SearchForWord
{
	static void main()
	{

	}

	private static boolean exist(char[][] board, String word)
	{
		boolean found = false;
		for (int row = 0; row < board.length; row++)
		{
			for (int col = 0; col < board[0].length; col++)
			{
				if (findWord(board, row, col, word, new HashSet<String>()))
				{
					found = true;
					break;
				}
			}
		}
		return found;
	}

	private static boolean findWord(char[][] board, int row, int col, String word, HashSet<String> set)
	{
		if (row == board.length || col == board[0].length || col == -1 || row == -1 || board[row][col] != word.charAt(0) || set.contains("" + row + "," + col))
			return false;
		else if (word.length() == 1 && board[row][col] == word.charAt(0))
			return true;

		set.add("" + row + "," + col);
		return findWord(board, row + 1, col, word.substring(1), new HashSet<>(set))
			       || findWord(board, row - 1, col, word.substring(1), new HashSet<>(set))
			       || findWord(board, row, col -1, word.substring(1), new HashSet<>(set))
			       || findWord(board, row, col + 1, word.substring(1), new HashSet<>(set));
	}
}
