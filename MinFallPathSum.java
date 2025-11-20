// Time Complexity : O(n ^ 2)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        
        int n = matrix.length;

        //This is similar to Paint house pattern
        //Start from the bottom instead of top and always choose min
        for(int i = n - 2; i >= 0; i--) {

            for(int j = 0; j < n; j++) {

                if(j == 0) {

                    matrix[i][j] += Math.min(matrix[i + 1][j], matrix[i + 1][j + 1]);
                }
                else if(j == n - 1) {

                    matrix[i][j] += Math.min(matrix[i + 1][j], matrix[i + 1][j - 1]);
                }
                else {

                    matrix[i][j] += Math.min(matrix[i + 1][j - 1], Math.min(matrix[i + 1][j], matrix[i + 1][j + 1]));
                }
            }
        }

        //now cal min from top row
        int result = Integer.MAX_VALUE;
        for(int j = 0; j < n; j++) {
            result = Math.min(result, matrix[0][j]);
        }

        return result;
    }
}
//TC :- O(n ^ 2)
//SC :- O(1)