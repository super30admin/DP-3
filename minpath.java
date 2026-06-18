// Time Complexity : O(n^2) 
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach: DP to find min falling path sum. start from the second row and update each cell with the minimum path sum to reach that cell from the row above. Finally, return the minimum value from the last row.
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
      
        for (int r = 1; r < n; r++) {
            for (int c = 0; c < n; c++) {
             
                int minAbove = matrix[r - 1][c];
                
                if (c > 0) {
                    minAbove = Math.min(minAbove, matrix[r - 1][c - 1]);
                }
           
                if (c < n - 1) {
                    minAbove = Math.min(minAbove, matrix[r - 1][c + 1]);
                }
            
                matrix[r][c] += minAbove;
            }
        }

        int minPathSum = Integer.MAX_VALUE;
        for (int val : matrix[n - 1]) {
            minPathSum = Math.min(minPathSum, val);
        }
        
        return minPathSum;
    }
}