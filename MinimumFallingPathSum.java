// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Recursive Solution

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        
        int min = helper(matrix, 0, 0, 0);
        
        for (int i=1;i<matrix[0].length;i++) {
            min = Math.min(min, helper(matrix, 0, i, 0));
        }
        
        return min;
    }
    
    private int helper(int[][] matrix, int row, int col, int min_value) {
        // base case
        if(row == matrix.length) {
            return min_value;
        }
        
        
        // Logic
        
        int left = col == 0 ? 100000 : helper(matrix, row+1, col-1, min_value + matrix[row][col]);
        
        int mid = helper(matrix, row+1, col, min_value + matrix[row][col]);
        
        int right = col == matrix.length - 1 ? 10000 : helper(matrix, row+1, col+1, min_value + matrix[row][col]);
        
        
        return Math.min(left, Math.min(mid, right));
        
    }
}

// Dynamic Programming Solution

class DynamicProgramming {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        // we modify the same array and compute the minimum for each element
        // Our first row elements are minimum in itself.
        // So, we start computation from 2nd row
        
        for (int row=1;row<m;row++) {
            for(int col=0;col<n;col++) {
                int left = (col == 0) ? Integer.MAX_VALUE : matrix[row-1][col-1];
                int mid  = matrix[row-1][col];
                int right = (col == m - 1) ? Integer.MAX_VALUE : matrix[row-1][col+1];
                
                matrix[row][col] = matrix[row][col] + Math.min(left, Math.min(mid, right));
            }
        }
        
        // Find the minimum in the last row
        int min = matrix[m-1][0];
        
        for (int j=1;j<n;j++) {
            min = Math.min(min, matrix[m-1][j]);
        }
        
        return min;
    }
}
