package s30;

import java.util.HashMap;

public class DeleteAndEarn {
	public static void main(String[] args) {
		int[] arr = {2, 2, 3, 3, 3, 4};
		System.out.println(getMaxPoints(arr));
	}
	
	public static int getMaxPoints(int[] arr) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i=0; i<arr.length; i++) {
			map.put(arr[i], map.getOrDefault(arr[i],0) + 1);
		}
		return helper(map);
	}
	
	public static int helper(HashMap<Integer, Integer> map) {
		int maxPoints = Integer.MIN_VALUE;
		for(int key: map.keySet()) {
			if(map.get(key) == 0)
				continue;
			
			map.put(key, map.get(key)-1);
			int key1 = key+1;
			int key2 = key-1;
			
			int val1 = map.getOrDefault(key1, 0);
			int val2 = map.getOrDefault(key2, 0);
			if(map.containsKey(key1))
				map.put(key1 , 0);
			if(map.containsKey(key2))
				map.put(key2, 0);
			
			int points = key + helper(map);
			maxPoints = (points > maxPoints) ? points : maxPoints;
			
			map.put(key, map.get(key)+1);
			if(map.containsKey(key1))
				map.put(key1 , val1);
			if(map.containsKey(key2))
				map.put(key2, val2);
		}
		
		return maxPoints == Integer.MIN_VALUE ? 0 : maxPoints;
	}
}
