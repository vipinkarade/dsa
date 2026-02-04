package heapAndPriorityQueue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Twitter
{
	private final Map<Integer, HashSet<Integer>> followingMap;
	private final PriorityQueue<int[]> tweets;
	private int counter = 0;

	public Twitter()
	{
		followingMap = new HashMap<>();
		// compare first index, if they are the same then compare the second index
		tweets = new PriorityQueue<>(Comparator.comparingInt((int[] a) -> a[0]).thenComparingInt(a -> a[1]));
	}

	public void postTweet(int userId, int tweetId)
	{
		followingMap.computeIfAbsent(userId, key -> {
			HashSet<Integer> result = new HashSet<>();
			result.add(key);
			return result;
		});
		tweets.add(new int[]{userId, tweetId, counter++});
	}

	public List<Integer> getNewsFeed(int userId)
	{
		Iterator<int[]> iterator = tweets.stream().parallel().iterator();
		PriorityQueue<int[]> feed = new PriorityQueue<>(Comparator.comparingInt(a -> -a[2]));
		while (iterator.hasNext())
		{
			int[] tweet = iterator.next();
			if (followingMap.get(userId).contains(tweet[0]))
				feed.add(tweet);
		}
		List<Integer> result = new ArrayList<>();
		int count = 0;
		while (!feed.isEmpty() && count < 10)
		{
			result.add(feed.poll()[1]);
			count++;
		}
		return result;
	}

	public void follow(int followerId, int followeeId)
	{
		followingMap.computeIfAbsent(followerId, key -> {
			HashSet<Integer> result = new HashSet<>();
			result.add(key);
			return result;
		}).add(followeeId);
	}

	public void unfollow(int followerId, int followeeId)
	{
		if (followerId != followeeId)
		{
			followingMap.computeIfAbsent(followerId, key -> {
				HashSet<Integer> result = new HashSet<>();
				result.add(key);
				return result;
			}).remove(followeeId);
		}
	}

	static void main()
	{

	}
}
