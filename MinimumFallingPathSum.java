

// Time Complexity : Add : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class MinimumFallingPathSum {
    public static void main(String[] args) {
        int[][] matrix  = {{2,1,3},{6,5,4},{7,8,9}};
        minFallingPathSum(matrix);
    }


    public static int minFallingPathSum(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        int result = Integer.MAX_VALUE;
        int max = Integer.MAX_VALUE;

        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                //Keeping the first row as it is
                if(i != 0){
                    //For index out of bounds, assigning the max value
                    matrix[i][j] += Math.min((j-1)<0?max:matrix[i-1][j-1], Math.min(matrix[i-1][j], ((j+1)>=col)?max:matrix[i-1][j+1]));
                }
                if(i==row-1){
                    //Getting the minimum result from the last row
                    result = Math.min(result, matrix[i][j]);
                }
            }
        }
        return result;
    }
}

//2 1 3
//6 5 4
//7 8 9
