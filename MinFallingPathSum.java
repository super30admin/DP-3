// Time Complexity: O(mn)
// Space Complexity: O(mn)
// The problem ran successfully on leetcode

class MinFallingPathSum {
    public int minFallingPathSum(int[][] A) {
        if(A.length == 0) {
            return 0;
        }

        int n = A.length;

        int[][] dp = new int[n][A[0].length];

        for(int x = 0; x<A[0].length; x++) {
            dp[0][x] = A[0][x];
        }

        for(int x=1; x<n; x++) {
            for(int j = 0; j<A[0].length; j++) {
                int sum = dp[x-1][j];

                if(j-1>= 0) {
                    sum = Math.min(sum, dp[x-1][j-1]);
                }
                if(j+1<A[0].length) {
                    sum = Math.min(sum, dp[x-1][j+1]);
                }
                dp[x][j] = A[x][j] + sum;
            }
        }
        int res = dp[n-1][0];
        for(int j = 1; j<dp[0].length; j++) {
            res = Math.min (res, dp[n-1][j]);
        }
        return res;
    }
}