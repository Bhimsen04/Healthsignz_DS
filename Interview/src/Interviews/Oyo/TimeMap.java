package Interviews.Oyo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeMap {

	// https://leetcode.com/problems/time-based-key-value-store/
	public Map<String, List<Time>> map;

	public TimeMap() {
		map = new HashMap<String, List<Time>>();
	}

	public void set(String key, String value, int timestamp) {
		if (!map.containsKey(key))
			map.put(key, new ArrayList<Time>());
		map.get(key).add(new Time(timestamp, value));
	}

	public String get(String key, int timestamp) {
		if (!map.containsKey(key))
			return "";
		List<Time> list = map.get(key);
		int l = 0, h = list.size() - 1;
		while (l <= h) {
			int m = (l + h) / 2;
			if (list.get(m).time == timestamp)
				return list.get(m).value;
			else if (list.get(m).time > timestamp)
				h = m - 1;
			else
				l = m + 1;
		}
		if (l < 0)
			return "";
		return list.get(l - 1).value;
	}

	class Time {

		public int time;
		public String value;

		public Time(int time, String value) {
			super();
			this.time = time;
			this.value = value;
		}

		@Override
		public String toString() {
			return "Employee [time=" + time + ", value=" + value + "]";
		}

	}
}
