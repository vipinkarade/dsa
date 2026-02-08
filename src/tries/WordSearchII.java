package tries;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordSearchII
{
	static void main()
	{
//		char[][] board = new char[][]{
//			{'a','b','c','d'},
//			{'s','a','a','t'},
//			{'a','c','k','e'},
//			{'a','c','d','n'}};
//		String[] words = new String[]{"bat", "cat", "back", "backend", "stack"};
		char[][] board = new char[][]{
			{'a'}};
		String[] words = new String[]{"a"};
		System.out.println(findWords(board, words));
	}

	private static List<String> findWords(char[][] board, String[] words)
	{
		List<String> result = new ArrayList<>();
		Map<String, BoardChar> map = new HashMap<>();
		new BoardChar(board, 0, 0, map);

		for (int row = 0; row < board.length; row++)
		{
			for (int col = 0; col < board[0].length; col++)
			{
				for (String word : words)
				{
					if (!result.contains(word) && map.get(row + "," + col).search(word, 0))
						result.add(word);
				}
			}
		}
		return result;
	}

	static class BoardChar
	{
		Character character;
		int row;
		int col;
		BoardChar up;
		BoardChar down;
		BoardChar left;
		BoardChar right;

		public BoardChar(char[][] board, int row, int col, Map<String, BoardChar> map)
		{
			map.put(row + "," + col, this);
			this.character = board[row][col];
			this.row = row;
			this.col = col;

			if (row != 0)
			{
				if (map.get((row - 1) + "," + col) == null)
					map.put((row - 1) + "," + col, new BoardChar(board, row - 1, col, map));
				this.up = map.get((row - 1) + "," + col);
			}

			if (row != board.length - 1)
			{
				if (map.get((row + 1) + "," + col) == null)
					map.put((row + 1) + "," + col, new BoardChar(board, row + 1, col, map));
				this.down = map.computeIfAbsent((row + 1) + "," + col, key -> new BoardChar(board, row + 1, col, map));
			}

			if (col != 0)
			{
				if (map.get(row + "," + (col - 1)) == null)
					map.put(row + "," + (col - 1), new BoardChar(board, row, col - 1, map));
				this.left = map.get(row + "," + (col - 1));
			}

			if (col != board[0].length - 1)
			{
				if (map.get(row + "," + (col + 1)) == null)
					map.put(row + "," + (col + 1), new BoardChar(board, row, col + 1, map));
				this.right = map.get(row + "," + (col + 1));
			}
		}

		public boolean search(String word, int index)
		{
			if (word.length() - 1 == index)
				return word.charAt(index) == character;

			if (word.charAt(index) == character)
			{
				Character temp = character;
				character = '/';
				boolean isFound = (up != null && up.search(word, index + 1))
					                  || (down != null && down.search(word, index + 1))
					                  || (left != null && left.search(word, index + 1))
					                  || (right != null && right.search(word, index + 1));
				character = temp;
				return isFound;
			}

			return false;
		}
	}
}
