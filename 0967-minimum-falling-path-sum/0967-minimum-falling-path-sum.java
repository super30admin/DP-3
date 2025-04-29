/*
Approach: Memoization(Top-Down Dynamic Programming

We are given a square matrix.  A "falling path" starts from any cell in the first row and moves down one row at a time
to a cell directly below or diagnally left/right.

To solve this, we use a recusion helper function with memoization. For every cell in the first row, 
we compute the minimum falling path sum starting from that cell by:
-Going straight down
-Going diagonally left-down(if possible)
-Going diagnally right-doen (if possible)

We store previously computed results in a 2D array(memo) to avoid recomputation.

The final result is the minimum of all falling paths starting from the first row.

Time Complexity: O(m*n), where m is the number of rows and n is the number of columns.
Space Complexty: O(m*n), due to the memoization table.


Steps:
1. Memoization table to store already computed results
2. Main function to compute falling path
3. Initialization memoization array with dimensions same as matrix
4. Try every starting column in the first row
5. Recursively compute minimum path starting at (0,i)
6. Return smallest among all possible falling paths
7. Helper function to compute min falling path sum from position (r,c)
8. Base case:  when we reach the last row, just return the value at(r,c)
9. Recursive case: Try 3 directions
10. Check if value is memoized
11. Diagnally right
12. Straight down
13. Return current value plus minimum of the three possible next steps


*/

class Solution {
    Integer[][] memo;

    public int minFallingPathSum(int[][] matrix) {
        memo = new Integer[matrix.length][matrix[0].length];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < matrix[0].length; i++) {
            min = Math.min(helper(matrix, 0, i), min);
        }
        return min;
    }

    private int helper(int[][] matrix, int r, int c) {
        // Correct base case with proper bounds check
        if (r == matrix.length - 1 && c >= 0 && c < matrix[0].length) {
            return matrix[r][c];
        }

        if (c < 0 || c >= matrix[0].length) return Integer.MAX_VALUE;

        int case1 = Integer.MAX_VALUE;
        if (c - 1 >= 0) {
            if (memo[r + 1][c - 1] == null) {
                memo[r + 1][c - 1] = helper(matrix, r + 1, c - 1);
            }
            case1 = memo[r + 1][c - 1];
        }

        int case2 = Integer.MAX_VALUE;
        if (c + 1 < matrix[0].length) {
            if (memo[r + 1][c + 1] == null) {
                memo[r + 1][c + 1] = helper(matrix, r + 1, c + 1);
            }
            case2 = memo[r + 1][c + 1];
        }

        int case3;
        if (memo[r + 1][c] == null) {
            memo[r + 1][c] = helper(matrix, r + 1, c);
        }
        case3 = memo[r + 1][c];

        return matrix[r][c] + Math.min(case1, Math.min(case2, case3));
    }
}

