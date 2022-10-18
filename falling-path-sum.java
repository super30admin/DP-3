// TC: O(n*r)
// SC: O(r)

// Approach: The basic recusrion -- try in 3 different ways and pick the minimum.


class Solution {
  public int minFallingPathSum(int[][] matrix) {
    int n = matrix.length;
    int res = Integer.MAX_VALUE;
    int[][] dp = new int[n][n];

    for(int[] arr: dp)
      Arrays.fill(arr, -1);

    for(int i=0; i<n; i++) {
      res = Math.min(res, solve(matrix, 0, i, n, dp));
    }
    return res;
  }

  private int solve(int[][] matrix, int row, int col, int n, int[][] dp) {

    // valid base case
    if(row >= n)
      return 0;

    // invalid base case
    if(col < 0 || col >= n)
      return Integer.MAX_VALUE-1;

    if(dp[row][col] != -1)
      return dp[row][col];

    // recursion calls
    int fr =  solve(matrix, row+1, col-1, n, dp);

    if(fr != Integer.MAX_VALUE-1)
      fr = fr + matrix[row][col];

    int sr =  solve(matrix, row+1, col, n, dp);

    if(sr != Integer.MAX_VALUE-1)
      sr = sr + matrix[row][col];

    int tr =  solve(matrix, row+1, col+1, n, dp);

    if(tr != Integer.MAX_VALUE-1)
      tr = tr + matrix[row][col];


    return dp[row][col] = Math.min(fr, Math.min(sr, tr));
  }
}