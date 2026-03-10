package oneDDP;

public class PalindromicSubstrings
{
	static void main()
	{

	}

	private static int countSubstrings(String s)
	{
		int result = 0;
		for(int i = 0; i < s.length(); i++)
		{
			int l = i, r = i + 1;
			while(l >=0 && r < s.length() && s.charAt(l) == s.charAt(r))
			{
				result++;
				l--;
				r++;
			}

			l = i;
			r = i;
			while(l >=0 && r < s.length() && s.charAt(l) == s.charAt(r))
			{
				result++;
				l--;
				r++;
			}
		}
		return result;
	}
}
