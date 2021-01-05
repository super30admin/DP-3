// Time Complexity : O(n^2)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

public class Falling_Path {
    public int minFallingPathSum(int[][] A) {

        //start from bottom of matrix
        for(int i = A.length - 2; i >= 0; i--){
            for(int j = 0; j < A[0].length; j++){
                //add minimum possible value for each row/current element

                //case if first in row
                if(j == 0){
                    A[i][j] = A[i][j] + Math.min(A[i+1][j+1],A[i+1][j]);
                }
                //case if last in row
                else if(j == A[0].length - 1){
                    A[i][j] = A[i][j] + Math.min(A[i+1][j-1],A[i+1][j]);
                }
                else{
                    //case if not first or last
                    A[i][j] = A[i][j] + Math.min(A[i+1][j-1],Math.min(A[i+1][j],A[i+1][j+1]));
                }
            }
        }

        int min = Integer.MAX_VALUE;

        //find min path based on values at the top
        for(int i = 0; i < A[0].length; i++){
            if(A[0][i] < min){
                min = A[0][i];
            }
        }

        return min;
    }
}