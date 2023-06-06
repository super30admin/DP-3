package DP3;
/**
 * 
 * 
 * This problem can be seen like a paint house pattern with variable no of columns.  
 * Can be solved with bottom up DP approach
 * 
 * Time Complexity :
 * O(n^2)
 * 
 * Space Complexity :
 * O(n^2)
 * 
 * Did this code successfully run on Leetcode : yes
 * 
 * Any problem you faced while coding this : No
 */

public class Problem2 {
	
    public int minFallingPathSum(int[][] matrix) {

        int n=matrix.length;

        int dp[][]= new int[n][n];

        for (int i=0;i<n;i++){
            dp[0][i]=matrix[0][i];
        }

        for(int i=1;i<n;i++){
            for(int j=0;j<n;j++){
                if(j==0)
                    dp[i][j]=matrix[i][j]+Math.min(dp[i-1][j],dp[i-1][j+1]);
                else if(j==n-1)
                    dp[i][j]=matrix[i][j]+Math.min(dp[i-1][j],dp[i-1][j-1]);
                else
                    dp[i][j]=matrix[i][j]+Math.min(dp[i-1][j],
                    Math.min(dp[i-1][j+1],dp[i-1][j-1]));
            }
        }


        int minResult=Integer.MAX_VALUE;

        for(int i=0;i<n;i++){
            if(dp[n-1][i]<minResult)
                minResult=dp[n-1][i];
        }

        return minResult;
    }


}
