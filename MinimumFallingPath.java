// Time Complexity : O(3^n) - n = no of colums
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : No - Time limit exceeded on some problems
// Any problem you faced while coding this : Yes- Need to learn to optimise


// Your code here along with comments explaining your approach
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int minCost = Integer.MAX_VALUE;
        for(int j=0;j<matrix[0].length;j++){
            minCost = Math.min(minCost, helper(matrix, matrix.length-1, j));//bottom up we start
        }
        return minCost;
    }
    public int helper(int[][] matrix, int row, int col){
        int result = Integer.MAX_VALUE;
        if(row==0){
            return matrix[row][col];
        }
        
        //to the left
        if(col>0){
            result = Math.min(result, helper(matrix, row-1, col-1));
        }
        
        //directly below
        result = Math.min(result, helper(matrix, row-1, col));
        
        //to the right
        if(col<matrix[0].length-1){
            result = Math.min(result, helper(matrix, row-1, col+1));
        }
        
        return result+matrix[row][col];
    }
}