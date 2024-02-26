// Brute Force Exhaustive Solution
// Time Complexity: m*2^n where m is no of columns and n is number of rows
// class Solution {
// public int minFallingPathSum(int[][] matrix) {

// int min = Integer.MAX_VALUE;

// for(int i =0; i< matrix[0].length; i++){

// min = Math.min(helper(matrix, 0, i), min);

// }

// return min;

// }

// private int helper(int[][] matrix, int r, int c){

// //base

// if(r < 0 || r >= matrix.length || c <0 || c >= matrix[0].length) return Integer.MAX_VALUE;

// if(r == matrix.length - 1 && (c >=0 || c < matrix[0].length)) return matrix[r][c];

// //logic

// //case1

// int case1 = helper(matrix, r+1, c-1);

// //case2

// int case2 = helper(matrix, r+1, c+1);;

// //case3

// int case3 = helper(matrix, r+1, c);

// return matrix[r][c] + Math.min(case1, Math.min(case2,case3));

// }

// }

// Most Optimal Solution: Tabulation
// Time Complexity: m*n. Number of rows*Number of Columns
// Space Complexity: O(n)

// class Solution {

// public int minFallingPathSum(int[][] A) {

// int n=A.length;

// int dp[] = new int[n];

// for(int j=0;j<n;j++){

// dp[j]=A[n-1][j];

// }

// for(int i=n-2;i>=0;i--){

// int left = 0;

// for(int j=0;j<n;j++){

// int temp = dp[j];

// if(j == 0){

// dp[j]=A[i][j]+Math.min(dp[j],dp[j+1]);

// } else if(j== n - 1){

// dp[j]=A[i][j]+Math.min(dp[j],left);

// } else {

// dp[j]=A[i][j]+Math.min(dp[j],Math.min(dp[j+1],left));

// }

// left = temp;

// }

// }

// int min=Integer.MAX_VALUE;

// for(int j=0;j<n;j++){

// if(min>dp[j]) min=dp[j];

// }

// return min;

// }

// }

// Solution: Tablulation
// Time Complexity: m*n. Number of rows*Number of Columns
// Space Complexity: m*n

// class Solution {

// public int minFallingPathSum(int[][] A) {

// int n=A.length;

// int dp[][] = new int[n][n];

// for(int i=0;i<n;i++){

// dp[0][i]=A[0][i];

// }

// for(int i=1;i<n;i++)

// {

// for(int j=0;j<n;j++){

// if(j==0) dp[i][j]=A[i][j]+Math.min(dp[i-1][j],dp[i-1][j+1]);

// else if(j==n-1) dp[i][j]=A[i][j]+Math.min(dp[i-1][j],dp[i-1][j-1]);

// else dp[i][j]=A[i][j]+Math.min(dp[i-1][j],Math.min(dp[i-1][j+1],dp[i-1][j-1]));

// }

// }

// int min=Integer.MAX_VALUE;

// for(int i=0;i<n;i++){

// if(min>dp[n-1][i]) min=dp[n-1][i];

// }

// return min;

// }

// }

// Solution: Memoization
// Time Complexity: m*n. Number of rows*Number of Columns
// Space Complexity: m*n

class MinimumFallingPathSum {

    Integer [][] memo;

    public int minFallingPathSum(int[][] matrix) {

        memo = new Integer[matrix.length][matrix[0].length];

        int min = Integer.MAX_VALUE;

        for(int i =0; i< matrix[0].length; i++){

            min = Math.min(helper(matrix, 0, i), min);

        }

        return min;

    }

    private int helper(int[][] matrix, int r, int c){

        //base

        // if(r < 0 || r >= matrix.length || c <0 || c >= matrix[0].length) return Integer.MAX_VALUE;

        if(r == matrix.length - 1 && (c >=0 || c < matrix[0].length)) return matrix[r][c];

        //logic

        //case1

        int case1 = 99999;

        if(c-1 >=0){

            if(memo[r+1][c-1] == null){

                case1 = helper(matrix, r+1, c-1);

                memo[r+1][c-1] = case1;

            }

            case1 = memo[r+1][c-1];

        }

        //case2

        int case2 = 99999;

        if(c+1 < matrix[0].length){

            if(memo[r+1][c+1] == null){

                case2 = helper(matrix, r+1, c+1);

                memo[r+1][c+1] = case2;

            }

            case2 = memo[r+1][c+1];

        }

        //case3

        int case3 = 99999;

        if(memo[r+1][c] == null){

            case3 = helper(matrix, r+1, c);

            memo[r+1][c] = case3;

        }

        case3 = memo[r+1][c];

        return matrix[r][c] + Math.min(case1, Math.min(case2,case3)); }
}