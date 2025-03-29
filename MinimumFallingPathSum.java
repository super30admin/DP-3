// Time Complexity : O(n^2)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach - Keep dp[n+1] to store path sums. Then loop from bottom row to top in matrix, and find path sum, like choose below/right/left cell according to column. store values for each row in temp[n+1] array and at end of each row iteration copy temp to dp array. At the end, loop in dp array from 0 to n return min value.

public class MinimumFallingPathSum {
    public int minFallingPathSum(int[][] matrix) {
        //create dp[] to store sums of falling path sum for each column
        int n = matrix.length;
        int[] dp = new int[n + 1];

        for(int i = n - 1; i >= 0; i--) {
            int[] currRow = new int[n + 1];
            for(int j = 0; j < n; j++) {
                if(j == 0) {    //left most column so 2 choices, below or diagonal right and add that cell value
                    currRow[j] = Math.min(dp[j], dp[j + 1]) + matrix[i][j];
                } else if(j == n - 1) { //right most column so 2 choices, below or diagonal left and add that cell value
                    currRow[j] = Math.min(dp[j], dp[j - 1]) + matrix[i][j];
                } else {    //middle column cases, so 3 options, below or diagonal left/right and add that cell value
                    currRow[j] = Math.min(dp[j], Math.min(dp[j - 1], dp[j + 1])) + matrix[i][j];
                }
            }
            //update dp array with temp array values in currRow array
            dp = currRow;
        }

        int minSum = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            minSum = Math.min(minSum, dp[i]);
        }
        return minSum;
    }

    public static void main(String[] args) {
        MinimumFallingPathSum sol = new MinimumFallingPathSum();

        int[][] matrix1 = {{-48}};
        System.out.println("Single element [[-48]] -> " + sol.minFallingPathSum(matrix1));

        int[][] matrix2 = {
                {2, 1, 3},
                {6, 5, 4},
                {7, 8, 9}
        };
        System.out.println("3x3 [[2,1,3],[6,5,4],[7,8,9]] -> " + sol.minFallingPathSum(matrix2));

        int[][] matrix3 = {
                {1, 2},
                {-5, 3}
        };
        System.out.println("2x2 -> " + sol.minFallingPathSum(matrix3));
    }
}
