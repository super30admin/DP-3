// Time Complexity :O(n^2) since it's a square array
// Space Complexity :O(n^2)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No, it was similar to the paint houses problem


// Your code here along with comments explaining your approach

class Solution {
    public int minFallingPathSum(int[][] A) {
        
        if(A.length == 0){
            return 0;
        }
    
        //Since, it's a square array - I didn't need two variables to store lengths
        int n = A.length;
        int m = A[0].length;
        
        //edge case
        if(n==1){
            return A[0][0];
        }
        
        int min = 9999;
        
        int[][] dp = new int[n][m];
        
        for(int i = 0; i < m; i++){
            dp[0][i] = A[0][i];
        }
        
        for(int i = 1; i < n; i++){
            for(int j = 0; j < m; j++){
                //if it's not the edge elements of the the row
                if(j!=0 && j!=m-1){
                   dp[i][j] = A[i][j] + Math.min(Math.min(dp[i-1][j-1],dp[i-1][j]), dp[i-1][j+1]);
                }
                //if it's the start of the row
                else if(j==0){
                    dp[i][j] = A[i][j] + Math.min(dp[i-1][j],dp[i-1][j+1]);
                }
                //if it's the end of the row
                else if(j==m-1){
                    dp[i][j] = A[i][j] + Math.min(dp[i-1][j],dp[i-1][j-1]);
                }
                
                //Get the minimum from the last row
                if(i==n-1){
                    min = Math.min(min,dp[i][j]);
                }
            }
        }
        
        return min;
    }
}
