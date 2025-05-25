/**
 * Approach:
 * - This problem is a variation of the House Robber problem.
 * - First, convert the input into a frequency-based sum array: `sum[i]` holds total points from all i's.
 * - Deleting an element `i` earns `sum[i]` points but forces us to skip `i-1` and `i+1`.
 * - So, the problem reduces to choosing elements from the `sum[]` array such that no two adjacent indices are chosen — classic DP.
 * - Apply bottom-up dynamic programming:
 *   - For each `i` from 2 to end: `sum[i] = max(sum[i-1], sum[i-2] + sum[i])`.
 * - Return `sum[10001]` which will contain the maximum points.
 */
// Time Complexity : O(N + M), where N is length of input array and M is the range of values (max 10001).
// Space Complexity : O(M), for the `sum` array.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int deleteAndEarn(int[] nums) {
        int[] sum = new int[10002]; // sum[i] stores total points from value i
        // Fill sum array: total points earned from each number
        for (int i = 0; i < nums.length; i++) {
            sum[nums[i]] += nums[i];
        }
        // Apply House Robber pattern to sum array
        for (int i = 2; i < sum.length; i++) {
            sum[i] = Math.max(sum[i - 1], sum[i - 2] + sum[i]);
        }
        return sum[10001]; // Max points that can be earned
    }
}
