// Time Complexity : O(n * n)
// Space Complexity : O(n * n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : 
public class Solution {
    public int MinFallingPathSum(int[][] matrix) {
        int n = matrix[0].Length;
        if(n == 1) { return matrix[0][0]; }
        int[][] dp = new int[n][];
        int minValue = Int32.MaxValue;
        for(int i = 0; i< n; i++) {
            dp[i] = new int[n];
            for(int j = 0; j < n;j++) {
                if(i == 0) { // copy the first row of the matrix to the first row of new array dp
                    // first row
                    dp[i][j] = matrix[i][j];
                }
                else {
                    // rest of the rows 
                    int temp = 0;
                    if(j == 0) { // get min of jth and j+1th values of previous row
                        temp = Math.Min(dp[i-1][j], dp[i-1][j+1]);
                    }
                    else if(j == n-1) { // get min of jth and j-1th values of previous row
                        temp = Math.Min(dp[i-1][j], dp[i-1][j-1]);
                    }
                    else { // get min of jth, j-1th and j+1th values of previous row 
                         temp = Math.Min(dp[i-1][j+1], Math.Min(dp[i-1][j], dp[i-1][j-1]));
                    }
                    dp[i][j] = matrix[i][j] + temp; // sum up value of matrix and min value from the above computation

                    if(i == n-1) { // minimum value in the last row gives the min falling path sum
                        minValue = dp[i][j] < minValue ? dp[i][j] : minValue;
                    }
                }
            }
        }
    return minValue;
    }
}