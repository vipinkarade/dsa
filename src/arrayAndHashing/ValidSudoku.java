package arrayAndHashing;

public class ValidSudoku
{
	static void main()
	{
		char[][] board = {{'1','2','.','.','3','.','.','.','.'},
			{'4','.','.','5','.','.','.','.','.'},
			{'.','9','8','.','.','.','.','.','3'},
			{'5','.','.','.','6','.','.','.','4'},
			{'.','.','.','8','.','3','.','.','5'},
			{'7','.','.','.','2','.','.','.','6'},
			{'.','.','.','.','.','.','2','.','.'},
			{'.','.','.','4','1','9','.','.','8'},
			{'.','.','.','.','8','.','.','7','9'}};

//		char[][] board = {{'1','2','.','.','3','.','.','.','.'},
//			{'4','.','.','5','.','.','.','.','.'},
//			{'.','9','1','.','.','.','.','.','3'},
//			{'5','.','.','.','6','.','.','.','4'},
//			{'.','.','.','8','.','3','.','.','5'},
//			{'7','.','.','.','2','.','.','.','6'},
//			{'.','.','.','.','.','.','2','.','.'},
//			{'.','.','.','4','1','9','.','.','8'},
//			{'.','.','.','.','8','.','.','7','9'}};
		System.out.println(isValidSudoku1(board));
		
	}

	/*
	 * Brute Force
	 */
	private static boolean isValidSudoku(char[][] board)
	{
		int sizeOfBoard = board.length;
		int sizeOfBlock = (int) (Math.sqrt(sizeOfBoard));
		for (int i = 0; i < sizeOfBoard; i++)
		{
			if (!isValidRow(board[i], sizeOfBoard) || !isValidColumn(board, sizeOfBoard, i) || !isValidBlock(board, sizeOfBlock, i))
				return false;
		}
		return true;
	}

	private static boolean isValidBlock(char[][] board, int sizeOfBlock, int block)
	{
		boolean[] elements = new boolean[sizeOfBlock * sizeOfBlock];
		int rowStart = (block / sizeOfBlock) * sizeOfBlock;
		int columnStart = (block % sizeOfBlock) * sizeOfBlock;
		for (int i = rowStart; i < rowStart + sizeOfBlock; i++ )
		{
			for (int j = columnStart; j < columnStart + sizeOfBlock; j++)
			{
				if (Character.isDigit(board[i][j]))
				{
					int numericValue = board[i][j] - '1';
					if (elements[numericValue])
						return false;
					elements[numericValue] = true;
				}
			}
		}
		return true;
	}

	private static boolean isValidRow(char[] row, int sizeOfBoard)
	{
		boolean[] elements = new boolean[sizeOfBoard];
		for (int i = 0; i < sizeOfBoard; i++)
		{
			if (Character.isDigit(row[i]))
			{
				int numericValue = row[i] - '1';
				if (elements[numericValue])
					return false;
				elements[numericValue] = true;
			}
		}
		return true;
	}

	private static boolean isValidColumn(char[][] board, int sizeOfBoard, int column)
	{
		boolean[] elements = new boolean[sizeOfBoard];
		for (int i = 0; i < sizeOfBoard; i++)
		{
			if (Character.isDigit(board[i][column]))
			{
				int numericValue = board[i][column] - '1';
				if (elements[numericValue])
					return false;
				elements[numericValue] = true;
			}
		}
		return true;
	}


	private static boolean isValidSudoku1(char[][] board)
	{
		int sizeOfBoard = board.length;
		int sizeOfBlock = (int) Math.sqrt(sizeOfBoard);

		int[] columns = new int[sizeOfBoard];
		int[] rows = new int[sizeOfBoard];
		int[] blocks = new int[sizeOfBoard];

		// traversing through rows
		for (int i = 0; i < sizeOfBoard; i++)
		{
			// traversing through columns
			for (int j = 0; j < sizeOfBoard; j++)
			{
				if (!Character.isDigit(board[i][j]))
					continue;

				int elememt = board[i][j] - '1';
				int elementBit = 1 << elememt;

				int blockNumber = (j / sizeOfBlock) + (i / sizeOfBlock) * sizeOfBlock;

				if ((rows[i] & elementBit) > 0 || (columns[j] & elementBit) > 0 || (blocks[blockNumber] & elementBit) > 0)
					return false;

				rows[i] |= elementBit;
				columns[j] |= elementBit;
				blocks[blockNumber] |= elementBit;
			}
		}

		return true;
	}
}
