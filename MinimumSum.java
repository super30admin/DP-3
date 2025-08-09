// This solution focuses on calculating the minimum running sum based on previous numbers. We will check whats the minimum around the paths and update it accordingly. At the end, we iterate over the last row and find the minimum of all
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        for(int i=1;i<matrix.length;i++) {
            for(int j=0;j<matrix[0].length;j++) {
                int a = Math.min(j==0?Integer.MAX_VALUE:matrix[i-1][j-1], matrix[i-1][j]);
                int b = Math.min(j==matrix[0].length-1?Integer.MAX_VALUE:matrix[i-1][j+1], a);
                matrix[i][j] = b+matrix[i][j];
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i=0;i<matrix[0].length;i++) {
            min = Math.min(min, matrix[matrix.length-1][i]);
            
        }
        return min;
    }
}
