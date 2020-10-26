package S30.DP_3;

/*DP Solution
Time Complexity : Put: O(mn),  m is A.length, n is A[0].length
Space Complexity : O(mn),  m is A.length, n is A[0].length
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None
*/

public class MinimumFallingPathSum {

    public int findMinimumFallingPathSumRecursive(int[][] A){

        if(A == null || A.length == 0) return 0;
        int m = A.length;
        int n = A[0].length;

        int min = Integer.MAX_VALUE;
        for(int j = 0; j < n; j++){
            min = Math.min(min,helper(A,j,1,A[0][j]));
        }

        return min;

    }

    private int helper(int[][] A, int lastIndex, int row, int min){

        if(row == A.length) return min;

        int case1 = Integer.MAX_VALUE;
        int case2 = Integer.MAX_VALUE;
        int case0 = helper(A,lastIndex,row+1,min + A[row][lastIndex]);

        if(lastIndex-1 >=0)
            case1 = helper(A,lastIndex-1,row+1,min + A[row][lastIndex-1]);
        if(lastIndex+1 < A.length)
            case2 = helper(A,lastIndex+1,row+1,min + A[row][lastIndex+1]);

        return Math.min(case0,Math.min(case1,case2));
    }

    public int findMinimumFallingPathSumDP(int[][] A){
        if(A == null || A.length == 0) return 0;

        int[][] dp = new int[A.length][A[0].length];
        int m = dp.length;
        int n = dp[0].length;

        for(int j = 0; j < n; j++){
            dp[0][j] = A[0][j];
        }

        for(int i = 1; i < m; i++){
            for(int j = 0; j < n; j++){

                int min = Integer.MAX_VALUE;
                for(int k = 0; k < n; k++){
                    if(Math.abs(j-k) > 1) continue;
                    min = Math.min(min, dp[i-1][k]);
                }
                dp[i][j] = A[i][j] + min;
            }
        }

        int result = Integer.MAX_VALUE;

        for(int j = 0; j < n; j++){
            result = Math.min(result,dp[m-1][j]);
        }

        return result;


    }
}
