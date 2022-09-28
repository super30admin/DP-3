// T.C : O(MN) where M is number of rows and N is number of cols
// S.C : O(MN) //mutating the same array is also possible, in that case SC = O(1)
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;
        int[][] dp = new int[matrix.length][matrix[0].length];


        for(int i = 0; i<matrix[0].length; i++){
            dp[0][i] = matrix[0][i];
        }

        for(int i = 1; i<matrix.length; i++){
            for(int j = 0; j<matrix[0].length; j++){
                if(j==0){
                    dp[i][j] = Math.min(matrix[i][j]+dp[i-1][j], matrix[i][j]+dp[i-1][j+1]);
                }
                else if(j==matrix[0].length-1){
                    dp[i][j] = Math.min(matrix[i][j]+dp[i-1][j], matrix[i][j]+dp[i-1][j-1]);
                }
                else{
                    dp[i][j] = Math.min(matrix[i][j]+dp[i-1][j], Math.min(matrix[i][j]+dp[i-1][j-1], matrix[i][j]+dp[i-1][j+1]));
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for(int k = 0; k<matrix[0].length; k++){
            min = Math.min(min, dp[matrix.length-1][k]);
        }

        return min;
    }
}