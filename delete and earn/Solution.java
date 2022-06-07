//Time compledxity: O(n + M - m)
//Space complexity:O(n)

public int deleteAndEarn(int[] nums) {
	var numToCount = new HashMap<Integer, Integer>();
	var min = Integer.MAX_VALUE;
	var max = Integer.MIN_VALUE;
	for (var num : nums) {
		numToCount.compute(num, (k, v) -> v == null ? 1 : ++v);
		min = Math.min(min, num);
		max = Math.max(max, num);
	}

	var prevIncEarn = 0;
	var prevExcEarn = 0;
	for (var i = min; i <= max; i++) {
		var incEarn = prevExcEarn + i * numToCount.getOrDefault(i, 0);
		var excEarn = Math.max(prevIncEarn, prevExcEarn);
		prevIncEarn = incEarn;
		prevExcEarn = excEarn;
	}
	return Math.max(prevIncEarn, prevExcEarn);
}
