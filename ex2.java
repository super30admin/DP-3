//TC : O(n^2) and SC : O(1)
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int N = matrix.length;
    for (int r = N - 2; r >= 0; --r) {
      for (int c = 0; c < N; ++c) {
        int best = matrix[r + 1][c];
        if (c > 0)
          best = Math.min(best, matrix[r + 1][c - 1]);
        if (c + 1 < N)
          best = Math.min(best, matrix[r + 1][c + 1]);
        matrix[r][c] += best;
      }
    }
    int ans = Integer.MAX_VALUE;
    for (int x : matrix[0])
      ans = Math.min(ans, x);
    return ans;
    }
}