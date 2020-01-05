// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class DeleteAndEarn {
	public int deleteAndEarn(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
			if (max < nums[i])
				max = nums[i];
		}
		int[] values = new int[max + 1];
		for (Integer num : nums)
			values[num] += num;

		int skip = 0, take = 0;
		for (int i = 0; i < values.length; i++) {
			int curr_skip = Math.max(skip, take);
			int curr_take = skip + values[i];
			skip = curr_skip;
			take = curr_take;
		}
		return Math.max(skip, take);
	}
}