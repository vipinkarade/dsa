package slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWithoutRepeatingCharacters
{
	static void main()
	{
//		String str = "abcabcbb";
		String str = "abba";
//		String str = "qweqweasdqwe";
//		String str = "nopqrstuvwxyzabcdefghijklmNOPQRSTUVWXYZABCDEFGHIJKLMnopqrstuvwxyzabcdefghijklmNOPQRSTUVWXYZABCDEFGHIJKLM";
		System.out.println(longestSubstringNonOptimal(str));
	}

	private static int longestSubstring(String s)
	{
		int result = 0;

		if (s.length() < 2)
			return s.length();

		int l = 0;
		int r = 1;
		long currentStrBit = 1L << (s.charAt(0) - ' ');

		while(r < s.length())
		{
			long bitAtR = 1L << (s.charAt(r) - ' ');
			if ((currentStrBit & bitAtR) > 0)
			{
				String subString = s.substring(l, r);
				if (subString.length() > result)
					result = subString.length();
				while (l < r)
				{
					currentStrBit = currentStrBit - (1L << (s.charAt(l) - ' '));
					l++;
					if ((currentStrBit & bitAtR) == 0)
						break;
				}
				currentStrBit |= bitAtR;
			}
			else if (r == s.length() - 1)
			{
				String subString = s.substring(l, r + 1);
				if (subString.length() > result)
					result = subString.length();
			}
			else
			{
				currentStrBit |= bitAtR;
			}

			r++;
		}
		return result;
	}

	private static int longestSubstringNonOptimal(String s)
	{
		Map<Integer, Integer> map = new HashMap<>();
		int l = 0;
		int result = 0;

		for (int r = 0; r < s.length(); r++)
		{
			Integer index = map.get(s.charAt(r) - ' ');
			if (index != null)
			{
				l = Math.max(index + 1, l);
			}
			map.put(s.charAt(r) - ' ', r);
			result = Math.max((r - l + 1), result);
		}

		return result;
	}
}
