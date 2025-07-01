// This solution uses DP to calculate the minimum falling path sum
// TC: O(n^2) --> single pass of the matrix
// SC: O(1) --> constant space 

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        if(matrix == null || matrix[0].length == 0){
            return 0;
        }

        int n = matrix.length;

        for(int i=n-2;i>=0;i--){
            for(int j=0;j<n;j++){
              // if it is in the corner, we only check below two elements
                if(j==0){
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i+1][j],
                    matrix[i+1][j+1]);
                }
                else {
                    // if it is in the corner, we only check below two elements
                    if(j == n-1){
                        matrix[i][j] = matrix[i][j] + Math.min(matrix[i+1][j-1], matrix[i+1][j]);
                    }
                    else {
                        // if it is not in the corner, we check below three elements
                        matrix[i][j] = matrix[i][j] + Math.min(matrix[i+1][j-1], Math.min(matrix[i+1][j], matrix[i+1][j+1]));
                    }
                }
            }
        }

        // Find minimum of the first row and return
        int min = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            min = Math.min(min, matrix[0][i]);
        }
        return min;
    }
}
