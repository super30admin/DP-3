// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        //base case if the matrix is empty
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;
        
        //storing sizes of rows and columns in variables
        int m = matrix.length;
        int n = matrix[0]. length;
        
        //if matrix manipulation is not allowed, we make a new one for us
        int[][] minMatrix = new int[m][n];
        
        //start with the same top row as the original matrix
        for(int i = 0; i < n; i++){
            minMatrix[0][i] = matrix[0][i];
        }
        
        
        for(int i = 1; i < m; i++){
            for(int j = 0; j < n; j++){
                
                //since j is 0, we check the top box or the top diagonal box
                if(j == 0){
                    minMatrix[i][j] = Math.min(minMatrix[i - 1][j], minMatrix[i - 1][j + 1]);
                }
                //if it is the last box then we check the diagonally top left box or the top box
                else if(j == n - 1){
                    minMatrix[i][j] = Math.min(minMatrix[i - 1][j - 1], minMatrix[i - 1][j]);
                }
                else{
                    minMatrix[i][j] = Math.min(minMatrix[i - 1][j - 1], minMatrix[i - 1][j]);
                    minMatrix[i][j] = Math.min(minMatrix[i][j], minMatrix[i - 1][j + 1]);
                }
                minMatrix[i][j] += matrix[i][j];
            }
        }
        
        int min = Integer.MAX_VALUE;
        for(int num: minMatrix[m - 1]){
            min = Math.min(min, num);
        }
        
        return min;
    }
}