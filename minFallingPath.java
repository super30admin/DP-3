// Time Complexity : O(mn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
public class minFallingPath {
    public int minFallingPathSum(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;
        if(matrix.length == 1){
            return matrix[0][0];
        }
        int minValue = Integer.MAX_VALUE;
        for(int i = matrix.length-2; i >=0; i--){
            for(int j = 0; j<matrix[0].length; j++){
                if(j==0){
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i+1][j],matrix[i+1][j+1]);
                }
                else if(j == matrix[0].length-1){
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i+1][j],matrix[i+1][j-1]);
                }
                else{
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i+1][j],Math.min(matrix[i+1][j-1], matrix[i+1][j+1]));
                }
                if(i==0){
                    minValue = Math.min(matrix[0][j], minValue);
                }
            }
        }
        return minValue;
    }   
}
