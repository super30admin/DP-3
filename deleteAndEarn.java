// Time Complexity : O(max(n, max valued element))
// Space Complexity : O(max element)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : The intution to create a dp array of the size amount and add nums to its indexes


// Your code here along with comments explaining your approach
class Solution {
    public int deleteAndEarn(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        // Get the max value from the nums array
        int max = Integer.MIN_VALUE;
        for (int num: nums) {
            max = Math.max(max, num);
        }

        // Create an int array of max+1 size, and add the nums of the same value in same index, example: 2,2,2 will be 2+2+2 at index 2
        int[] dp = new int[max+1];
        for (int num: nums) {
            dp[num] += num;
        }

        // Now its becomes a house robber style problem
        // Iterate over the dp array and update the skip and take case
        // skip = Math.max(previous skip, previous take)
        // take = previous skip + current num
        int skip = 0, take = dp[0];
        for (int i=1; i<=max; i++) {
            int temp = skip;
            skip = Math.max(skip, take);
            take = temp + dp[i];
        }

        // Return the max of the final skip and take value
        return Math.max(skip, take);
    }
}