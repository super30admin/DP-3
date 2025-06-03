// Time Complexity : O(m xn)
// Space Complexity : O(mxn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NA


// Your code here along with comments explaining your approach : coded out recursive and then using memoization



import java.util.*;

public class MinFallingPathSum {

        static int[][] dp;

        public static int minFallingPathSum(int[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;
            dp = new int[m][n];

            for (int[] arr : dp) {
                Arrays.fill(arr, Integer.MAX_VALUE);
            }

            int min = Integer.MAX_VALUE;

            for (int j = 0; j < n; j++) {
                min = Math.min(min, helper(matrix, m, n, 0, j));
            }

            return min;
        }

        private static int helper(int[][] matrix, int m, int n, int i, int j) {
            // base
            if (j < 0 || j >= m || i >= m) {
                return Integer.MAX_VALUE;
            }

            if (i == m - 1)
                return matrix[i][j];

            if (dp[i][j] != Integer.MAX_VALUE) {
                return dp[i][j];
            }

            // logic
            int case1 = helper(matrix, m, n, i + 1, j - 1);
            int case2 = helper(matrix, m, n, i + 1, j);
            int case3 = helper(matrix, m, n, i + 1, j + 1);

            dp[i][j] = matrix[i][j] + Math.min(case1, Math.min(case2, case3));

            return dp[i][j];
        }



    public static void main(String[] args) {
        int[][] matrix = new int[][] {{2,1,3},{6,5,4},{7,8,9}};
        System.out.println(minFallingPathSum(matrix));
    }
}

/*
// time : ( m x 3 ^ n)

//Space : stack space
class Solution {
    public int minFallingPathSum(int[][] matrix) {

        int min = Integer.MAX_VALUE;

        for(int j = 0 ; j < matrix[0].length; j++){
            min = Math.min(min, helper(matrix, 0 , j));
        }

        return min;
    }

    public int helper(int[][] matrix, int i, int j) {

        int m = matrix.length;
        int n = matrix[0].length;

        //base

        if ( i >= m || j < 0 || j >= n) {
            return Integer.MAX_VALUE - 1000;
        }

        if(i == m-1){ //no children after this
            return matrix[i][j];
        }

        //logic
        int case1 = matrix[i][j] + helper(matrix, i + 1, j - 1);

        int case2 = matrix[i][j] + helper(matrix, i + 1, j);

        int case3 = matrix[i][j] + helper(matrix, i + 1, j + 1);

        return  Math.min(Math.min(case1, case2), case3);
    }

}
 */