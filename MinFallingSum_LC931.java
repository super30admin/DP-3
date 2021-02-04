//Time: O(m*n)
// where m = no of rows in coins, n = columns

//Space = O(1) as we are modifying same marix

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        
        //check for empty or null input
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        for(int i = 1; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(j == 0){
                    matrix[i][j] += Math.min(matrix[i-1][j], matrix[i-1][j+1]);
                }
                else if(j == cols - 1){
                    matrix[i][j] += Math.min(matrix[i-1][j], matrix[i-1][j-1]);
                }
                else{
                    matrix[i][j] += Math.min(matrix[i-1][j-1],Math.min(matrix[i-1][j], matrix[i-1][j+1]));
                }
            }
        }
        
        //find min value from last row
        int min = Integer.MAX_VALUE;
        for(int num: matrix[rows-1]){
            if(num < min)
                min = num;
        }
        return min;
    }
}