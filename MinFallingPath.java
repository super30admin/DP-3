/**
 * Time complexity : O(N * N) where N is row of matrix
 * Space complexity : O(N * N) where N is row of matrix
 * Did it ran on Leetcode: Yes 
 */

public class MinFallingPath{
    public static void main(String[] args) {
        int[][] matrix = {{2,1,3,6},{6,5,4,2},{7,8,9,1},{8,2,5,9}};
        System.out.println(minFallingPathSum(matrix));
    }

    public static int minFallingPathSum(int[][] matrix) {
        if(matrix == null || matrix.length == 0){
            return 0;
        }
        int n = matrix.length;
        int[][] dp = new int[n][n];
        
        for(int i=0; i<n; i++){
            dp[0][i] = matrix[0][i];
        }
        
        for(int i=1; i<n; i++){
            for(int j=0; j<n; j++){
                int left = Integer.MAX_VALUE;
                int right = Integer.MAX_VALUE;
                
                if(j-1 >= 0){
                    left = dp[i-1][j-1];
                }
                if(j+1 < n){
                    right = dp[i-1][j+1];
                }
                int above = dp[i-1][j];
                dp[i][j] = Math.min(left, Math.min(right, above)) + matrix[i][j];
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            min = Math.min(min, dp[n-1][i]);
        }
        return min;
    }
}