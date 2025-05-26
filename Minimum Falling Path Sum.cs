/*
  Time complexity:O(m*n)
  Space complexity:O(n)

  Code ran successfully on leetcode: Yes

  Approach: The path sum is computed from the last row traversing all the columns in those rows leading to the minimum.
*/

public class Solution {
    public int MinFallingPathSum(int[][] matrix) {
        int n = matrix.Length;

        int[] dp = new int[n+1];
        
        for(int row = n-1; row>=0; row--)
        {
            int[] dp2 = new int[n+1];
            for(int col = 0; col<n; col++)
            {
                if(col==0)
                {
                    dp2[col] = Math.Min(dp[col],dp[col+1])+matrix[row][col];

                }
                else
                {
                    if(col==n-1)
                    {
                        dp2[col] = Math.Min(dp[col],dp[col-1])+matrix[row][col];
                    }
                    else
                    {
                        dp2[col] = Math.Min(dp[col-1],Math.Min(dp[col],dp[col+1]))+matrix[row][col];
                    }
                }
                
            }
            dp=dp2;
        }
        int result = int.MaxValue;
        for(int i=0;i<n;i++)
            result = Math.Min(result,dp[i]);

        return result;
    }
}
