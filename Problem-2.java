// Time Complexity : O(N*N) 
// Space Complexity : O(N*N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    int[][] dp;
    public int helper(int[][] matrix,int i, int j){
        if(i>=matrix.length || j>=matrix.length || i<0||j<0 ){
            return 9999;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
         else if(i==matrix.length-1){
             dp[i][j]=matrix[i][j];
              return dp[i][j];
         }
            
        else{
            dp[i][j]=  matrix[i][j] + Math.min( helper(matrix,i+1,j-1) , Math.min(helper(matrix,i+1,j) , helper(matrix,i+1,j+1) ));
           return dp[i][j];
        }
    }
    public int minFallingPathSum(int[][] matrix) {
       int min=Integer.MAX_VALUE;
        dp=new int[matrix.length][matrix.length];
         for(int i=0;i<matrix.length;i++)
            Arrays.fill(dp[i],-1);
        for(int i=0;i<matrix.length;i++)
            min=Math.min(min,helper(matrix,0,i));
        
        return min;
    }
}