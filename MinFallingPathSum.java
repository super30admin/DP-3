/*
Time Complexity - O( m * n), where m is the no. of rows in matrix and n is no. of cols. 
Space Complexity - O(m * n).
*/
class Solution {
    int minSum = Integer.MAX_VALUE;

    public int minFallingPathSum(int[][] matrix) { 
        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        int[][] minSum = new int[rowLen][colLen];
        for(int i = 0; i < colLen; i++) 
            minSum[rowLen - 1][i] = matrix[rowLen - 1][i];
            
        for(int i = rowLen - 2; i >= 0; i--)
            for(int j = 0; j < colLen; j++) {
                int left = j > 0 ?           minSum[i + 1][j - 1] : Integer.MAX_VALUE;
                int right = j < colLen - 1 ? minSum[i + 1][j + 1] : Integer.MAX_VALUE;
                minSum[i][j] = matrix[i][j] + Math.min(Math.min(left, right), minSum[i + 1][j]);
            }

        int result = Integer.MAX_VALUE;
        for(int i = 0; i < colLen; i++)
            result = Math.min(result, minSum[0][i]);
        
        return result;
    } 
}
