//check minimum from the last row. 
//Time complexity: O(n^2)
//Space complexity: O(1)
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        for(int i=matrix.length-2;i>=0;i--) {
            for(int j=0;j<matrix.length;j++) {
                int min = matrix[i+1][j];
                if(j > 0) {
                    min = Math.min(min, matrix[i+1][j-1]);
                }
                if(j < matrix.length-1) {
                    min = Math.min(min, matrix[i+1][j+1]);
                }
                matrix[i][j]+=min;
            }
        }
        int result = matrix[0][0];
        for(int i:matrix[0]) {
            result = Math.min(result, i);
        }
         return result;
    }
}