package arrayAndHashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EncodeDecodeStrings
{
	static void main()
	{
		List<String> strs = new ArrayList<>();
//		strs.add("@#$");
//		strs.add("%^&*");
//		strs.add("!@#$%^&*");
		strs.add("");
		strs.add("");
//		strs.add("some String");
//		strs.add("another str#$#ing");
		String encodedString = encode(strs);
		System.out.println(encodedString);
		List<String> decode = decode1(encodedString);
		System.out.println(decode);
		System.out.println("IS BOTH LISTS SAME: " + strs.equals(decode));
	}

	private static final String DELIMETER = "#$#";

	private static String encode(List<String> strs)
	{
		StringBuilder sb = new StringBuilder();
		for (String key : strs)
		{
			int len = key.length();
			sb.append(DELIMETER).append(len).append(DELIMETER).append(key);
		}
		return sb.toString();
	}

	private static List<String> decode(String str)
	{
		List<String> result = new ArrayList<>();
		int length = -1;
		int currentCharater = 0;
		while(currentCharater < str.length())
		{
			String subString = str.substring(currentCharater);

			if (length == -1)
			{
				subString = subString.substring(DELIMETER.length());
				currentCharater = currentCharater + DELIMETER.length();
				boolean lengthNotFound = true;
				StringBuilder stringBuilder = new StringBuilder();
				while(lengthNotFound)
				{
					if(str.substring(currentCharater, currentCharater + DELIMETER.length()).equals(DELIMETER))
					{
						lengthNotFound = false;
						currentCharater = currentCharater + DELIMETER.length();
					}
					else
					{
						stringBuilder.append(subString.substring(stringBuilder.length(), stringBuilder.length() + 1));
						currentCharater++;
					}
				}
				length = Integer.parseInt(stringBuilder.toString());
				if (length == 0)
					result.add("");
			}
			else
			{
				String element = subString.substring(0, length);
				if (length > 0)
					result.add(element);
				currentCharater = currentCharater + length;
				length = -1;
			}
		}
		return result;
	}

	public static List<String> decode1(String str)
	{
		List<String> res = new ArrayList<>();
		int i = 0;
		while (i < str.length()) {
			int j = i + DELIMETER.length();
			while (str.charAt(j) != DELIMETER.charAt(0)) {
				j++;
			}
			i = i + DELIMETER.length();
			int length = Integer.parseInt(str.substring(i, j));
			i = j + DELIMETER.length();
			j = i + length;
			res.add(str.substring(i, j));
			i = j;
		}
		return res;
	}
}
