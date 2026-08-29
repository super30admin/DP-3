//Time Complexity = O(n^2)
//Space Complexity = O(n);
public class MinFallingPath {
    public int minFallingPathSum(int[][] matrix) {
        int min = Integer.MAX_VALUE;
        int n = matrix.length;

        int[] dp = new int[n];

        for(int j = 0; j < n; j++) {
            dp[j] = matrix[0][j];
        }

        for(int i = 1; i < n; i++) {
            int prev = dp[0];

            for(int j = 0; j < n; j++) {
                int temp = dp[j];

                if(j == 0) {
                    dp[j] = matrix[i][j] + Math.min(dp[j+1], dp[j]);
                } else if(j == n-1) {
                    dp[j] = matrix[i][j] + Math.min(dp[j], prev);
                } else {
                    dp[j] = matrix[i][j] + Math.min(Math.min(dp[j],prev), dp[j+1]);
                }
                prev = temp;
            }
        }

        for(int a: dp) {
            min = Math.min(min, a);
        }

        return min;
    }
}
