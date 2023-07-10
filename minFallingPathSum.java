// Time Complexity : O(n^2)
// Space Complexity : O(n^2)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


import java.util.Arrays;

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];

        for(int i=0; i<n; i++){
            dp[n-1][i] = matrix[n-1][i];
        }

        for(int i=n-2; i>=0; i--){
            for(int j=0; j<n; j++){
                int min = Integer.MAX_VALUE;
                for(int k=-1; k<=1; k++){
                    if(j+k >=0 && j+k <n){
                        min = Math.min(min, dp[i+1][j+k]);
                    }
                }
                dp[i][j] = matrix[i][j] + min;
            }
        }

        int result = Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            result = Math.min(result, dp[0][i]);
        }

        return result;
    }
}