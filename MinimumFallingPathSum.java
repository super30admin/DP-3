// Time Complexity : O(n*m)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class MinimumFallingPathSum {

        public int minFallingPathSum(int[][] matrix) {
            for (int i =matrix.length-1;i>0;i--){
                for (int j = 0; j<matrix[0].length;j++){
                    int left = Integer.MAX_VALUE;
                    if (j-1 >= 0) left = matrix[i][j-1];
                    int middle = matrix[i][j];
                    int right = Integer.MAX_VALUE;
                    if (j+1 < matrix.length) right = matrix[i][j+1];
                    matrix[i-1][j] += Math.min(left, Math.min(middle,right));
                }
            }
            int min = matrix[0][0];
            for (int i=0;i<matrix[0].length; i++){
                min = Math.min(min, matrix[0][i]);
            }
            return min;
        }
    
}
