// Time Complexity : O(m * n)
// Space Complexity : O(m * n)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO

public class MinimumFallingPathSum {
    public int minFallingPathSum(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length + 2];
        for(int i = 1; i< dp[0].length-1; i++){
            dp[0][i] = matrix[0][i-1];
        }

        for(int i = 1; i< matrix.length; i++){
            dp[i-1][0] = Integer.MAX_VALUE;
            dp[i-1][dp[0].length-1] = Integer.MAX_VALUE;

            for(int j =1; j< dp[0].length-1; j++){
                
                int left = dp[i-1][j-1];
                int above = dp[i-1][j];
                int right = dp[i-1][j+1];
                //I'm getting all three values that are above and diagonal
                //Then Finding min value among them
                int min = Math.min(right, Math.min(left, above));
                //Adding it to the current matrix val
                dp[i][j] = matrix[i][j-1] + min;
            }
        }
        
        int min = Integer.MAX_VALUE;
        for(int j =1; j< dp[0].length-1; j++){
            if(min > dp[dp.length-1][j])
                min = dp[dp.length-1][j];
        }
        return min;
    }
}