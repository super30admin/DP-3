package com.ds.rani.dp;

import java.util.Arrays;

/**
 * Given an array nums of integers, you can perform operations on the array.
 * In each operation, you pick any nums[i] and delete it to earn nums[i] points. After, you must delete every element
 * equal to nums[i] - 1 or nums[i] + 1.
 *
 * You start with 0 points. Return the maximum number of points you can earn by applying such operations.
 * Example 1:
 * Input: nums = [3, 4, 2]
 * Output: 6
 * Explanation: Delete 4 to earn 4 points, consequently 3 is also deleted.
 * Then, delete 2 to earn 2 points. 6 total points are earned.
 *
 * Example 2:
 * Input: nums = [2, 2, 3, 3, 3, 4]
 * Output: 9
 *
 * Explanation: Delete 3 to earn 3 points, deleting both 2's and the 4.
 * Then, delete 3 again to earn 3 points, and 3 again to earn 3 points.9 total points are earned.
 * Note: The length of nums is at most 20000. Each element nums[i] is an integer in the range [1, 10000].
 */

//Approach:create 2D array of size n by 2 and then check which value should be deleted
public class DeleteAndEarn {
    //Time complexity o(n log n) where n is size of array
    //Space complexity o(n)
    public static int deleteAndEarn(int[] nums) {
        if (nums == null)
            return 0;
        Arrays.sort( nums );
        //taken 2 columns because I am just deciding whether to consider or not consider current value

        int dp[][] = new int[nums.length + 1][2];

        int i = 0;
        for (i = 1; i < dp.length; i++) {
            //If previous number is same as current number
            if (i < 2 || nums[i - 2] == nums[i - 1]) {
                dp[i][0] = dp[i - 1][0] + nums[i - 1];
                dp[i][1] = dp[i - 1][1];
            } else if (nums[i - 2] == nums[i - 1] - 1) {
                dp[i][0] = nums[i - 1] + dp[i - 1][1];
                // if we don't delete it, then we take whatever is best from the previous row
                dp[i][1] = Math.max( dp[i - 1][0], dp[i - 1][1] );
            } else {
                // else we are free to take whatever we want from the one before in both cases
                // since the previous one is not nums[i]-1
                dp[i][0] = nums[i - 1] + Math.max( dp[i - 1][0], dp[i - 1][1] );
                dp[i][1] = Math.max( dp[i - 1][0], dp[i - 1][1] );
            }

        }
        return Math.max( dp[i - 1][0], dp[i - 1][1] );

    }

    public static void main(String[] args) {
        int nums[] = {2, 2, 3, 3, 3, 4};
        System.out.println(DeleteAndEarn.deleteAndEarn( nums ));

    }
}
