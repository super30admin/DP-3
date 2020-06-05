
// Time Complexity : O(N)(Not sure)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
import java.util.Arrays;

public class Delete_Earn {
	public static int deleteAndEarn(int[] nums) {
		// Edge case is handled
		if (nums.length == 0) {
			return 0;
		}
		// Max number in array is found
		int max = 0;
		for (int num : nums) {
			max = Math.max(max, num);
		}
		/*
		 * We assign a dp array of length equal to max + 1, and fill in the dp array by
		 * calculating the total sum of each number in nums array
		 */
		int dp[] = new int[max + 1];
		for (int num : nums) {
			dp[num] = dp[num] + num;
		}
		/*
		 * We calculate the max amount that can be earned and in the end , the element
		 * at first index would contain the max amount earned
		 */
		dp[dp.length - 2] = Math.max(dp[dp.length - 1], dp[dp.length - 2]);
		for (int i = dp.length - 3; i >= 1; i--) {
			dp[i] = Math.max(dp[i + 1], dp[i] + dp[i + 2]);
		}
		return dp[1];
	}

	public static void main(String[] args) {
		int nums[] = { 2, 2, 3, 3, 3, 4 };
		int result = deleteAndEarn(nums);
		System.out.println(Arrays.toString(nums));
		System.out.println("Result: " + result);
	}
}