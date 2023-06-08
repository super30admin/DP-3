// Time Complexity : O(n^2) (since the rows and columns are equal)
// Space Complexity : O(1) (since we are modifying the orginal array without using DP array)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/* Greedy approach fails so we use bottom up dynamic programming.
This is similar to house coloring problem.
Start from last but on row and add the minimum of the below two possible elements until we reach the first row.
First row has the sum of the path  and we take the minimum of first row. 
 * 
*/
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;
        int m = matrix.length;
        //bottom up approach
        //so start adding from last but one row
        for(int i = m-2;i>=0;i--){
            for(int j=0;j<m;j++){
                if(j==0){//if the element is at the first column then it wpuld not have left diagonal
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i+1][j],matrix[i+1][j+1]);
                }
                else if(j==m-1){//if the element is at the last column then it wpuld not have right diagonal
                    matrix[i][j] = matrix[i][j]+ Math.min(matrix[i+1][j],matrix[i+1][j-1]);
                }
                else{//if its the column between first and last
               matrix[i][j] = matrix[i][j]+ Math.min(matrix[i+1][j-1],Math.min(matrix[i+1][j],matrix[i+1][j+1]));
                }
            }
        }
 int min = Integer.MAX_VALUE;
 //iterate through the first row and add the minimum.
        for(int j=0;j<m;j++){
            min = Math.min(min,matrix[0][j]);
        }
        return min;
    }
}