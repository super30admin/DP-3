public class MinimumFallingPath {

  /**
   * 
   * Updating Matrix in-place and performing a Bottom - top  approach on the matrix.
   * 
   * Starting with the last - 1 row on the matrix, start calculating the minimum path for all paths at each Index.
   *  Perform this for every row until you reach the first row. Once this is complete, the first row on the Matrix has minimum path sum 
   *  you can get for every number on the first row. Picking the minimum on the first row should give the Minimum falling path on the Matrix.
   * 
   * 
   * Time Compelxity: O(n * n)
   * Space Complexity : O(1) -> no extra space used.
   * 
   */
  public int minFallingPathSum(int[][] matrix) {
        
    // Updating the Matrix in- place.
    for(int i = matrix.length - 2; i >= 0; i--){
        for(int j = 0; j < matrix[0].length; j++){
            if(j == 0){ // for the first element on a row.
                matrix[i][j] = matrix[i][j] + Math.min(matrix[i+1][j], matrix[i+1][j+1]);
            } else if(j == matrix[0].length - 1){ // for the last element on the row.
                matrix[i][j] = matrix[i][j] + Math.min(matrix[i+1][j], matrix[i+1][j-1]);
            } else { // for any middle elements on a row.
                matrix[i][j] = matrix[i][j] + Math.min(matrix[i+1][j], Math.min(matrix[i+1][j-1], matrix[i+1][j+1]));
            }
        }
    }
    
    int min = Integer.MAX_VALUE;
    
    for(int i = 0; i < matrix[0].length; i++){
        min = Math.min(min, matrix[0][i]);
    }
    
    return min;
  }
}
