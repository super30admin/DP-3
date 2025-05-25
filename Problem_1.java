/*
 * Time Complexity - O(n + k), where:
 *   n = length of input array (to build frequency map)
 *   k = max number in the array (to fill dp from 0 to max)
 *
 * Space Complexity - O(k), where k = max number in input
 *   for both keys[] and dp[] arrays
 *
 * Approach -
 * - This is a variation of the "House Robber" problem.
 * - First, I calculate the maximum value in the input to know the range of numbers.
 * - Then, I build a `keys` array where:
 *     - keys[i] = total points earned by taking all i's (i × frequency of i)
 * - The problem now becomes: choose numbers such that you maximize the total, but
 *   cannot pick adjacent numbers (because choosing number x deletes x-1 and x+1).
 * - I apply the House Robber logic:
 *     - dp[i] = max(dp[i-1], dp[i-2] + keys[i])
 *     - dp[i-1] → skip current number
 *     - dp[i-2] + keys[i] → take current number
 * - The final answer is dp[max], which gives the maximum points you can earn.
 */

import java.util.Arrays;

public class Problem_1 {
    public static int delete_and_earn_recursive(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(nums[i], max);
        }
        int[] keys = new int[max + 1];
        Arrays.fill(keys, 0);
        for (int i = 0; i < nums.length; i++) {
            keys[nums[i]] += nums[i];
        }
        int[] dp = new int[max + 1];
        dp[0] = keys[0];
        dp[1] = Math.max(keys[0], keys[1]);
        for (int i = 2; i < max + 1; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + keys[i]);
        }
        return dp[max];
    }

    public static void main(String[] args) {
        int[] nums1 = { 3, 4, 2 };
        int[] nums2 = { 2, 2, 3, 3, 3, 4 };
        System.out.println(delete_and_earn_recursive(nums1));
        System.out.println(delete_and_earn_recursive(nums2));
    }
}
