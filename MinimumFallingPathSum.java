// Time Complexity :O(N*M) n are the rows and m are the columns in the given array.
// Space Complexity :O(N*M) 
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No.


// Your code here along with comments explaining your approach:
class Solution {
    public int minFallingPathSum(int[][] A) {
        int[][] dp = new int[A.length][A[0].length];
        for(int i=0;i<dp[0].length;i++){
            dp[0][i]=A[0][i];
        }
        for(int i=1;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                if(dp[0].length==1)
                    dp[i][j]=dp[i-1][j]+A[i-1][j];
                else if(j<dp[0].length-1&&j>0)
                dp[i][j]=A[i][j]+Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i-1][j+1]));
                else if(j==0)
                    dp[i][j]=A[i][j]+Math.min(dp[i-1][j+1],dp[i-1][j]);
                else
                    dp[i][j]=A[i][j]+Math.min(dp[i-1][j-1],dp[i-1][j]);
                //System.out.print(dp[i][j]+" ");
            }
            //System.out.println();
        }
        int min=Integer.MAX_VALUE;
        for(int j=0;j<dp[0].length;j++){
            min=Math.min(dp[dp.length-1][j],min);
        }
        return min;
    }
}