// Time Complexity : O(n^2) since n x n matrix is given and n is the number of rows and columns
// Space Complexity :O(1)
// Did this code successfully run on Leetcode  : yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
public class MinFallingPath {
        public int minFallingPathSum(int[][] matrix) {
            //null check
            if(matrix ==  null || matrix.length == 0)
                return 0;

            int n = matrix.length;

            // dp matrix
            int[][] dp = new int[n][n];
            int min=Integer.MAX_VALUE;

            for(int i = 0 ; i < n ; i++){
                for(int j = 0 ; j < n ; j++){

                    //if i == 0 so its a first row, put the first row of matrix in dp first row as it is
                    if(i==0){
                        dp[i][j] = matrix[i][j];
                    }

                    //if j == 0 so its a first element in that row so we should only check the one above and the one above on right
                    else if(j == 0) {
                        dp[i][j] = Math.min(matrix[i][j] + dp[i-1][j],
                                matrix[i][j] + dp[i-1][j+1]);
                    }

                    //if j == n-1 so its a last element in that row so we should only check the one above and the one above on left
                    else if(j == n-1){
                        dp[i][j] = Math.min(matrix[i][j] + dp[i-1][j],
                                matrix[i][j] + dp[i-1][j-1]);
                    }

                    //if j > 0 && j < n-1 so its not first or element in that row so we should check the one above,the one above on left and the one above on right
                    else if(j > 0 && j < n-1){
                        dp[i][j] = Math.min(matrix[i][j] + dp[i-1][j],
                                Math.min(matrix[i][j] + dp[i-1][j-1],
                                        matrix[i][j] + dp[i-1][j+1]));
                    }

                    //since we need min, find the min in the last row iteration
                    if(i == n-1)
                        min = Math.min(min,dp[i][j]);
                }
            }
            return min;
        }
}
