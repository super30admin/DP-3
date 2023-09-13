/* 

Problem2 (https://leetcode.com/problems/minimum-falling-path-sum/)

Time Complexity : O(n^2)
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Approach : Updating the existing values with the possible minimum sum and returning the lowest sum in the last row of the main
array.

*/

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        if(matrix == null || matrix.length == 0){
            return 0;
        }

        int len = matrix.length;
        for(int i = 1; i < len; i++){
            for(int j=0; j < len; j++){

                if(j == 0){
                    matrix[i][j] = Math.min(matrix[i][j] + matrix[i-1][j], matrix[i][j] + matrix[i-1][j+1]);
                }

                else if(j == len-1){
                    matrix[i][j] = Math.min(matrix[i][j] + matrix[i-1][j], matrix[i][j] + matrix[i-1][j-1]);
                }

                else{
                    matrix[i][j] = Math.min(matrix[i][j] + matrix[i-1][j], 
                                   Math.min(matrix[i][j] + matrix[i-1][j-1], 
                                            matrix[i][j] + matrix[i-1][j+1]));
                }
            }

        }
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < len; i++){
            min = Math.min(min, matrix[len-1][i]);
        }

        return min;
    }
}