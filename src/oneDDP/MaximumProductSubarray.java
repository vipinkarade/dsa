package oneDDP;

public class MaximumProductSubarray
{
	static void main()
	{

	}

	private static int maxProduct(int[] nums)
	{
		int result = Integer.MIN_VALUE;
		int product = 1;
		int prodTillLastNeg = 0;
		for (int num : nums)
		{
			if (product == 0)
			{
				product = 1;
				prodTillLastNeg = 0;
			}
			product *= num;

			result = Math.max(result, product);
			if (prodTillLastNeg < 0)
				result = Math.max(result, product / prodTillLastNeg);
			if (num < 0 && prodTillLastNeg == 0)
				prodTillLastNeg = product;
		}
		return result;
	}
}
