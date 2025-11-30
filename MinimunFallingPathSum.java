// Time Complexity : O(M*N)
// Space Complexity : O (M*N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int len = matrix.length;
        int[][] dp = new int[len][len];
        for(int i = 0; i < len; i++)
        {
            dp[0][i] = matrix[0][i];
        }
        int[][] validindex = new int[][]{{-1,0}, {-1, -1}, {-1,1}};
        for(int i = 1; i < len; i++)
        {
            for(int j = 0; j < len; j++)
            {
                int min = Integer.MAX_VALUE;
                for(int indx = 0; indx < validindex.length; indx++)
                {
                    int row = i + validindex[indx][0];
                    int col = j + validindex[indx][1];
                    if(row >= 0 && row < len && col >= 0 && col < len)
                    {
                        min = Math.min(min, matrix[i][j]+dp[row][col]);
                    }
                }
                dp[i][j] = min;
            }
        }
        int minresult = Integer.MAX_VALUE;
        for(int i = 0; i < len; i++)
        {
            minresult = Math.min(minresult, dp[len-1][i]);
        }
        return minresult;
    }
}