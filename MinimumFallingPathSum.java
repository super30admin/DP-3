// Time Complexity : O(mn) m = no of rows of matrix , n = no of columns of matrix
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
APPROACH:
initialise a dp matrix of rows = rows of the given matrix and columns = columns of the given matrix
Initialise the first row with first row of guven matrix
starting from row 2, check the least value among the 3: top element, left diagnol top and right diagnol top. whichever is the least, put (least value + matrix[i][j]) in the dp matrix[i][j]
return the minimum value in last row of the dp matrix.
 */

public class MinimumFallingPathSum {

    public static int minFallingPathSum(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(i==0) {
                    dp[i][j] = matrix[i][j];
                } else {
                    if(j == 0){
                        dp[i][j] = Math.min(dp[i-1][j], dp[i-1][j+1]) + matrix[i][j];
                    } else if(j == matrix[0].length - 1){
                        dp[i][j] = Math.min(dp[i-1][j],dp[i-1][j-1]) + matrix[i][j];
                    } else {
                        dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i-1][j+1], dp[i-1][j-1])) + matrix[i][j];
                    }
                }
            }
        }
        int min = dp[dp.length - 1][0];
        for(int k = 1; k<dp[0].length; k++){
            if(dp[dp.length - 1][k] < min){
                min = dp[dp.length - 1][k];
            }
        }
        return min;
    }

    public static void main(String[] args){
        int[][] matrix = {{2,1,3},{6,5,4},{7,8,9}};
        System.out.println(minFallingPathSum(matrix)); //13

        int[][] matrix2 = {{-19,57},{-40,-5}};
        System.out.println(minFallingPathSum(matrix2)); //-59
    }
}
