/*
MIN FALLING PATH SUM
approach: dynamic programming
time: O(nxn)
space: O(1)
 */
public class Problem2 {
    public int minFallingPathSum(int[][] matrix) {

        if(matrix==null||matrix.length==0) return 0;

        if(matrix.length==1) return matrix[0][0];

        int min = Integer.MAX_VALUE;
        for(int i=1;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(j==0) {
                    matrix[i][j] = matrix[i][j]+Math.min(matrix[i-1][j], matrix[i-1][j+1]);

                }
                else if(j==matrix[0].length-1) {
                    matrix[i][j] = matrix[i][j]+Math.min(matrix[i-1][j], matrix[i-1][j-1]);

                }
                else{
                    matrix[i][j] = matrix[i][j]+Math.min(matrix[i-1][j], Math.min(matrix[i-1][j-1], matrix[i-1][j+1]));

                }
                if(i==matrix.length-1)
                    if(matrix[i][j]<min) min = matrix[i][j];
            }
        }

        return min;
    }
}
