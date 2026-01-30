package linkedList;

import java.util.LinkedHashMap;

public class LRUCache
{
	LinkedHashMap<Integer, Integer> map;
	int capacity;

	public LRUCache(int capacity)
	{
		this.capacity = capacity;
		map = new LinkedHashMap<>();
	}

	public int get(int key)
	{
		Integer value = map.remove(key);
		if (value != null)
			this.put(key, value);
		else
			return -1;
		return value;
	}

	public void put(int key, int value)
	{
		if (map.size() == capacity && !map.containsKey(key))
			map.remove(map.lastEntry().getKey());
		map.putFirst(key, value);
	}

	static void main()
	{
		LRUCache lruCache = new LRUCache(2);
		lruCache.put(1, 20);
		lruCache.put(2, 40);
		System.out.println(lruCache.get(2));
		System.out.println(lruCache.get(1));
		lruCache.put(3, 60);
		System.out.println(lruCache.get(1));
		lruCache.put(4, 80);
		System.out.println(lruCache.get(3));
		System.out.println(lruCache.get(4));
	}
}
