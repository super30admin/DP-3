// Time Complexity : O(n*m)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
//Finding minimum paths starting from the last row-2 and chosing the minumum between minimun from the row below and digonally posite lement
// return minimum for the values from the first row.

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        for(int i=matrix.length-2;i>=0;i--){
            for(int j=0;j<matrix[0].length;j++){
                if(j==0){
                    matrix[i][j] = matrix[i][j]+Math.min(matrix[i+1][j],matrix[i+1][j+1]);
                }else if(j==matrix[0].length-1){
                    matrix[i][j] = matrix[i][j]+Math.min(matrix[i+1][j],matrix[i+1][j-1]);
                }else{
                    matrix[i][j] = matrix[i][j]+Math.min(matrix[i+1][j],Math.min(matrix[i+1][j-1],matrix[i+1][j+1]));
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i=0;i<matrix.length;i++){
            min = Math.min(min,matrix[0][i]);
        }
        return min;
    }
}