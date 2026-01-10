package slidingWindow;

public class MinimumWindowSubstring
{
	static void main()
	{
//		String s = "ADOBECODEBANC";
//		String t = "ABC";
		String s = "OUZODYXAZV";
		String t = "XYZ";
		System.out.println(minWindow(s, t));
	}

	public static String minWindow(String s, String t) {
		if (t.length() > s.length())
			return "";

		String result = "";
		int[] tChars = new int[128];
		int[] sChars = new int[128];
		int matches = 0;

		for (int i = 0; i < t.length(); i++)
		{
			tChars[t.charAt(i) - ' ']++;
		}
		for (int i = 0; i < t.length(); i++)
		{
			if (tChars[s.charAt(i) - ' '] > 0)
				sChars[s.charAt(i) - ' ']++;
		}
		for (int i = 0; i < tChars.length; i++)
		{
			if (tChars[i] <= sChars[i])
				matches++;
		}

		if (matches == tChars.length)
			return s.substring(0, t.length());
		else if (s.length() == t.length())
			return "";

		int l = 0, r = t.length() - 1;

		while (l < s.length())
		{
			while (tChars[s.charAt(l) - ' '] == 0 && l < r)
			{
				l++;
			}

			if (tChars[s.charAt(r) - ' '] > 0)
			{
				if (matches == tChars.length)
				{
					if (result.equals(""))
						result = s;
					result = result.length() > (r - l + 1) ? s.substring(l, r + 1) : result;
					if (tChars[s.charAt(l) - ' '] == sChars[s.charAt(l) - ' '])
						matches--;
					sChars[s.charAt(l) - ' ']--;
					l++;
				}
				else
				{
					r++;
					if (r == s.length())
						return result;
					if (tChars[s.charAt(r) - ' '] == sChars[s.charAt(r) - ' '] + 1)
						matches++;
					if (tChars[s.charAt(r) - ' '] > 0)
						sChars[s.charAt(r) - ' ']++;
				}
			}
			else
			{
				r++;
				if (r == s.length())
					return result;
				if (tChars[s.charAt(r) - ' '] > 0)
				{
					if (tChars[s.charAt(r) - ' '] == sChars[s.charAt(r) - ' '] + 1)
						matches++;
					sChars[s.charAt(r) - ' ']++;
				}
			}
		}

		return result;
	}
}
