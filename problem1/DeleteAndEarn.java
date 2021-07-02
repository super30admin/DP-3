// Time Complexity : O(m), m -> Max of nums.length and max value in nums
// Space Complexity : O(m) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
package problem1;

public class DeleteAndEarn {
	public int deleteAndEarn(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		int max = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > max) {
				max = nums[i];
			}
		}

		int[] dp = new int[max + 1];
		for (int i = 0; i < nums.length; i++) {
			dp[nums[i]] += nums[i];
		}

		for (int i = 2; i < dp.length; i++) {
			dp[i] = Math.max(dp[i - 1], dp[i - 2] + dp[i]);
		}
		return dp[max];
	}

	public static void main(String[] args) {
		DeleteAndEarn obj = new DeleteAndEarn();
		int[] nums = { 1, 2, 3, 1, 2, 2, 3, 4 };
		System.out.println("Maximum points we can earn=" + obj.deleteAndEarn(nums));
	}

}
