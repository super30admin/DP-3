class MinimumFallingPath {

    // Time Complexity : 0(m*n)
// Space Complexity : 0(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach: I went to the 2nd last row of my input matrix. Then placed 3
    //conditions inside my nested for loop, here if the element is from 1st column, then it will take the sum of minimum from
    //the row below it and row below and next column, similarly for the element in the last column. And for middle element,
    //it has three options. Hence when the traversal is completed, my top row will hold the minimum element. I compare and
    //return the minimum from top row.


    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i = m-2; i >= 0; i--){
            for(int j = 0; j < m; j++){
                if(j == 0){
                    matrix[i][j] += Math.min(matrix[i+1][j], matrix[i+1][j+1]);
                }
                else if(j == n-1){
                    matrix[i][j] += Math.min(matrix[i+1][j], matrix[i+1][j-1]);
                }
                else{
                    matrix[i][j] += Math.min(matrix[i+1][j-1], Math.min(matrix[i+1][j], matrix[i+1][j+1]));
                }
            }
        }
        int least = Integer.MAX_VALUE;;
        for(int i = 0; i < n; i++){
            least = Math.min(least, matrix[0][i]);
        }
        return least;
    }
}