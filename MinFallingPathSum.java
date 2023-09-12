
// Time Complexity : O(n^2)
// Space Complexity : O(1) - manipulating the given array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NO

public class MinFallingPathSum {


    public int minFallingPathSum(int[][] matrix) {

        int n = matrix.length;
        for(int i= n-2;i>=0;i--){
            for(int j =0;j<n;j++){
                if(j == 0){
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i+1][j],matrix[i+1][j+1]);
                }else if(j == n-1){
                    matrix[i][j]  = matrix[i][j] + Math.min(matrix[i+1][j],matrix[i+1][j-1]);
                }
                else{

                    matrix[i][j]  = matrix[i][j] +
                            Math.min(matrix[i+1][j+1],Math.min(matrix[i+1][j],matrix[i+1][j-1]));


                }
            }
        }

        int min = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            min = Math.min(min,matrix[0][i]);
        }
        return min;

    }

}
