// Time Complexity : O(N*N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes, could not get the idea how to use the DP at all. Completely confused with DP.
// i need a seperate alone session .  on saturday if posssible.


// Your code here along with comments explaining your approach


class Solution {
    public int minFallingPathSum(int[][] A) {
        int m = A.length;
        int n = A[0].length;
        

        if (m == 1 || n == 1) return A[0][0];
        
        Integer[][] dp = new Integer[m][n];
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < A.length; i++){
            ans = Math.min(ans, minFallingPathSum(A, 0, i, dp));
        }
        
        return ans;
    }
    
    int minFallingPathSum(int[][] A, int row, int col, Integer[][]dp){
        int m = A.length;
        int n = A[0].length;
        
        if (dp[row][col] != null) return dp[row][col];
        
        if (row == n-1) //If we are on the last row then we are done for this path
            return dp[row][col] = A[row][col];
        
        int left = Integer.MAX_VALUE, right = Integer.MAX_VALUE;
        if (col > 0)
         left = minFallingPathSum(A, row +1, col-1, dp);
        
        int straight = minFallingPathSum(A, row+1, col, dp);
        
        if (col < n-1)
         right = minFallingPathSum(A, row+1, col+1, dp);
            
        dp[row][col] = Math.min(left, Math.min(straight, right)) + A[row][col];
        
        return dp[row][col];
    }
}
