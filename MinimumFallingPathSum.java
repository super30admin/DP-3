package dp3;

public class MinimumFallingPathSum {
	//Time Complexity : O(n^2), where n is the length of rows or columns
	//Space Complexity : O(1)
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : Used yesterday's technique from class
	public int minFallingPathSum(int[][] matrix) {
        for(int i=matrix.length - 2; i>=0; i--) {
            for(int j=0; j<matrix[0].length; j++)
                matrix[i][j] += Math.min(j > 0 ? matrix[i+1][j-1] : Integer.MAX_VALUE, Math.min(matrix[i+1][j], j < matrix[0].length - 1 ? matrix[i+1][j+1] : Integer.MAX_VALUE));
        }
        
        int min = Integer.MAX_VALUE;
        for(int j=0; j<matrix.length; j++)
            min = Math.min(min, matrix[0][j]);
        
        return min;
    }
	
	
	// Recursive
	// Time Complexity - O(2^n), where n is the length of matrix
	// Space Complexity - O(n)
	public int minFallingPathSum1(int[][] matrix) {
        // null
        if(matrix == null)
            return 0;
        
        int min = Integer.MAX_VALUE;
        for(int i=0; i<matrix.length; i++) {
            int minAmount = helper(matrix, 0, i, 0);
            min = Math.min(min, minAmount);
        }
        
        return min;
    }
    
    private int helper(int[][] matrix, int row, int col, int amount) {
        // base
        if(row<0 || col<0 || row>=matrix.length || col>=matrix[0].length)
            return Integer.MAX_VALUE;
        
        // logic
        amount += matrix[row][col];
        
        if(row == matrix.length - 1)
            return amount;
        
        row += 1;
        
        int case1 = helper(matrix, row, col - 1, amount);
        
        int case2 = helper(matrix, row, col, amount);
        
        int case3 = helper(matrix, row, col + 1, amount);
        
        return Math.min(case1, Math.min(case2, case3));
    }
}
