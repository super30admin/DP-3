// Time Complexity :O(n) [n is max value in the nums array]
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach

import java.util.Arrays;

class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {

        // Find max in array
        int max = Integer.MIN_VALUE;
        for (int x : nums) {
            max = Math.max(x, max);
        }

        // Transfrom the data to house robber problem
        int arr[] = new int[max + 1];

        for (int x : nums) {
            arr[x] += x;
        }

        // return helperRecursion(arr, max);

        // int dp [] = new int [max + 1];
        // Arrays.fill(dp, -1);
        // return helperMemoization(arr, max, dp);

        // return helperTabulation(arr);
         return helperOptimizedTabulation(arr);
    }

    // private int helperRecursion(int arr[], int n) {
    // //Base
    // if (n < 0) {
    // return 0;
    // }

    // //logic
    // if (n == 0) {
    // return arr[0];
    // }

    // //choose
    // int choose = helperRecursion(arr, n-2) + arr[n];
    // //not choose
    // int notChoose = helperRecursion(arr, n-1) + 0;

    // return Math.max(choose, notChoose);
    // }

    // private int helperMemoization(int arr[], int n, int [] dp) {
    // //Base
    // if (n < 0) {
    // return 0;
    // }

    // //logic
    // if (n == 0) {
    // return arr[0];
    // }

    // if(dp[n] != -1) {
    // return dp[n];
    // }

    // //choose
    // int choose = helperMemoization(arr, n-2, dp) + arr[n];
    // //not choose
    // int notChoose = helperMemoization(arr, n-1, dp) + 0;

    // return dp[n] = Math.max(choose, notChoose);
    // }

    // private int helperTabulation(int arr[]) {
    //     int n = arr.length;
    //     int dp[] = new int[n];
    //     Arrays.fill(dp, -1);

     //Base case
    //     dp[0] = arr[0];

    //     if (n > 1) {
    //         dp[1] = Math.max(arr[0], arr[1]);
    //     }

    //     for (int i = 2; i < n ; i++) {
    //         int choose = dp[i - 2] + arr[i];
    //         int notChoose = dp[i - 1] + 0;
    //         dp[i] = Math.max(choose, notChoose);
    //     }

    //     return dp[n-1];
    // }

     private int helperOptimizedTabulation(int arr[]) {
        int n = arr.length;

         //Base case
        int prev = 0;

        //Previous value, since I'm only interested in adjacent spaces so, for ith idx is previous two values
        int current = arr[0];

        for (int i = 1; i < n ; i++) {
             // for CHOOSE:   prev value plus current idx value
            int choose = prev + arr[i];

             // for NOT CHOOSE: current value plus 0
            int notChoose = current + 0;

            int ans = Math.max(choose, notChoose);

            //make new prev as current and ans as new current
            prev = current;
            current = ans;
        }

        return current;
    }
}