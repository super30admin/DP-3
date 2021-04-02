/*
Time Complexity : O(m*n)
Space Complexity: O(1)
*/
    // Did this code successfully run on Leetcode : yes
    // Any problem you faced while coding this : no
    // Your code here along with comments explaining your approach
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        if(matrix==null||matrix.length==0){
            return 0;
        }
        //using top down approach
        //iterate through the matrix starting from first row 
        for(int i=1;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                //if j=0, then the element can derive the min element from first and second col 
                if(j==0){
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i-1][j],matrix[i-1][j+1]);
                }
                //ehrn j=last col then the element can derive the min element from last and last but one col 
                else if(j==matrix[0].length-1){
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i-1][j],matrix[i-1][j-1]);
                }
                //otherwise its the middle element
                else{
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i-1][j],Math.min(matrix[i-1][j-1],matrix[i-1][j+1]));
                }
            }
        }
    
        int min = matrix[matrix.length-1][0];
        //get the minimum element from the last row which has the final result
        for(int i=0;i<matrix[0].length;i++){
            min = Math.min(min,matrix[matrix.length-1][i]);
        }                                                                                                           
        return min;   
    }
}