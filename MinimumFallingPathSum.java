// Time Complexity : O(m * n) [ m= matrix.length, n = matrix[0].length]
// Space Complexity : O(m * n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach



import java.util.Arrays;

class MinimumFallingPathSum66 {
    public int minFallingPathSum(int[][] matrix) {

        // return helperBottomUp(matrix);

        //Memoization
        int m = matrix.length;
        int n = matrix[0].length;
        int ans = Integer.MAX_VALUE;

        int[][] dp = new int[m][n];

        //initialzed each bucket values with MAX
        for (int[] arr : dp) {
            Arrays.fill(arr, Integer.MAX_VALUE);
        }

        // Min value of Each Bucket
        for (int j = 0; j < n; j++) {
            ans = Math.min(ans, helperMemoIzation(0, j, matrix, dp));
        }

        return ans;

        //Recursion Solution
        // for (int j = 0; j < n; j++) {
        // ans = Math.min(ans, helperRecursion(0, j, matrix));
        // }
        // return ans;

    }

    // private int helperBottomUp(int[][] matrix) {
    // int n = matrix.length;

    // for (int i = n - 2; i >= 0; i--) {
    // for (int j = n - 1; j >= 0; j--) {
    // if (j == n - 1) {
    // matrix[i][j] = matrix[i][j] + Math.min(matrix[i + 1][j], matrix[i + 1][j -
    // 1]);
    // } else if (j == 0) {
    // matrix[i][j] = matrix[i][j] + Math.min(matrix[i + 1][j], matrix[i + 1][j +
    // 1]);
    // } else {
    // matrix[i][j] = matrix[i][j]
    // + Math.min(Math.min(matrix[i + 1][j], matrix[i + 1][j + 1]), matrix[i + 1][j
    // - 1]);
    // }
    // }
    // }

    // int min = matrix[0][0];
    // for (int i : matrix[0]) {
    // min = Math.min(min, i);
    // }
    // System.out.println(Arrays.deepToString(matrix));
    // return min;
    // }

    private int helperMemoIzation(int i, int j, int[][] arr, int[][] dp) {
        //Base case
        if (i == arr.length) {
            return 0;
        }

        //logic
        if (j < 0 || j >= arr[0].length) {
            return Integer.MAX_VALUE;
        }

        //checks in the dp if values exists
        if (dp[i][j] != Integer.MAX_VALUE) {
            return dp[i][j];
        }

        //goes accroding to the instruction
        int goDwnDiagLeft = helperMemoIzation(i + 1, j - 1, arr, dp);
        int goDwnDiagRight = helperMemoIzation(i + 1, j + 1, arr, dp);
        int goDwn = helperMemoIzation(i + 1, j, arr, dp);

        //return value for the current position
        return dp[i][j] = arr[i][j] + Math.min(goDwnDiagLeft, Math.min(goDwn,
                goDwnDiagRight));

    }

    // private int helperRecursion(int i, int j, int[][] arr) {
    // if (i == arr.length) {
    // return 0;
    // }

    // if (j < 0 || j >= arr[0].length) {
    // return Integer.MAX_VALUE;
    // }

    // int goDwnDiagLeft = helperRecursion(i + 1, j - 1, arr);
    // int goDwnDiagRight = helperRecursion(i + 1, j + 1, arr);
    // int goDwn = helperRecursion(i + 1, j, arr);

    // return arr[i][j] + Math.min(goDwnDiagLeft, Math.min(goDwn, goDwnDiagRight));

    // }
}
