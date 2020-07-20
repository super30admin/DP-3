//TC: O(n*n), n: length of the given array A
//SC: O(n*n)
//Approach:
//1. We can reduce this problem to paint house, where we know that what to take in the current row given the previous row.
//2. Extra constraints here are, the columns in the subsequent rows can differ by atmost 1. So, we create dp[][] of size length(A)*length(A).
//3. On the corners, we take the minimum out of the last row same column and last row adjacent column. [(i-1,j), (i-1,j-1)] or [(i-1,j), (i-1,j+1)
//3. In the middle part of the matrix, we have three options to compare, [(i-1,j), (i-1,j-1), (i-1)(j+1)]
//4. We keep taking the minimum elements like this and the element at last row last column gives us the minimum falling path sum.

class Solution {
    public int minFallingPathSum(int[][] A) {
        int[][] dp = new int[A.length][A.length];
        for(int i = 0; i < A.length; i++){
            dp[0][i] = A[0][i];
        }
      
        for(int i = 1; i < A.length; i++){
            for(int j = 0; j < A.length; j++){
                if(j == 0){
                    dp[i][j] = A[i][j] + Math.min(dp[i-1][j], dp[i-1][j+1]);
                }
                else if(j == A.length - 1){
                    dp[i][j] = A[i][j] + Math.min(dp[i-1][j], dp[i-1][j-1]);
                }
                else{
                    dp[i][j] = A[i][j] + Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i-1][j+1]));
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for(int x : dp[A.length-1]){
            res = Math.min(res, x);
        }
        return res;
    }
}
