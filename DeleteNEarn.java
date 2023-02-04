// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

public class DeleteNEarn {
	public int deleteAndEarn(int[] nums) {
		int max = Integer.MIN_VALUE;
		for (int num : nums)
			max = Math.max(max, num);

		int[] dp = new int[max + 1];
		for (int num : nums) {
			dp[num] += num;
		}
		int prev = 0;
		int curr = dp[1];
		for (int i = 2; i < dp.length; i++) {
			int temp = curr;
			curr = Math.max(curr, dp[i] + prev);
			prev = temp;
		}
		return curr;
	}
}
