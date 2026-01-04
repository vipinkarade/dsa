package arrayAndHashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GroupAnagrams
{
	static void main()
	{
		String[] strs = {"act","pots","tops","cat","stop","hat"};
		System.out.println(groupAnagrams2(strs));
	}

	private static List<List<String>> groupAnagrams(String[] strs)
	{
		List<List<String>> result = new ArrayList<>();
		Set<Integer> addedInList = new HashSet<>();

		for (int i = 0; i < strs.length; i++)
		{
			if (addedInList.contains(i))
				continue;

			String firstString = strs[i];
			List<String> subSetResult = new ArrayList<>();
			subSetResult.add(firstString);
			addedInList.add(i);
			for (int j = i + 1; j < strs.length; j++)
			{
				if (addedInList.contains(j))
					continue;
				String secondString = strs[j];
				if (isAnagram(firstString, secondString))
				{
					subSetResult.add(secondString);
					addedInList.add(j);
				}
			}
			result.add(subSetResult);
		}

		return result;
	}

	private static boolean isAnagram(String s, String t)
	{
		if (s.length() != t.length())
			return false;

		int[] alphabets = new int[26];
		for (int i = 0; i < s.length(); i++)
		{
			alphabets[s.charAt(i) - 'a']++;
			alphabets[t.charAt(i) - 'a']--;
		}

		for (int i = 0; i < alphabets.length; i++)
		{
			if (alphabets[i] != 0)
				return false;
		}

		return true;
	}

	/*
	* Not the optimal solution but to check for the set of anagrams, they sort all strings and compare it they are equal.
	* */
	public static List<List<String>> groupAnagrams1(String[] strs)
	{
		Map<String, List<String>> res = new HashMap<>();
		for (String s : strs) {
			char[] charArray = s.toCharArray();
			Arrays.sort(charArray);
			String sortedS = new String(charArray);
			res.putIfAbsent(sortedS, new ArrayList<>());
			res.get(sortedS).add(s);
		}
		return new ArrayList<>(res.values());
	}

	/*
	* The most optimal solution
	* */
	public static List<List<String>> groupAnagrams2(String[] strs)
	{
		Map<String, List<String>> res = new HashMap<>();
		for (String s : strs) {
			int[] count = new int[26];
			for (char c : s.toCharArray()) {
				count[c - 'a']++;
			}
			String key = Arrays.toString(count);
			res.putIfAbsent(key, new ArrayList<>());
			res.get(key).add(s);
		}
		return new ArrayList<>(res.values());
	}
}
