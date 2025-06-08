// Time Complexity : O(r*c)
// Space Complexity : O(r*c)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
//Approach: Let us fill a dp matrix(of same dimensions as input), such that dp[i][j] = minimum cost of choosing the nest solution
// for i-1 rojs at jth column. Fill first row with same values as input matrix. For every subsequent row, for each cell, check what is the 
//minimum result possible by choose the (j-1)th column or jth column or (j+1)th column. The final result is the minimum value in the last row
// of dp matrix

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        int dp[][] = new int[r][c];
        if(r==0){
            return 0;
        }
        for(int i=0;i<c;i++){
            dp[0][i] = matrix[0][i];
        }
        for(int i=1;i<r;i++){
            for(int j=0;j<c;j++){
                int v1 = Integer.MAX_VALUE, v2 = Integer.MAX_VALUE, v3 = Integer.MAX_VALUE;
                if(j-1>=0)
                {
                    v1 = dp[i-1][j-1];
                }
                if(j+1<=c-1)
                {
                    v2 = dp[i-1][j+1];
                }
                v3 = dp[i-1][j];
                dp[i][j] = matrix[i][j]+Math.min(v1, Math.min(v2, v3));
            }
        }
        int minRes = Integer.MAX_VALUE;
        for(int i=0;i<c;i++){
            minRes = Math.min(minRes, dp[r-1][i]);
        }
        /*
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }*/
        return minRes;
    }
}