// Time Complexity O(N)
// Space Complexity O(N)
// Runs on LeetCode YES

import java.util.Arrays;

public class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {

        int maxValue = 0;

        for (int i = 0; i <= nums.length - 1; i++) {
            maxValue = Math.max(maxValue, nums[i]);
        }

        int[] houseRobber = new int[maxValue + 1];
        Arrays.fill(houseRobber, 0);

        for (int i = 0; i < nums.length; i++) {
            houseRobber[nums[i]] = houseRobber[nums[i]] + nums[i];
        }

        int[] dp = new int[houseRobber.length];

        dp[0] = houseRobber[0];
        dp[1] = Math.max(dp[0], houseRobber[1]);

        for (int i = 2; i < houseRobber.length; i++) {
            int choose = houseRobber[i] + dp[i - 2];
            int skip = dp[i - 1];
            dp[i] = Math.max(choose, skip);
        }

        return dp[houseRobber.length - 1];

    }
}