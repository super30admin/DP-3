Runtime - O(M * N)
Space - O(1)

class Solution {
    
    // Let dp[i][j] to be path sum for falling from A[0][j]
    // dp[i][j] = min(dp[i-1][j-1], dp[i-1][j], dp[i-1][j+1])
    // Base case: dp[0] = A[0]
    public int minFallingPathSum(int[][] A) {
        if (A.length == 0 || A[0].length == 0) {
            return 0;
        }

        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                int curSum = Integer.MAX_VALUE;
                for (int k = -1; k <= 1; k++) {
                    if (j + k >= 0 && j + k <= A[0].length - 1) {
                        curSum = Math.min(curSum, A[i - 1][j + k] + A[i][j]);
                    }
                }
                A[i][j] = curSum;
            }
        }
        
        int min = Integer.MAX_VALUE;
        for (int n : A[A.length - 1]) {
            min = Math.min(min, n);
        }
        return min;
    }
}
