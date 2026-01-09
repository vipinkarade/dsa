package slidingWindow;

public class PermutationString
{
	static void main()
	{
		String s1 = "asd";
		String s2 = "qdsav";
		System.out.println(checkInclusion(s1, s2));
	}

	private static boolean checkInclusion(String s1, String s2)
	{
		int[] s1Chars = new int[26];
		for (int i = 0; i < s1.length(); i++)
		{
			s1Chars[s1.charAt(i) - 'a']++;
		}

		for (int i = 0; i <= s2.length() - s1.length(); i++)
		{
			if (s1Chars[s2.charAt(i) - 'a'] > 0)
			{
				int[] s2Chars = new int[26];
				for (int j = i; j < i + s1.length(); j++)
				{
					s2Chars[s2.charAt(j) - 'a']++;
				}

				boolean arraysDifferent = false;
				for (int j = 0; j < 26; j++)
				{
					if (s2Chars[j] != s1Chars[j])
					{
						arraysDifferent = true;
						break;
					}
				}

				if (!arraysDifferent)
					return true;
			}
		}
		return false;
	}
}
