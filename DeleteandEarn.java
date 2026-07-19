// Time Complexity : O(n) where n is the maximum number in the input array. We iterate through the input array to find the maximum number and then fill the dp array based on the values in arr.
// Space Complexity : O(n) where n is the maximum number in the input array. We use an additional array arr to store the sum of values for each number and a dp array to store the maximum points that can be earned up to each number.
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach
// Greedy will not work, we need to go exhaustive, but it will give time limit
// So we need to do tabulation / memoization
// We can use a dp array to store the maximum points that can be earned up to each number.
// We first find the maximum number in the input array to determine the size of the dp array.
// We then create an array arr where arr[i] represents the total points that can be earned by deleting all instances of number i in the input array.
// We then fill the dp array using the following recurrence relation:
// dp[i] = max(dp[i - 1], arr[i] + dp[i - 2])
// This means that for each number i, we can either choose to delete it and earn the points from arr[i] plus the maximum points earned up to i-2, or we can choose to skip it and take the maximum points earned up to i-1. 
// We return dp[max] as the final answer, which represents the maximum points that can be earned by deleting numbers from


class Solution {

    public int deleteAndEarn(int[] nums) {

        int max = 0;

        for (int num : nums) {
            max = Math.max(max, num);
        }

        int[] arr = new int[max + 1];

        for (int num : nums) {
            arr[num] += num;
        }

        int[] dp = new int[max + 1];

        dp[0] = arr[0];

        if (max >= 1) {
            dp[1] = Math.max(arr[0], arr[1]);
        }

        for (int i = 2; i <= max; i++) {

            dp[i] = Math.max(dp[i - 1],
                             arr[i] + dp[i - 2]);
        }

        return dp[max];
    }
}