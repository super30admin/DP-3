/*
 Approach: Delete and Earn (Bottom-up Dynamic Programming)
 - Transform: Build an array `array` where array[val] = total points obtainable by taking all occurrences of val (i.e., sum of val * count(val)).
 - Reduce to House Robber problem: choosing value `v` earns array[v] but forbids choosing v-1 and v+1.
 - Use iterative DP (`dp[i]` = max points considering values up to i). Base cases for 0 and 1, then dp[i] = max(dp[i-1], array[i] + dp[i-2]).

 Time Complexity: O(N + M) where N = nums.length (to build `array`) and M = max(nums) (to fill DP). Essentially O(N + M).
 Space Complexity: O(M) for the auxiliary arrays (`array` and `dp`). This can be optimized to O(1) by keeping two variables instead of full dp.
 LeetCode: https://leetcode.com/problems/delete-and-earn/ (Problem 740)
*/

public class DeleteAndEarnDP {

    int[] dp;

    public int deleteAndEarn(int[] nums) {
        int max = 0;
        for (int n : nums) {
            max = Math.max(max, n);
        }
        int[] array = new int[max + 1];
        for (int n : nums) {
            array[n] += n;
        }

        dp = new int[max + 1];
        dp[0] = array[0];
        dp[1] = Math.max(array[0], array[1]);

        for (int i = 2; i < array.length; i++) {
            dp[i] = Math.max(dp[i - 1], array[i] + dp[i - 2]);
        }

        return dp[max];
    }

    public static void main(String[] args) {
        System.out.println(new DeleteAndEarnDP().deleteAndEarn(new int[]{2, 2, 3, 3, 3, 4}));
    }
}
