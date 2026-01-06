// Time Complexity : O(n^2)
// Space Complexity : O(n^2)
// Did this code successfully run on Leetcode? : Yes
public class MinFallingPathSum {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        // dp[i][j] represents the minimum sum to reach cell (i, j)
        // from any element in the first row.
        int[][] dp = new int[n][n];

        // Initialize the first row: the path starts here
        for (int j=0;j<n;j++){
            dp[0][j] = matrix[0][j];
        }

        // Build the dp table row by row
        for (int i=1;i<n;i++){
            for (int j=0;j<n;j++){
                int min;
                // Case 1: Leftmost column can only come from (j) or (j+1)
                if (j==0){
                    min = Math.min(dp[i-1][j],dp[i-1][j+1]);
                } else if(j == n-1){ // Case 2: Rightmost column can only come from (j-1) or (j)
                    min = Math.min(dp[i-1][j-1],dp[i-1][j]);
                }else{
                    min = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j],dp[i-1][j+1]));
                }

                // Add current matrix value to the best possible previous path
                dp[i][j] = matrix[i][j]+min;
            }
        }

        // Find the minimum value in the last row
        int finalMin = Integer.MAX_VALUE-10;
        for (int i=0;i<n;i++){
            finalMin = Math.min(finalMin, dp[n-1][i]);
        }

        return finalMin;

    }
    public static void main(String[] args){
        MinFallingPathSum obj = new MinFallingPathSum();

        int[][] matrix = {
                {2, 1, 3},
                {6, 5, 4},
                {7, 8, 9}
        };

        int result = obj.minFallingPathSum(matrix);
        System.out.println("Minimum Falling Path Sum = " + result);
    }
}
