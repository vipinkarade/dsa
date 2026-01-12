package binarySearch;

public class Search2DMatrix
{
	static void main()
	{
//		int[][] matrix  = {{1,2,4,8},{10,11,12,13},{14,20,30,40}};
		int[][] matrix  = {{1}};
		int targer = 10;
		System.out.println(searchMatrix(matrix, targer));
	}

	private static boolean searchMatrix(int[][] matrix, int target)
	{
		int height = matrix.length;
		int width = matrix[0].length;
		int startHeight = 0;
		int startWidth = 0;
		int endHeight = height - 1;
		int endWidth = width - 1;

		while (!(startHeight == endHeight && startWidth > endWidth))
		{
			int halfTotalElements = (((endHeight - startHeight - 1) * width) + (width - startWidth) + (endWidth + 1)) / 2;
			int midHeight = startHeight + halfTotalElements / width + (startWidth + halfTotalElements % width) / width;
			int midWidth = (startWidth + halfTotalElements % width) % width;

			if (matrix[midHeight][midWidth] == target)
				return true;
			else if (startWidth == endWidth && startHeight == endHeight)
				return false;
			else if (matrix[midHeight][midWidth] > target)
			{
				endWidth = midWidth == 0 ? width - 1 : midWidth - 1;
				endHeight = midWidth == 0 ? midHeight - 1 : midHeight;
			}
			else if (matrix[midHeight][midWidth] < target)
			{
				startWidth = (midWidth == width - 1 && midHeight < height - 1) ? 0 : midWidth + 1;
				startHeight = (midWidth == width - 1 && midHeight < height - 1) ? midHeight + 1 : midHeight;
			}
		}

		return false;
	}
}
