//time complexity: O(number of columns * number of rows)
//space complexity : O(1)
//executed on leetcode : yes
//issues faced : no

class Solution {
    public int minFallingPathSum(int[][] A) {
        int[][] dp= new int[A.length][A.length];
        for(int j=0;j<A.length;++j) dp[0][j] = A[0][j];
        for(int i=1;i<A.length;++i)
        {   
            for(int j=0;j<A.length;++j)
            {
                if(j==0) // if column is zero, it means the upper value may be at 1st or same column of the previous row; we take min value plus value of current element.
                {
                    dp[i][j] = A[i][j] + Math.min(dp[i-1][j],dp[i-1][j+1]);
                }
                else if(j==A.length-1) // if column is the last one, the upper value may be from same column or second last column of the previous row;we take min value plus value of current element.
                {
                    dp[i][j] = A[i][j] + Math.min(dp[i-1][j],dp[i-1][j-1]);
                }
                else // the upper value will may be from same column, previous column or next column of the previous row; we take min value plus value of current element.
                {
                    dp[i][j] = A[i][j] + Math.min(dp[i-1][j],Math.min(dp[i-1][j-1],dp[i-1][j+1]));
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i=0;i<A.length;++i)
        {
            min = Math.min(min,dp[A.length-1][i]);
        }
        return min;
        
    }
}