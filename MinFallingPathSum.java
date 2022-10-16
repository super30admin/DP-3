
public class MinFallingPathSum {
    public int minFallingPathSum(int[][] matrix) {
        if(matrix==null || matrix.length==0) return 0;
        int res = Integer.MAX_VALUE;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                // fill the first row
                if(i==0) dp[i][j] = matrix[i][j];
                else if(j==0) dp[i][j] = matrix[i][j]+ Math.min(dp[i-1][j], dp[i-1][j+1]); // left-most column
                else if(j==n-1) dp[i][j] = matrix[i][j]+ Math.min(dp[i-1][j], dp[i-1][j-1]); // right-most column
                else dp[i][j] = matrix[i][j]+ Math.min(dp[i-1][j], Math.min(dp[i-1][j-1], dp[i-1][j+1])); // middle number
            }
        }
        for(int l=0;l<n;l++){
            res = Math.min(res, dp[m-1][l]);
        }
        return res;
    }
}

// Time Complexity - O(n2)
// Space Complexity - (1)
