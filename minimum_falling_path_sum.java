/*

Did it run on leet code: yes
Time Complexity: 0(N*N)
Space Complexity: 0(N*N)

Difficluties: Converting recursion tree to dp

Algorithm:

For every cell in in array, we calculate what is cost of minimum path from that positions

We create a `dp` array. Where dp[i][j] denotes minimum path sum from (i,j)


*/


class Solution {
    public int minFallingPathSum(int[][] A) {
        
        if(A==null || A.length==0){
            return 0;
        }else if(A.length==1){
            return A[0][0];
        }
        
        int[][] dp = new int[A.length][A.length];
        int rows = A.length;
        int cols = A[0].length;
        
        for(int j=0;j<cols;++j){
            dp[rows-1][j]=A[rows-1][j];
        }
        
        for(int i=A.length-2;i>=0;--i){
            
            dp[i][0]= A[i][0] + Math.min(dp[i+1][0],dp[i+1][1]);
            for(int j=1;j<cols-1;++j){
                dp[i][j] = A[i][j] + Math.min(dp[i+1][j-1],Math.min(dp[i+1][j],dp[i+1][j+1]));
            }
            
            dp[i][cols-1]= A[i][cols-1] + Math.min(dp[i+1][cols-1],dp[i+1][cols-2]);
        }
        
        int min = Integer.MAX_VALUE;
        for(int j=0;j<cols;++j){
            min = Math.min(min,dp[0][j]);
        }
            
        return min;
    }
}