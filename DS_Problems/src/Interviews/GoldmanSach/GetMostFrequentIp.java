package Interviews.GoldmanSach;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GetMostFrequentIp {
	public static void main(String[] args) {
		System.out.println("Most Frequent IP!");

		getMostFrequentIp(new String[] { 
				"10.0.0.1 - GET 2020-08-24", 
				"10.0.0.1 - GET 2020-08-24",
				"10.0.0.2 - GET 2020-08-20",
				"10.0.0.3 - GET 2020-08-24",
				"10.0.0.3 - GET 2020-08-24",
				"10.0.0.4 - GET 2020-08-24",
				"10.0.0.4 - GET 2020-08-24", });
	}

	public static void getMostFrequentIp(String[] logs) {
		HashMap<String, Integer> map = new HashMap<>();
		int freq = 0;
		for (String log : logs) {
			String[] arr = log.split(" ");
			map.put(arr[0], map.getOrDefault(arr[0], 0) + 1);
			freq = Math.max(freq, map.get(arr[0]));
		}

		List<String> mostFrequent = new ArrayList<>();

		for (String ip : map.keySet())
			if (map.get(ip) == freq)
				mostFrequent.add(ip);

		System.out.println(mostFrequent);
	}
}
