// Time Complexity : Exponential
// Space Complexity : O(N) to store the recursion stack
// Did this code successfully run on Leetcode : Time limit exceeded
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
/*
 * Exahuastive search(recurssion) using DO NOT CHOOSE CHOOSE method.
 */

public class MinimumFallingPathSum {
    public int minFallingPathSum(int[][] matrix) {
        if(matrix == null || matrix.length < 1) {
            return 0;
        }
        int minFSum = Integer.MAX_VALUE;
        
        for(int i = 0; i < matrix.length; i++) {
            minFSum = Math.min(minFSum, recurse(matrix, 0, i));
        }
        return minFSum;
    }

    private int recurse(int[][] matrix, int row, int coloumn) {
        if(coloumn < 0 || coloumn == matrix.length) {
            return Integer.MAX_VALUE;
        }
        if(row == matrix.length - 1) {
            return matrix[row][coloumn];
        }
        
        int left = recurse(matrix, row + 1, coloumn);
        int mid = recurse(matrix, row + 1, coloumn + 1);
        int right = recurse(matrix, row + 1, coloumn - 1);
        return Math.min(left, Math.min(mid, right)) + matrix[row][coloumn];
    }
}

// Time Complexity : O(n^2)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
/*
 * We use BOTTOM UP aproach and mutate same grid, we start fron second last row(n-2) and fill values with
 * current cost of that cell + min between (row+1, col if col ==0) or (row+1, col-1 if last coloumn) else min betwen all three and calculate same for all.
 * In the end return minimum of 1st row.
 */

class MinimumFallingPathSumDp {
    public int minFallingPathSum(int[][] matrix) {
        if(matrix == null || matrix.length < 1) {
            return 0;
        }
        
        int n = matrix.length;
        int m = matrix[0].length;
        for(int i = n - 2; i >= 0; i--) {
            for(int j = 0; j < m; j++) {
                if(j == 0) {
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i + 1][j], matrix[i + 1][j + 1]);
                } 
                else if(j == m - 1) {
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i + 1][j], matrix[i + 1][j - 1]);
                }
                else {
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i + 1][j - 1], Math.min(matrix[i + 1][j], matrix[i + 1][j + 1]));
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            min = Math.min(min, matrix[0][i]);
        }

        return min;
    }
}
