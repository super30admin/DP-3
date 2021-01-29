// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : First tried doing with SortedMap but space and time complexity was too much.

// Your code here along with comments explaining your approach
public class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {

        int[] dp = new int[10001];

        // Calculating Sum for a particular Integer value
        for (int num : nums) {
            dp[num] += num;
        }

        // Taking Max value based on Choose and Dont Choose Concept
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + dp[i]);
        }

        return dp[dp.length - 1];
    }

}
