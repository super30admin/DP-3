// Time Complexity : O(n^2)
// Space Complexity : O(n^2)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no

class Solution {
    public int minFallingPathSum(int[][] A) {
        int m = A.length;
        int n = A[0].length;

        int res = 9999;
        int [][]dp = new int[m][n];
        for(int i = 0; i < n; i++){
            dp[0][i] = A[0][i];
        }

        if(n == 1)
            return A[0][0]; // for one element


        for(int i = 1; i < m; i++){
            for(int j = 0; j < n ; j++){
                if(j == 0){

                    dp[i][j] = A[i][j] + Math.min(dp[i - 1][j], dp[i - 1][j + 1]); // if the column is first
                }

                else if(j == n - 1){

                    dp[i][j] = A[i][j] + Math.min(dp[i - 1][j], dp[i - 1][j - 1]); // if the column is last
                }

                else{
                    dp[i][j] = A[i][j] + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j + 1])); // for the middle columns
                }

                 if(i == n-1){
                    res = Math.min(res, dp[i][j]);   // for the last row get the minimum
                    System.out.println(res);
                 }
            }

        }

       return res;
    }
}