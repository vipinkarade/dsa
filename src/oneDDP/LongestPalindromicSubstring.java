package oneDDP;

public class LongestPalindromicSubstring
{
	static void main()
	{
		String s = "abbc";
		System.out.println(longestPalindrome(s));
	}

	private static String longestPalindrome(String s)
	{
		int start = -1, length = 0;

		for (int i = 0; i < s.length(); i++)
		{
			int l = i, r = i;
			while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r))
			{
				if (r - l + 1 > length)
				{
					length = r - l + 1;
					start = l;
				}
				l--;
				r++;
			}

			l = i;
			r = i + 1;
			while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r))
			{
				if (r - l + 1 > length)
				{
					length = r - l + 1;
					start = l;
				}
				l--;
				r++;
			}
		}

		return s.substring(start, start + length);
	}
}
