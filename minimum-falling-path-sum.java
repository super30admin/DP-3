//Time complexity: O(MN)
//Space complexity: O(MN))
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int min = Integer.MAX_VALUE;

			int[][] dp = new int[matrix.length][matrix[0].length];

			for (int[] m : dp) {
				Arrays.fill(m, -1);
			}

			for (int i = 0;i < matrix[0].length; i++) {
				min = Math.min(min, helperMethod(matrix, 0, i, dp));
			}

			return min;
    }
    
    private int helperMethod(int[][] matrix, int r, int c, int[][] dp) {
        
			int min = 0;
            //if the current value at current cell is not -1, return the current value at the cell
			if (dp[r][c] != -1) {
				return dp[r][c];
            }
            //if row has not reached the boundary yet
			if (r+1 < matrix.length) {
                //we will compare min with the value at current cell
				min = helperMethod(matrix, r+1, c, dp);
                //compare min with value at next cell (same row, col + 1)
				if (c+1 < matrix[0].length) {
					int min1 = helperMethod(matrix, r+1, c+1, dp);
					if (min1 < min) min = min1;
				}
                //checking the boundary condition for column
				if (c-1 >= 0) {
                    //compare min with value at 
					int min2 = helperMethod(matrix, r+1, c-1, dp);
					if (min2 < min) min = min2;
				}
			}

			dp[r][c] = matrix[r][c] + min;
			return dp[r][c];
    }
}