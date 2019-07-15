/*
Time Complexity :O(n^2)
Space Complexity : O(n)
Did this code successfully run on Leetcode : not tried on Leetcode. It ran on my IDE with correct console output.
Any problem you faced while coding this : Implemented as explained in class.
*/

import java.util.*;

class minFallingPathSum{
    static int minFallingPathSum(int[][] arr){
        int n=arr.length;
        int[][] dp = new int[n][n];

        for(int i=0; i<n; i++)
        {
            dp[0][i] = arr[0][i];
        }

        for(int i=1; i<n; i++)
        {
            for(int j=0; j<n; j++) {
                if (j == 0) {
                    dp[i][j] = arr[i][j] + Math.min(dp[i - 1][j], dp[i - 1][j + 1]);
                }
                else if (j == n - 1) {
                    dp[i][j] = arr[i][j] + Math.min(dp[i - 1][j], dp[i - 1][j - 1]);
                }
                else {
                    dp[i][j] = arr[i][j] + Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i - 1][j + 1]));
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            if(min > dp[n-1][i]){
                min = dp[n-1][i];
            }
        }
        return min;
    }

    public static void main(String[] args)
    {
        int[][] arr = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        System.out.print(minFallingPathSum(arr));
    }
}