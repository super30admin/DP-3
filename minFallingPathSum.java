class Solution {
    public int minFallingPathSum(int[][] matrix) {
        // Time Complexity : O(n2)
        // Space Complexity : O(1)
        if (matrix == null || matrix.length == 0) return 0;
        for (int i=matrix.length-2; i>=0; i--) {
            // left most element
            matrix[i][0] += Math.min(matrix[i+1][0], matrix[i+1][1]);
            // middle elements
            for (int j=1; j<=matrix.length-2; j++)
                matrix[i][j] += Math.min(matrix[i+1][j-1], Math.min(matrix[i+1][j], matrix[i+1][j+1]));
            // right most element
            matrix[i][matrix.length-1] += Math.min(matrix[i+1][matrix.length-1], matrix[i+1][matrix.length-2]);
        }
        
        int min = Integer.MAX_VALUE;
        for (int i=0; i<matrix.length; i++) 
            min = Math.min(min, matrix[0][i]);
        
        return min;
    }
}