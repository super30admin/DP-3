// Time Complexity : O(n * m) where n = rows and m = columns
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/**
 * For each row and column, we have 1,2 or 3 choices from aboce row.
 * So for each column from row 1, we take minimum value between available possible column values from above row.
 * This way in last row, we get all possible results so we take minimum between them and that is our ans.
*/
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        if(matrix == null || matrix.length == 0)return 0;
        
        for(int r = 1; r < matrix.length;r++){
            for(int c = 0; c < matrix[0].length;c++){
                if(c == 0){
                    matrix[r][c] += Math.min(matrix[r-1][c], matrix[r-1][c+1]); 
                }else if(c == matrix[0].length-1){
                    matrix[r][c] += Math.min(matrix[r-1][c], matrix[r-1][c-1]); 
                }else{
                    matrix[r][c] += Math.min(matrix[r-1][c], Math.min(matrix[r-1][c-1], matrix[r-1][c+1])); 
                }
            }
        }
        
        int ans = Integer.MAX_VALUE;
        
        for(int c = 0; c < matrix[0].length; c++){
            ans = Math.min(matrix[matrix.length - 1][c], ans);
        }
        return ans;
    }
}