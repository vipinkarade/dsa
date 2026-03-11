package oneDDP;

public class DecodeWays
{
	static void main()
	{
		String s = "12";
		System.out.println(numDecodings(s));
	}

	private static int numDecodings(String s)
	{
		int[] nums = new int[s.length()];
		for (int i = 0; i < nums.length; i++)
			nums[i] = -1;
		return getNumDecodings(s, 0, nums);
	}

	private static int getNumDecodings(String s, int index, int[] nums)
	{
		if (index == s.length())
			return 1;
		if (nums[index] != -1)
			return nums[index];
		if (s.charAt(index) == '0')
			return 0;
		if (index == s.length() - 1)
			return 1;

		nums[index + 1] = getNumDecodings(s, index  + 1, nums);
		if (s.charAt(index) - '0' == 1 || (s.charAt(index) - '0' == 2 && s.charAt(index + 1) - '0' < 7))
		{
			int numDecodings = getNumDecodings(s, index + 2, nums);
			if (numDecodings == 1)
				return nums[index + 1] + 1;
			nums[index + 2] = numDecodings;
			return nums[index + 1] + nums[index + 2];
		}
		else
			return nums[index + 1];
	}
}
