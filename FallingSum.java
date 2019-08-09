// Time : O(n^2)
// Space : O(n^2
// leetcode :yes
// difficulty: no



// for ith row jth index , falling sum upto this index will be sum of this element with minimum of element above it or 
// element in above row with column j and element in above row with column j


class Solution {
    public int minFallingPathSum(int[][] A) {
        
        int minSum= Integer.MAX_VALUE;
        int[][] dp = new int[A.length][A.length];
        
        if(A.length == 0 || A[0].length == 0)
            return 0;
        
        if(A.length == 1)
            return A[0][0];
        
        for(int j = 0; j < A.length; j++)
            dp[0][j] = A[0][j]; 
        
        
        for(int i=1;i< A.length;i++)
        {
            for(int j=0;j< A.length;j++)
            {
            
           //1st column
           if(j==0)
              dp[i][j] = Math.min(dp[i-1][j],dp[i-1][j+1]) + dp[i][j];
                
            //last column
            else if(j==A.length-1)
              dp[i][j] = Math.min(dp[i-1][j],dp[i-1][j-1]) + dp[i][j];
                    
            else
              dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i-1][j-1], dp[i-1][j+1])) + A[i][j];
            if(i == A.length-1)
                    minSum = Math.min(minSum, dp[i][j]);
                
            }    
            
        }
        return minSum ;
    }
}
