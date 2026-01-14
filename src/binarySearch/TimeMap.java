package binarySearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeMap
{
	Map<String, List<Data>> map;
	public TimeMap() {
		map = new HashMap<>();
	}

	public void set(String key, String value, int timestamp) {
		map.computeIfAbsent(key, k -> new ArrayList<>());
		map.get(key).add(new Data(value, timestamp));
	}

	public String get(String key, int timestamp) {
		List<Data> data = map.get(key);
		String result = "";
		if (data != null)
		{
			int l = 0;
			int r = data.size() - 1;

			while (l <= r)
			{
				int mid = (r + l) / 2;
				if (data.get(mid).getTimeStamp() == timestamp)
				{
					return data.get(mid).getMood();
				}
				else if (data.get(mid).getTimeStamp() > timestamp)
					r = mid - 1;
				else
				{
					result = data.get(mid).getMood();
					l = mid + 1;
				}
			}
		}
		return result;
	}

	public class Data
	{
		private String mood;
		private int timeStamp;

		public Data(String mood, int timeStamp)
		{
			this.mood = mood;
			this.timeStamp = timeStamp;
		}

		public String getMood()
		{
			return mood;
		}

		public int getTimeStamp()
		{
			return timeStamp;
		}
	}
}
