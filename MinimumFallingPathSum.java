//Time Complexity- O(n*m)
//Space Complexity=O(n*m)
public class MinimumFallingPathSum {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int dp[][] = new int[n + 1][m + 1];

        for(int i = n - 1; i >= 0; i--){
            for(int j = 0; j < m; j++){
                if(j == 0){
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + matrix[i][j];
                }
                else if(j == m - 1){
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j - 1]) + matrix[i][j];
                }else{
                    dp[i][j] = Math.min(dp[i + 1][j - 1], Math.min(dp[i + 1][j], dp[i + 1][j + 1])) + matrix[i][j];
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for(int col_num = 0; col_num < m; col_num++){
            min = Math.min(min, dp[0][col_num]);
        }
        return min;
    }

    public static void main(String[] args) {
        MinimumFallingPathSum minimumFallingPathSum=new MinimumFallingPathSum();
        System.out.println(minimumFallingPathSum.minFallingPathSum(new int[][]{{2,1,3},{6,5,4},{7,8,9}}));
    }
}
