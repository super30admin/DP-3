/*
Author: Akhilesh Borgaonkar
Problem: LC 931. Minimum Falling Path Sum (DP-3)
Approach: Using Dynamic Programming approach here to find the minimum sum based on previous minimum sums in the given matrix. 
Time Complexity: O(m*n) where m and n are rows and cols of input matrix resp.
Space complexity: O(m * n) where m and n are rows and cols of input matrix resp.
Issue: Gives inappropriate answer. I will re-work on this after class.
*/

class Solution {
    public int minFallingPathSum(int[][] A) {
        int[][] dp = new int[A.length][A[0].length];
        int r = dp.length, c = dp[0].length;
        
        for(int j=0; j<c; j++)
            dp[0][j] = A[0][j];
        
        for(int i=1; i<r; i++){
            for(int j=0; j<c; j++){
                
                int minFromUp  = 0;
                if(j==0)
                    minFromUp = Math.min(A[i-1][j],A[i-1][j+1]);
                if(j>0 && j<c-1)
                    minFromUp = Math.min(A[i-1][j-1], Math.min(A[i-1][j], A[i-1][j+1]));
                if(j==c-1)
                    minFromUp = Math.min(A[i-1][j], A[i-1][j-1]);
                    
                dp[i][j] = A[i][j] + minFromUp;
                
                System.out.print(dp[i][j] + ",");
            }
            System.out.println(' ');
        }
        
        int min = dp[r-1][0];
        for (int i = 1; i < c; i++)
            min = Math.min(min, dp[r-1][i]);
        return min;
    }
}