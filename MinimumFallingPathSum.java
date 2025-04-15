//The idea here is to use Bottom-up DP using tabulation
//We start from the second from last row and at each index, we take the minimum in the next row and add it to the current number depending on the index
//At the end, we take the minimum among the top row which gives the minimum sum
//Time Complexity: O(n^2)
//Space Complexity: O(1)
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        for(int i = n-2; i>=0; i--){
            for(int j = 0; j < n; j++){
                if(j == 0){
                    matrix[i][j] = Math.min(matrix[i+1][j], matrix[i+1][j+1]) + matrix[i][j];
                } else if(j == n-1){
                    matrix[i][j] = Math.min(matrix[i+1][j], matrix[i+1][j-1]) + matrix[i][j];
                } else {
                    matrix[i][j] = Math.min(matrix[i+1][j+1], Math.min(matrix[i+1][j], matrix[i+1][j-1])) + matrix[i][j];
                }
            }
        }
        int result = Integer.MAX_VALUE;
        for(int j = 0; j < n; j++){
            result = Math.min(result, matrix[0][j]);
        }
        return result;
    }
}