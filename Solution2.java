/*
    Time Complexity : row * (col ^ n)
    Space Complexity : row * col
    
*/
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix.length];
        for(int i=0; i<matrix.length; i++){
            Arrays.fill(dp[i], -1);
        }
        
        
        int minPath = Integer.MAX_VALUE;
        for(int j=0; j<matrix[0].length; j++){
            
            minPath = Math.min(minPath, helper(matrix, 0, j, dp));
        }
        return minPath;
    }
    
    public int helper(int[][] matrix, int row, int col, int[][] dp){
        if(row < 0 || row >= matrix.length || col < 0 || col >= matrix.length){
            return 100000;
        }
        
        if(row == matrix.length - 1){
            return matrix[row][col];
        }
        
        if(dp[row][col] != -1 ){
            return dp[row][col];
        }
        
        int min = Integer.MAX_VALUE;
        
        int below = helper(matrix, row + 1, col, dp);
        int diagLeft = helper(matrix, row + 1, col - 1, dp);
        int diagRight = helper(matrix, row + 1, col + 1, dp);
    
        
        min = matrix[row][col] + Math.min(min, Math.min(below, Math.min(diagLeft, diagRight)));
        
        dp[row][col] = min;
        
        return min;
    }
}
