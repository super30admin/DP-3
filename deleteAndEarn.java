// Time Complexity : O(2^n) + O(max(n)) , n is length of the array
// Space Complexity : O(2^n) + O(k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
/* The exhaustive recursive solution gave a time limit excess 
 * We have a set of numbers, out of which some are missing but we need to delete the numbers such that we cannot use the i-1 and i+1 number
 * so calculating the maximum number and creating a new array such that we have sum of every number in the array.
 * Then follow the house robbing approach of select the maximum value at the end
 */
public class deleteAndEarn {

    public int deleteAndEarn(int[] nums) {

        if (nums.length == 0 || nums == null)
            return 0;

        int max = nums[0];

        for (int num : nums) {
            max = Math.max(num, max);
        }

        int[] arr = new int[max + 1];
        for (int num : nums) {
            arr[num] += num;
        }

        return helper(arr, 0, 0);

    }

    private int helper(int[] arr, int index, int amount) {
        // base
        if (index >= arr.length)
            return amount;
        // case1 not choose
        int case1 = helper(arr, index + 1, amount);

        // case2 choose
        int case2 = helper(arr, index + 2, amount + arr[index]);

        return Math.max(case1, case2);
    }

}

// Time Complexity : O(n) + O(max(n)), n is length of the array
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {
    public int deleteAndEarn(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int max = nums[0];

        for (int num : nums) {
            max = Math.max(max, num);
        }

        int[] arr = new int[max + 1];

        for (int num : nums) {
            arr[num] += num;
        }

        int n = arr.length;
        int[] dp = new int[n];

        dp[0] = arr[0];
        dp[1] = Math.max(arr[0], arr[1]);

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + arr[i]);
        }
        return dp[n - 1];
    }
}
