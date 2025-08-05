/**Time Complexity: O(n^2)
 * Space Complexity: O(n)
 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this : No
 */

/**
 * A dummy element is added at the start and end of the dp array to avoid index out of bound exception for dp[j+1] and to maintain consistency in how the minimum of current, previous, and next is calculated when each element is chosen.
 * The dummy elements are initialized to Integer.MAX_VALUE to ensure they do not affect the minimum calculations. Also, only one dp array is used to optimize space, and the previous value is tracked using a separate variable without iterating through the dp array again at the end of for loop.
 * This dp problem uses the same approach as the paint house problem.
 */

class minFallingPathSum {
    public int minFallingPathSum(int[][] matrix) {

        int len=matrix.length;
        int[] dp=new int[len+2];
        dp[0]=Integer.MAX_VALUE;
        dp[len+1]=Integer.MAX_VALUE;
        int min=Integer.MAX_VALUE;
        for(int i=1;i<=len;i++)
        {
            dp[i]=matrix[len-1][i-1];
        }
        int prev=dp[0];
        int curr;
        for(int i=len-2;i>=0;i--)
        {
            for(int j=1;j<=len;j++)
            {
    
                curr=dp[j];
                dp[j]=matrix[i][j-1]+Math.min(prev,Math.min(curr,dp[j+1]));
                prev=curr;
                if(j==len) prev=dp[0];
                if(i==0) 
                {
                    min=Math.min(min,dp[j]);
                }
            }
        }
        if(matrix.length==1)
        {
            return matrix[0][0];
        }
        else return min;
    }
        
        
    
}