package slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement
{
	static void main()
	{
		String s = "XXYYYYZXZZZOZZZYYYYYY";
		int k = 2;
		System.out.println(characterReplacement1(s, k));
	}

	private static int characterReplacement(String s, int k)
	{
		Map<Integer, Integer> charToCount = new HashMap<>();
		for (int i = 0; i < s.length(); i ++)
			charToCount.put(getChar(s, i), charToCount.getOrDefault(getChar(s, i), 0) + 1);

		int result = 0;

		for (int i = 0; i < s.length(); i++)
		{
			int currChar = getChar(s, i);
			int maxPossibleCount = charToCount.get(currChar) + k;
			if (maxPossibleCount > result)
			{
				int replacements = 0;
				int size = 1;
				for (int j = i + 1; j < i + 1 + maxPossibleCount; j++)
				{
					if (j >= s.length())
					{
						size = size + k - replacements;
						break;
					}

					if (getChar(s, j) != currChar)
						replacements++;

					if (replacements > k)
						break;

					size++;
				}

				result = Math.max(result, size);
			}

			charToCount.put(currChar, charToCount.get(currChar) - 1);
		}

		return Math.min(result, s.length());
	}

	private static int getChar(String s, int pos)
	{
		return s.charAt(pos) - ' ';
	}

	private static int characterReplacement1(String s, int k)
	{
		int result = 0;
		Map<Character, Integer> charToCount = new HashMap<>();

		int l = 0, maxFreq = 0;

		for (int r = 0; r < s.length(); r++)
		{
			charToCount.put(s.charAt(r), charToCount.getOrDefault(s.charAt(r), 0) + 1);
			maxFreq = Math.max(maxFreq, charToCount.get(s.charAt(r)));

			if (r - l + 1 > maxFreq + k)
			{
				charToCount.put(s.charAt(l), charToCount.get(s.charAt(l)) - 1);
				l++;
			}

			result = Math.max(result, r - l + 1);
		}

		return result;
	}
}
