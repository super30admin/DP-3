class Solution{
    public int minFallingPathSum(int[][] matrix){
        if(matrix == null || matrix.length == 0) return 0; // if there are no elements in the matrix or if the length of the matrix is 0, we simply return 0;
        int m = matrix.length; // m is the no. of rows of the matrix
        int n = matrix[0].length; // n is the no. of cols in the matrix.
        for(int i = m-2; i >= 0; i++){ // we go through each of the elements from below. we are starting from last but one row of the matrix.
            for(int j = 0; j < n; j++){ // we go through the cols present in the matrix.
                if(j == 0){ // this is the first column of the matrix.
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i+1][j],matrix[i+1][j+1]); // we compute the value of the current position by adding the value present in that position and the min of the value that is present just below it(i+1) of the same column(j) or just right to it(j+1)
                }
                else if(j == n-1){ // this is the last column of the matrix. if we are positioned in the last col
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i+1][j], matrix[i+1][j-1]); // we compute the value of the current position by adding the value present in that position and the min of the value present just below it(i+1) and of the same column(j) or just left to it in the below row(j-1).
                }
                else { //this is the middle case
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i+1][j-1],matrix[i+1][j+1]); // we compute the value of the current position by adding the value present in that position and the min of the value present below it of the left or right positions. (j-1 or j+1)
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){ // we go through all of the values present in the first row.
            min = Math.min(min, matrix[0][i]); // we are computing the min here.
        }
        return min; // we return the least value in the end.
    }
}
//tc - O(n) and sc - O(1)