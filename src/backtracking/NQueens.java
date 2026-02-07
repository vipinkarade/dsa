package backtracking;

import java.util.ArrayList;
import java.util.List;

public class NQueens
{
	static void main()
	{

	}

	private static List<List<String>> solveNQueens(int n)
	{
		List<List<String>> result = new ArrayList<>();
		populateResult(result, n, new ArrayList<>());
		return result;
	}

	private static void populateResult(List<List<String>> result, int n, List<String> board)
	{
		if (board.size() == n)
			result.add(new ArrayList<>(board));
		else
		{
			for (int i = 0; i < n; i++)
			{
				if (isValid(board, i))
				{
					String boardRow = "";
					for (int j = 0; j < n; j++)
					{
						if (i == j)
							boardRow += "Q";
						else
							boardRow += ".";
					}
					board.add(boardRow);
					populateResult(result, n, board);
					board.remove(board.size() - 1);
				}
			}
		}
	}

	private static boolean isValid(List<String> board, int n)
	{
		int row = board.size() - 1, l = n - 1, r = n + 1;
		while (row >= 0 && (n >= 0 || n < board.get(0).length()))
		{
			// vertical check
			if (board.get(row).substring(n, n + 1).equals("Q"))
				return false;

			// left diagnol check
			if (l >= 0 && board.get(row).substring(l, l + 1).equals("Q"))
				return false;
			// right diagnol check
			if (r < board.get(0).length() && board.get(row).substring(r, r + 1).equals("Q"))
				return false;

			row--;
			l--;
			r++;
		}
		return true;
	}
}
