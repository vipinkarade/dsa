package arrayAndHashing;

import java.util.Arrays;

public class ProductOfArrayExceptSelf
{
	static void main()
	{
//		int[] nums = {1,2,4,6};
		int[] nums = {-1,0,1,2,3};
		System.out.println(Arrays.toString(productExceptSelf1(nums)));
	}

	private static int[] productExceptSelf(int[] nums)
	{
		int totalProduct = 1;
		boolean hasAtleastOneZero = false;
		Boolean hasMultipleZero = null;
		for (int key : nums)
		{
			if (key == 0)
			{
				hasAtleastOneZero = true;
				if (hasMultipleZero == null)
					hasMultipleZero = false;
				else
					return new int[nums.length];
			}
			else
			{
				totalProduct = totalProduct * key;
			}
		}

		int[] output = new int[nums.length];
		int index = -1;
		for (int key : nums)
		{
			index++;
			if (hasAtleastOneZero && key != 0)
				output[index] = 0;
			else
				output[index] = key == 0 ? totalProduct : totalProduct/key;
		}
		return output;
	}

	private static int[] productExceptSelf1(int[] nums)
	{
		int[] result = new int[nums.length];

		result[0] = 1;

		for (int i = 1; i < nums.length; i++)
		{
			result[i] = result[i - 1] * nums[i - 1];
		}

		int rightMultiplier = nums[nums.length - 1];
		for (int i = nums.length - 2; i >= 0; i--)
		{
			result[i] = result[i] * rightMultiplier;
			rightMultiplier = rightMultiplier * nums[i];
		}

		return result;
	}
}
