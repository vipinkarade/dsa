package twoPointers;

import java.util.ArrayList;
import java.util.List;

public class ValidPalindrome
{
	static void main()
	{
//		String s = "Was it a car or a cat I saw?";
		String s = "tab a cat";
		System.out.println(isPalindrome(s));
	}

	private static boolean isPalindrome(String s)
	{
		s = s.toLowerCase();
		int frontPointer = 0;
		int backPointer = s.length() - 1;
		while (frontPointer < backPointer)
		{
			if (s.charAt(frontPointer) == s.charAt(backPointer))
			{
				frontPointer++;
				backPointer--;
			}
			else
			{

				if (!Character.isLetterOrDigit(s.charAt(frontPointer)))
				{
					frontPointer++;
					continue;
				}

				if (!Character.isLetterOrDigit(s.charAt(backPointer)))
				{
					backPointer--;
					continue;
				}

				if (s.charAt(frontPointer) != s.charAt(backPointer))
					return false;
			}
		}
		return true;
	}
}
