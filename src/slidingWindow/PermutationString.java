package slidingWindow;

public class PermutationString
{
	static void main()
	{
		String s1 = "absd";
		String s2 = "qdsav";
		System.out.println(checkInclusion1(s1, s2));
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

	private static boolean checkInclusion1(String s1, String s2)
	{
		if (s1.length() > s2.length())
			return false;

		int[] s1Chars = new int[26];
		int[] s2Chars = new int[26];

		for (int i = 0; i < s1.length(); i++)
		{
			s1Chars[s1.charAt(i) - 'a']++;
			s2Chars[s2.charAt(i) - 'a']++;
		}

		int matches = 0;

		for (int i = 0; i< 26; i++)
		{
			if (s1Chars[i] == s2Chars[i])
				matches++;
		}

		if (matches == 26)
			return true;

		int l = 0;
		for (int i = s1.length(); i < s2.length(); i++)
		{
			int charAtL = s2.charAt(l) - 'a';

			if (s1Chars[charAtL] == s2Chars[charAtL])
				matches--;
			else if (s2Chars[charAtL] - 1 == s1Chars[charAtL])
				matches++;
			s2Chars[charAtL]--;
			l++;

			int charAtR = s2.charAt(i) - 'a';
			if (s1Chars[charAtR] == s2Chars[charAtR])
				matches--;
			else if (s2Chars[charAtR] + 1 == s1Chars[charAtR])
				matches++;
			s2Chars[charAtR]++;

			if (matches == 26)
				return true;
		}
		return false;
	}
}
