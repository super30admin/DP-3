//Problem: LeetCode 931
//Approach: Used Dynamic Programming to find the pattern of repeating sub-problems. 
//Time Complexity: O(n^2)
//Space complexity: O(n^2) 

class MinimumFallPathSum {
    public int minFallingPathSum(int[][] A) {
        
        int n = A.length;
        
        int [][] dp = new int[n][n];
        int min = Integer.MAX_VALUE;
        for (int j=0; j<n;j++) {
            dp[0][j] = A[0][j];
        }    
        
        for (int i=1;i< n;i++) {
            for (int j=0; j<n;j++) {
                
                if (j==0) {
                    dp[i][j] = A[i][j]+ Math.min(dp[i-1][j],dp[i-1][j+1]);
                }
                else if (j==A.length-1) {
                    
                    dp[i][j] = A[i][j] + Math.min(dp[i-1][j-1],dp[i-1][j]);                    
                }
                
                else {
                    dp[i][j] = A[i][j] + Math.min(Math.min(dp[i-1][j-1],dp[i-1][j]),dp[i-1][j+1]);
                }
                
            }
        }
        
        for (int j=0; j<n;j++){
            if (min > dp[n-1][j]) {
                min = dp[n-1][j];
            }
        }
        
        return min;
        
    }

}