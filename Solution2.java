//Time complexity: O(N^2), where N is the size of matrix.
//Space complexity: O(1), since no extra space is used. 
// Did this code successfully run on Leetcode : https://leetcode.com/submissions/detail/516182374/

class Solution2 {
    public int minFallingPathSum(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return Integer.MIN_VALUE;
        
        int n = matrix.length;

        // applied bottom up approach similar to paint house problem.
        for(int i=n-2; i>=0; i--) {
            for(int j=0; j<n; j++) {
                if(j == 0) matrix[i][j] += Math.min(matrix[i+1][j], matrix[i+1][j+1]); 
                else if(j == n-1) matrix[i][j] += Math.min(matrix[i+1][j-1], matrix[i+1][j]); 
                else matrix[i][j] += Math.min(matrix[i+1][j], Math.min(matrix[i+1][j-1], matrix[i+1][j+1])); 
            }
        }
        
        int min = Integer.MAX_VALUE;
        for(int j=0; j<n; j++) {
            min = Math.min(min, matrix[0][j]);
        }
        return min; 
    }
}