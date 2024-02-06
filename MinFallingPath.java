// Time Complexity : O(n^2) // (n^2) to traverse the matrix and O(n) to find the minimum.
// Space Complexity : O(2n) = O(n)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[] dp = new int[n];

        for(int i = 0; i < n ; i++){
            
            dp[i] = matrix[0][i];
        }

        for(int i = 1; i < n ; i++){
            int currentRow[] = new int[n];
            for(int j = 0; j < n ; j++){
                if(j == 0){
                    //current value in the matrix + min of prev row left and right
                    currentRow[j] = matrix[i][j] + Math.min(dp[j],dp[j+1]);
                }
                else if( j == n-1){
                    currentRow[j] = matrix[i][j] + Math.min(dp[j],dp[j-1]);
                }
                else{
                    currentRow[j] = matrix[i][j] + Math.min(Math.min(dp[j],dp[j-1]),dp[j+1]);
                }
                
            }
            dp = currentRow;
        }
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < n ; i++){
            
            min = Math.min(min,dp[i]);
        }

        return min;
    }
}